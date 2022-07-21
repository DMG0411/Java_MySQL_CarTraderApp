import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import net.proteanit.sql.DbUtils;

public class SeeYourAds extends JFrame implements ActionListener {
    SeeYourAds() {
        this.setLayout((LayoutManager)null);
        this.getContentPane().setBackground(Color.pink);
        
        final String pin = JOptionPane.showInputDialog((Component)null, "To perform this action please enter your PIN(1/2)");
        String pass = JOptionPane.showInputDialog((Component)null, "To confirm this action please enter your password(2/2)");
        
        if (pin != null && pass != null && pin.length() != 0 && pass.length() != 0) {
            try {
                final SQLConnection conn = new SQLConnection();
                String query = "select * from login where pin = '" + pin + "' and password = '" + pass + "'";
                ResultSet rs = conn.st.executeQuery(query);
                if (rs.next()) {
                    this.setBounds(150, 30, 1015, 700);
                    this.setVisible(true);
                    
                    JLabel midtext = new JLabel("Your posted ads");
                    midtext.setBounds(300, 20, 300, 30);
                    midtext.setFont(new Font("SansSerif", 1, 30));
                    this.add(midtext);
                    
                    ImageIcon image1 = new ImageIcon(ClassLoader.getSystemResource("images/youradhere.jpg"));
                    JLabel largephoto = new JLabel(image1);
                    largephoto.setBounds(650, 100, 300, 300);
                    this.add(largephoto);
                    
                    ImageIcon image2 = new ImageIcon(ClassLoader.getSystemResource("images/MarketAuto.jpg"));
                    JLabel miniature = new JLabel(image2);
                    miniature.setBounds(0, 0, 82, 60);
                    this.add(miniature);
                    
                    //////// Labels
                    
                    JLabel brand = new JLabel("Brand");
                    brand.setBounds(100, 75, 80, 30);
                    brand.setFont(new Font("serif", 3, 18));
                    this.add(brand);
                    
                    JLabel model = new JLabel("Model");
                    model.setBounds(165, 75, 80, 30);
                    model.setFont(new Font("serif", 3, 18));
                    this.add(model);
                    
                    JLabel year = new JLabel(" Year");
                    year.setBounds(235, 65, 100, 30);
                    year.setFont(new Font("serif", 3, 15));
                    this.add(year);
                    
                    JLabel offab = new JLabel("of fabrication");
                    offab.setBounds(225, 75, 100, 30);
                    offab.setFont(new Font("serif", 3, 12));
                    this.add(offab);
                    
                    JLabel km = new JLabel("Km");
                    km.setBounds(300, 75, 100, 30);
                    km.setFont(new Font("serif", 3, 18));
                    this.add(km);
                    
                    JLabel transm = new JLabel("Transmission");
                    transm.setBounds(340, 75, 100, 30);
                    transm.setFont(new Font("serif", 3, 13));
                    this.add(transm);
                    
                    JLabel gas = new JLabel("Gas");
                    gas.setBounds(430, 75, 100, 30);
                    gas.setFont(new Font("serif", 3, 18));
                    this.add(gas);
                    
                    JLabel engine = new JLabel("Engine");
                    engine.setBounds(485, 65, 100, 30);
                    engine.setFont(new Font("serif", 3, 16));
                    this.add(engine);
                    
                    JLabel capacity = new JLabel("capacity");
                    capacity.setBounds(480, 75, 100, 30);
                    capacity.setFont(new Font("serif", 3, 14));
                    this.add(capacity);
                    
                    JLabel color = new JLabel("Color");
                    color.setBounds(540, 75, 100, 30);
                    color.setFont(new Font("serif", 3, 18));
                    this.add(color);
                    
                    JTable table = new JTable();
                    table.setBounds(100, 100, 500, 400);
                    this.add(table);
                    
                    JLabel tip = new JLabel("Tip:Delete your ad by left-clicking on it.");
                    tip.setBounds(200, 500, 300, 30);
                    tip.setFont(new Font("serif", 3, 18));
                    this.add(tip);
                    
                    JButton back = new JButton("Back to MainPage");
                    back.setBounds(750, 600, 200, 30);
                    back.addActionListener(this);
                    back.setActionCommand(SeeYourAds.Actions.BACK.name());
                    back.setForeground(Color.white);
                    back.setBackground(Color.black);
                    this.add(back);

                    try {
                        String query1 = "select brand,model,yearoffab,km,transmission,gastype,capacity,color from carads where pin = '" + pin + "'";
                        ResultSet rs1 = conn.st.executeQuery(query1);
                        table.setModel(DbUtils.resultSetToTableModel(rs1));
                    } catch (Exception var26) {
                        var26.printStackTrace();
                    }

                    table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
                        public void valueChanged(ListSelectionEvent e) {
                            int choose = JOptionPane.showConfirmDialog((Component)null, "Are you sure that you want to delete this ad?", "WARNING", 0);
                            if (choose == 0) {
                                String km = JOptionPane.showInputDialog((Component)null, "Write the kilometers for confimation.");

                                try {
                                    String query2 = "delete from carads where pin = '" + pin + "' and km = '" + km + "'";
                                    int result = conn.st.executeUpdate(query2);
                                    if (result == 1) {
                                        JOptionPane.showMessageDialog((Component)null, "Your ad has been delete succesfully.");
                                        JOptionPane.showMessageDialog((Component)null, "The page will refresh.");
                                        SeeYourAds.this.setVisible(false);
                                        new SeeYourAds();
                                    } else {
                                        JOptionPane.showMessageDialog((Component)null, "An error has occured.");
                                    }
                                } catch (Exception var6) {
                                    var6.printStackTrace();
                                }
                            }

                        }
                    });
                } else {
                    JOptionPane.showMessageDialog((Component)null, "PIN doesn't match with password. Returning to Main Page...");
                    this.setVisible(false);
                    new MainPage();
                }
            } catch (Exception var27) {
                var27.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog((Component)null, "Don't leave empty spaces. Returning to Main Page.");
            this.setVisible(false);
            new MainPage();
        }

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals(SeeYourAds.Actions.BACK.name())) {
            this.setVisible(false);
            new MainPage();
        }

    }

    public static void main(String[] args) {
        new SeeYourAds();
    }

    private static enum Actions {
        BACK;

        private Actions() {
        }
    }
}
