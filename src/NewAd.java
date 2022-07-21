import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class NewAd extends JFrame implements ActionListener {
    Choice brand_choose,gastype1,transm1;
    JLabel brand,model,yearoffab,km,transm,gastype,capacity,color;
    JTextField model1,yearoffab1,km1,capacity1,color1;
    JButton publish,cancel;
    JCheckBox check;

    NewAd() {
        this.setLayout((LayoutManager)null);
        this.getContentPane().setBackground(Color.pink);
        
        ImageIcon image1 = new ImageIcon(ClassLoader.getSystemResource("images/sellcar.jpg"));
        JLabel largephoto = new JLabel(image1);
        largephoto.setBounds(650, 100, 300, 300);
        this.add(largephoto);
        
        ImageIcon image2 = new ImageIcon(ClassLoader.getSystemResource("images/MarketAuto.jpg"));
        JLabel miniature = new JLabel(image2);
        miniature.setBounds(0, 0, 82, 60);
        this.add(miniature);
     
        //////// Labels
        
        JLabel midtext = new JLabel("Create your own ad");
        midtext.setBounds(300, 20, 300, 30);
        midtext.setFont(new Font("SansSerif", 1, 30));
        this.add(midtext);
        
        this.brand = new JLabel("Brand:");
        this.brand.setBounds(260, 85, 60, 30);
        this.brand.setFont(new Font("serif", 3, 20));
        this.add(this.brand);
        
        this.model = new JLabel("Model:");
        this.model.setBounds(260, 115, 100, 30);
        this.model.setFont(new Font("serif", 3, 20));
        this.add(this.model);
        
        this.yearoffab = new JLabel("Year of Fabrication:");
        this.yearoffab.setBounds(260, 150, 160, 30);
        this.yearoffab.setFont(new Font("serif", 3, 17));
        this.add(this.yearoffab);
        
        this.km = new JLabel("Mileage(in km):");
        this.km.setBounds(260, 180, 140, 30);
        this.km.setFont(new Font("serif", 3, 18));
        this.add(this.km);
        
        this.transm = new JLabel("Transmission:");
        this.transm.setBounds(260, 210, 110, 30);
        this.transm.setFont(new Font("serif", 3, 18));
        this.add(this.transm);
        
        this.gastype = new JLabel("GasType:");
        this.gastype.setBounds(260, 240, 75, 30);
        this.gastype.setFont(new Font("serif", 3, 18));
        this.add(this.gastype);
        
        this.capacity = new JLabel("Engine capacity(in cm³):");
        this.capacity.setBounds(260, 270, 180, 30);
        this.capacity.setFont(new Font("serfi", 3, 16));
        this.add(this.capacity);
        
        this.color = new JLabel("Color:");
        this.color.setBounds(260, 300, 140, 30);
        this.color.setFont(new Font("serif", 3, 18));
        this.add(this.color);
        
        JLabel checktxt = new JLabel("Agree to Terms and Conditions");
        checktxt.setBounds(260, 340, 200, 30);
        checktxt.setFont(new Font("serif", 3, 15));
        this.add(checktxt);
        
        this.brand_choose = new Choice();
        this.brand_choose.setBounds(330, 91, 120, 25);
        this.brand_choose.add("Audi");
        this.brand_choose.add("BMW");
        this.brand_choose.add("Chevrolet");
        this.brand_choose.add("Citroen");
        this.brand_choose.add("Dacia");
        this.brand_choose.add("Ford");
        this.brand_choose.add("Honda");
        this.brand_choose.add("Hyundai");
        this.brand_choose.add("Kia");
        this.brand_choose.add("Mazda");
        this.brand_choose.add("Mercedes-Benz");
        this.brand_choose.add("Mitsubishi");
        this.brand_choose.add("Nissan");
        this.brand_choose.add("Opel");
        this.brand_choose.add("Renault");
        this.brand_choose.add("Seat");
        this.brand_choose.add("Skoda");
        this.brand_choose.add("Toyota");
        this.brand_choose.add("Volkswagen");
        this.brand_choose.add("Volvo");
        this.add(this.brand_choose);
        
        this.model1 = new JTextField();
        this.model1.setBounds(330, 120, 130, 25);
        this.add(this.model1);
        
        this.yearoffab1 = new JTextField();
        this.yearoffab1.setBounds(410, 154, 130, 25);
        this.add(this.yearoffab1);
        
        this.km1 = new JTextField();
        this.km1.setBounds(385, 186, 130, 25);
        this.add(this.km1);
        
        this.transm1 = new Choice();
        this.transm1.setBounds(370, 216, 140, 25);
        this.transm1.add("Manual");
        this.transm1.add("Automatic");
        this.add(this.transm1);
        
        this.gastype1 = new Choice();
        this.gastype1.setBounds(335, 245, 130, 25);
        this.gastype1.add("Diesel");
        this.gastype1.add("Gasoline");
        this.gastype1.add("Hybrid");
        this.gastype1.add("Electric");
        this.add(this.gastype1);
        
        this.capacity1 = new JTextField();
        this.capacity1.setBounds(445, 275, 130, 25);
        this.add(this.capacity1);
        
        this.color1 = new JTextField();
        this.color1.setBounds(315, 305, 130, 25);
        this.add(this.color1);
        
        this.check = new JCheckBox();
        this.check.setBounds(460, 349, 20, 14);
        this.check.setBackground(Color.pink);
        this.add(this.check);
        
        ///////// Buttons
        
        this.publish = new JButton("Publish");
        this.publish.setBounds(300, 400, 100, 30);
        this.publish.addActionListener(this);
        this.publish.setActionCommand(NewAd.Actions.PUBLISH.name());
        this.publish.setForeground(Color.white);
        this.publish.setBackground(Color.black);
        this.add(this.publish);
        
        this.cancel = new JButton("Cancel");
        this.cancel.setBounds(450, 400, 100, 30);
        this.cancel.addActionListener(this);
        this.cancel.setActionCommand(NewAd.Actions.CANCEL.name());
        this.cancel.setForeground(Color.white);
        this.cancel.setBackground(Color.black);
        this.add(this.cancel);
        
        this.setBounds(150, 30, 1015, 700);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals(NewAd.Actions.CANCEL.name())) {
            this.setVisible(false);
            new MainPage();
        } else if (ae.getActionCommand().equals(NewAd.Actions.PUBLISH.name())) {
            if (this.model1.getText().length() != 0 && this.yearoffab1.getText().length() != 0 && this.km1.getText().length() != 0 && this.capacity1.getText().length() != 0 && this.color1.getText().length() != 0) {
                if (!this.check.isSelected()) {
                    JOptionPane.showMessageDialog((Component)null, "Please accept Terms and Conditions.");
                } else {
                    String pin = JOptionPane.showInputDialog((Component)null, "To confirm this action please enter your PIN(1/2)");
                    String pass = JOptionPane.showInputDialog((Component)null, "To confirm this action please enter your password(2/2)");
                    if (pin != null && pass != null) {
                        if (pin.length() == 4 && pass.length() >= 8) {
                            try {
                                SQLConnection conn = new SQLConnection();
                                String query = "select * from login where pin = '" + pin + "' and password = '" + pass + "'";
                                ResultSet rs = conn.st.executeQuery(query);
                                if (rs.next()) {
                                    String query1 = "insert into carads(pin, password, brand, model, yearoffab, km, transmission, gastype, capacity, color) values('" + pin + "', '" + pass + "', '" + this.brand_choose.getSelectedItem() + "', '" + this.model1.getText() + "', '" + this.yearoffab1.getText() + "', '" + this.km1.getText() + "', '" + this.transm1.getSelectedItem() + "', '" + this.gastype1.getSelectedItem() + "', '" + this.capacity1.getText() + "', '" + this.color1.getText() + "');";
                                    int x = conn.st.executeUpdate(query1);
                                    if (x == 1) {
                                        JOptionPane.showMessageDialog((Component)null, "Your ad has been created.");
                                        this.setVisible(false);
                                        new MainPage();
                                    }
                                } else {
                                    JOptionPane.showMessageDialog((Component)null, "PIN doesn't match with password");
                                }
                            } catch (Exception var9) {
                                var9.printStackTrace();
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog((Component)null, "Don't leave empty spaces.");
                    }
                }
            } else {
                JOptionPane.showMessageDialog((Component)null, "All fields must be completed.");
            }
        }

    }

    public static void main(String[] args) {
        new NewAd();
    }

    private static enum Actions {
        PUBLISH,
        CANCEL;

        private Actions() {
        }
    }
}
