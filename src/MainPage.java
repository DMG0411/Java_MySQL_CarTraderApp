
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import net.proteanit.sql.DbUtils;

import javax.swing.*;

public class MainPage extends JFrame implements ActionListener {
    ResultSet rs1;
    ResultSet rsz;
    ResultSet rs3;
    JTable table1;
    JTable table2;
    JTextField SearchBar;
    JButton Search;

    MainPage() {
        this.setLayout((LayoutManager)null);
        this.getContentPane().setBackground(Color.pink);
        ImageIcon image2 = new ImageIcon(ClassLoader.getSystemResource("images/MarketAuto.jpg"));
        JLabel miniature = new JLabel(image2);
        miniature.setBounds(0, 0, 82, 60);
        this.add(miniature);
        ImageIcon background = new ImageIcon(ClassLoader.getSystemResource("images/MainPage.jpg"));
        ImageIcon backgroundSized = new ImageIcon(background.getImage().getScaledInstance(1000, 700, 1));
        JLabel backgroundlabel = new JLabel(backgroundSized);
        backgroundlabel.setBounds(0, 0, 1000, 700);
        this.add(backgroundlabel);
        JMenuBar menuBar = new JMenuBar();
        menuBar.setBounds(880, 0, 120, 30);
        backgroundlabel.add(menuBar);
        JMenu Account = new JMenu("Account");
        Account.setPreferredSize(new Dimension(60, 30));
        menuBar.add(Account);
        JMenu Supp = new JMenu("       ?");
        Supp.setPreferredSize(new Dimension(60, 30));
        menuBar.add(Supp);
        JMenuItem Support = new JMenuItem("Support");
        Support.addActionListener(this);
        Support.setActionCommand(MainPage.Actions.SUPPORT.name());
        Support.setPreferredSize(new Dimension(57, 30));
        Supp.add(Support);
        JMenuItem Add = new JMenuItem("Add a new ad");
        Add.addActionListener(this);
        Add.setActionCommand(MainPage.Actions.ADD.name());
        Account.add(Add);
        JMenuItem See = new JMenuItem("See your ads");
        See.addActionListener(this);
        See.setActionCommand(MainPage.Actions.SEE.name());
        Account.add(See);
        JMenuItem Delete = new JMenuItem("Delete Account");
        Delete.addActionListener(this);
        Delete.setActionCommand(MainPage.Actions.DELETE.name());
        Account.add(Delete);
        JMenuItem Disc = new JMenuItem("Disconnect");
        Disc.addActionListener(this);
        Disc.setActionCommand(MainPage.Actions.DISC.name());
        Account.add(Disc);
        JLabel brand = new JLabel("Brand");
        brand.setBounds(160, 170, 80, 30);
        brand.setFont(new Font("serif", 3, 18));
        backgroundlabel.add(brand);
        JLabel model = new JLabel("Model");
        model.setBounds(250, 170, 80, 30);
        model.setFont(new Font("serif", 3, 18));
        backgroundlabel.add(model);
        JLabel year = new JLabel("Year");
        year.setBounds(340, 155, 100, 30);
        year.setFont(new Font("serif", 3, 15));
        backgroundlabel.add(year);
        JLabel offab = new JLabel("of fabrication");
        offab.setBounds(325, 170, 100, 30);
        offab.setFont(new Font("serif", 3, 13));
        backgroundlabel.add(offab);
        JLabel km = new JLabel("Km");
        km.setBounds(430, 170, 100, 30);
        km.setFont(new Font("serif", 3, 18));
        backgroundlabel.add(km);
        JLabel transm = new JLabel("Transmission");
        transm.setBounds(500, 170, 100, 30);
        transm.setFont(new Font("serif", 3, 13));
        backgroundlabel.add(transm);
        JLabel gas = new JLabel("Gas");
        gas.setBounds(600, 170, 100, 30);
        gas.setFont(new Font("serif", 3, 18));
        backgroundlabel.add(gas);
        JLabel engine = new JLabel("Engine");
        engine.setBounds(690, 155, 100, 30);
        engine.setFont(new Font("serif", 3, 16));
        backgroundlabel.add(engine);
        JLabel capacity = new JLabel("capacity");
        capacity.setBounds(685, 170, 100, 30);
        capacity.setFont(new Font("serif", 3, 14));
        backgroundlabel.add(capacity);
        JLabel color = new JLabel("Color");
        color.setBounds(775, 170, 100, 30);
        color.setFont(new Font("serif", 3, 18));
        backgroundlabel.add(color);
        this.table1 = new JTable();
        this.table1.setBounds(150, 200, 700, 400);
        backgroundlabel.add(this.table1);
        JLabel SearchText = new JLabel("Search for cars");
        SearchText.setBounds(150, 90, 200, 30);
        SearchText.setFont(new Font("Sanserif", 1, 22));
        backgroundlabel.add(SearchText);
        this.SearchBar = new JTextField();
        this.SearchBar.setBounds(350, 90, 400, 25);
        backgroundlabel.add(this.SearchBar);
        this.Search = new JButton("Search");
        this.Search.setBounds(750, 90, 80, 25);
        this.Search.addActionListener(this);
        this.Search.setActionCommand(MainPage.Actions.SEARCH.name());
        backgroundlabel.add(this.Search);

        try {
            SQLConnection conn = new SQLConnection();
            String query1 = "select brand,model,yearoffab,km,transmission,gastype,capacity,color from carads";
            this.rs1 = conn.st.executeQuery(query1);
            this.table1.setModel(DbUtils.resultSetToTableModel(this.rs1));
        } catch (Exception var27) {
            var27.printStackTrace();
        }

        this.setBounds(150, 30, 1015, 700);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        String pin = "";
        String insertPin;
        if (ae.getActionCommand().equals(MainPage.Actions.SEARCH.name())) {
            insertPin = this.SearchBar.getText();
            SQLConnection conn;
            String querry;
            if (insertPin.length() == 0) {
                try {
                    conn = new SQLConnection();
                    querry = "select brand,model,yearoffab,km,transmission,gastype,capacity,color from carads";
                    ResultSet resultquerry = conn.st.executeQuery(querry);
                    this.table1.setModel(DbUtils.resultSetToTableModel(resultquerry));
                } catch (Exception var11) {
                    var11.printStackTrace();
                }
            } else {
                try {
                    conn = new SQLConnection();
                    querry = "select brand,model,yearoffab,km,transmission,gastype,capacity,color from carads where brand ='" + insertPin + "' or model ='" + insertPin + "' or yearoffab = '" + insertPin + "' or km = '" + insertPin + "' or transmission ='" + insertPin + "' or gastype = '" + insertPin + "' or capacity ='" + insertPin + "' or color = '" + insertPin + "'";
                    this.rsz = conn.st.executeQuery(querry);
                } catch (Exception var10) {
                    var10.printStackTrace();
                }

                this.table1.setModel(DbUtils.resultSetToTableModel(this.rsz));
            }
        } else if (ae.getActionCommand().equals(MainPage.Actions.ADD.name())) {
            this.setVisible(false);
            new NewAd();
        } else if (ae.getActionCommand().equals(MainPage.Actions.SEE.name())) {
            this.setVisible(false);
            new SeeYourAds();
        } else if (ae.getActionCommand().equals(MainPage.Actions.DISC.name())) {
            JOptionPane.showMessageDialog((Component)null, "Disconnected, going back to the login page!");
            this.setVisible(false);
            new LoginPage();
        } else if (ae.getActionCommand().equals(MainPage.Actions.DELETE.name())) {
            insertPin = JOptionPane.showInputDialog((Component)null, "To confirm this action please enter your PIN. (1/2)", "WARNING", 2);
            String insertPass = JOptionPane.showInputDialog((Component)null, "To confirm this action please enter your password. (2/2)", "WARNING", 2);
            if (insertPin.length() != 0 && insertPass.length() != 0) {
                if (insertPin.length() == 4 && insertPass.length() >= 8) {
                    SQLConnection c1;
                    String querry;
                    try {
                        c1 = new SQLConnection();
                        querry = "delete from login where pin = '" + insertPin + "' and password = '" + insertPass + "'";
                        int x = c1.st.executeUpdate(querry);
                        if (x == 0) {
                            JOptionPane.showMessageDialog((Component)null, "PIN doesn't match with password.");
                        } else {
                            JOptionPane.showMessageDialog((Component)null, "Account deleted.");
                            this.setVisible(false);
                            new LoginPage();
                        }
                    } catch (Exception var9) {
                        var9.printStackTrace();
                    }

                    try {
                        c1 = new SQLConnection();
                        querry = "delete from carads where pin ='" + insertPin + "' and password ='" + insertPass + "'";
                        c1.st.executeUpdate(querry);
                    } catch (Exception var8) {
                        var8.printStackTrace();
                    }
                } else {
                    JOptionPane.showMessageDialog((Component)null, "Wrong PIN or password.Try again.");
                }
            } else {
                JOptionPane.showMessageDialog((Component)null, "All fields must be completed.");
            }
        } else if (ae.getActionCommand().equals(MainPage.Actions.SUPPORT.name())) {
            JOptionPane.showMessageDialog((Component)null, "For support send an email to: m2bobko@gmail.com");
        }

    }

    public static void main(String[] args) {
        new MainPage();
    }

    public static enum Actions {
        ADD,
        SEE,
        DISC,
        DELETE,
        SUPPORT,
        SEARCH;

        private Actions() {
        }
    }
}
