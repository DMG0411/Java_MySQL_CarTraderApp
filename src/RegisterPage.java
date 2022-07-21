
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class RegisterPage extends JFrame implements ActionListener {
    JTextField username,phonenum,e_mail,realname,pinn,pinn1;
    JPasswordField password,password1;
    JCheckBox check;

    RegisterPage() {
        this.getContentPane().setBackground(Color.white);
        this.setLayout((LayoutManager)null);
        
        ImageIcon image2 = new ImageIcon(ClassLoader.getSystemResource("images/MarketAuto.jpg"));
        JLabel miniature = new JLabel(image2);
        miniature.setBounds(0, 0, 82, 60);
        this.add(miniature);
        
        ///////// Labels
        
        JLabel welc_msg = new JLabel("Welcome to Register Page!");
        welc_msg.setBounds(130, 20, 400, 50);
        welc_msg.setFont(new Font("SansSerif", 1, 30));
        this.add(welc_msg);
        
        JLabel user = new JLabel("Username:");
        user.setBounds(65, 80, 100, 30);
        user.setFont(new Font("serif", 3, 20));
        this.add(user);
        
        JLabel pass = new JLabel("Password:");
        pass.setBounds(65, 110, 100, 30);
        pass.setFont(new Font("serif", 3, 20));
        this.add(pass);
        
        JLabel minpass = new JLabel("*At least 8 chars");
        minpass.setBounds(50, 135, 180, 20);
        minpass.setFont(new Font("serif", 3, 13));
        this.add(minpass);
        
        JLabel pass1 = new JLabel("Re-type password:");
        pass1.setBounds(20, 150, 140, 30);
        pass1.setFont(new Font("serif", 3, 18));
        this.add(pass1);
        
        JLabel name = new JLabel("Real name:");
        name.setBounds(60, 180, 100, 30);
        name.setFont(new Font("serif", 3, 20));
        this.add(name);
        
        JLabel mail = new JLabel("E-mail address:");
        mail.setBounds(40, 210, 140, 30);
        mail.setFont(new Font("serif", 3, 18));
        this.add(mail);
        
        JLabel phone = new JLabel("Phone number:");
        phone.setBounds(45, 240, 140, 30);
        phone.setFont(new Font("serif", 3, 18));
        this.add(phone);
        
        JLabel pin = new JLabel("PIN:");
        pin.setBounds(310, 83, 70, 25);
        pin.setFont(new Font("serif", 3, 15));
        this.add(pin);
        
        JLabel cpin = new JLabel("Confirm PIN:");
        cpin.setBounds(310, 115, 100, 25);
        cpin.setFont(new Font("serif", 3, 15));
        this.add(cpin);
        
        JLabel checktxt = new JLabel("Agree to Terms and Conditions");
        checktxt.setBounds(60, 270, 200, 30);
        checktxt.setFont(new Font("serif", 3, 15));
        this.add(checktxt);
        
        this.username = new JTextField();
        this.username.setBounds(167, 85, 130, 25);
        this.add(this.username);
        
        this.password = new JPasswordField();
        this.password.setBounds(167, 115, 130, 25);
        this.add(this.password);
        
        this.password1 = new JPasswordField();
        this.password1.setBounds(167, 154, 130, 25);
        this.add(this.password1);
        
        this.realname = new JTextField();
        this.realname.setBounds(167, 186, 130, 25);
        this.add(this.realname);
        
        this.e_mail = new JTextField();
        this.e_mail.setBounds(167, 216, 130, 25);
        this.add(this.e_mail);
        
        this.phonenum = new JTextField();
        this.phonenum.setBounds(167, 245, 130, 25);
        this.add(this.phonenum);
        
        this.pinn = new JTextField();
        this.pinn.setBounds(345, 87, 40, 20);
        this.add(this.pinn);
        
        this.pinn1 = new JTextField();
        this.pinn1.setBounds(400, 118, 40, 20);
        this.add(this.pinn1);
        
        JLabel passtext = new JLabel("*Characters can be");
        passtext.setBounds(310, 135, 120, 20);
        passtext.setFont(new Font("serif", 3, 13));
        this.add(passtext);
        
        JLabel passtext1 = new JLabel("only alphanumerical");
        passtext1.setBounds(310, 150, 120, 20);
        passtext1.setFont(new Font("serif", 3, 13));
        this.add(passtext1);
        
        this.check = new JCheckBox();
        this.check.setBounds(260, 275, 20, 20);
        this.add(this.check);
        
        /////// Buttons
        
        JButton backButton = new JButton("Back to Login");
        backButton.setBounds(300, 275, 120, 30);
        backButton.setBackground(Color.black);
        backButton.setForeground(Color.white);
        backButton.addActionListener(this);
        backButton.setActionCommand(RegisterPage.Actions.backLOGIN.name());
        backButton.setFont(new Font("SansSerif", 1, 12));
        this.add(backButton);
        
        JButton registerButton = new JButton("Register");
        registerButton.setBounds(430, 275, 120, 30);
        registerButton.setBackground(Color.black);
        registerButton.setForeground(Color.white);
        registerButton.addActionListener(this);
        registerButton.setActionCommand(RegisterPage.Actions.REGISTER.name());
        registerButton.setFont(new Font("SansSerif", 1, 12));
        this.add(registerButton);
        
        JButton cancelButton = new JButton("Exit");
        cancelButton.setBounds(560, 275, 120, 30);
        cancelButton.setBackground(Color.black);
        cancelButton.setForeground(Color.white);
        cancelButton.addActionListener(this);
        cancelButton.setActionCommand(RegisterPage.Actions.EXIT.name());
        cancelButton.setFont(new Font("SansSerif", 1, 12));
        this.add(cancelButton);
        
        ImageIcon avatar = new ImageIcon(ClassLoader.getSystemResource("images/car_avatar.jpg"));
        ImageIcon avatarSized = new ImageIcon(avatar.getImage().getScaledInstance(200, 200, 1));
        JLabel avatarlabel = new JLabel(avatarSized);
        avatarlabel.setBounds(450, 70, 200, 200);
        this.add(avatarlabel);
        
        this.setBounds(400, 150, 700, 350);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals(RegisterPage.Actions.EXIT.name())) {
            this.setVisible(false);
        } else if (ae.getActionCommand().equals(RegisterPage.Actions.backLOGIN.name())) {
            this.setVisible(false);
            new LoginPage();
        } else if (ae.getActionCommand().equals(RegisterPage.Actions.REGISTER.name())) {
            String user = this.username.getText();
            String pass = this.password.getText();
            String cpass = this.password1.getText();
            String real = this.realname.getText();
            String mail = this.e_mail.getText();
            int n = mail.length() - 1;
            String phone = this.phonenum.getText();
            String pin = this.pinn.getText();
            String cpin = this.pinn1.getText();

            try {
                SQLConnection c = new SQLConnection();
                String query = "select * from login where username = '" + user + "'";
                ResultSet rs = c.st.executeQuery(query);
                String query1;
                if (rs.next()) {
                    JOptionPane.showMessageDialog((Component)null, "The username is already taken!Try a different one.");
                } else {
                    query1 = "select * from login where PIN = '" + pin + "'";
                    ResultSet rs1 = c.st.executeQuery(query1);
                    if (rs1.next()) {
                        JOptionPane.showMessageDialog((Component)null, "PIN already taken!Try a different one.");
                    }
                }

                if (user.length() != 0 && pass.length() != 0 && cpass.length() != 0 && real.length() != 0 && mail.length() != 0 && phone.length() != 0 && pin.length() != 0 && cpin.length() != 0) {
                    if (pass.length() < 8) {
                        JOptionPane.showMessageDialog((Component)null, "The password has less then 8 characters.");
                    } else if (!pass.equals(cpass)) {
                        JOptionPane.showMessageDialog((Component)null, "Passwords don't match each other.");
                    } else if (!pin.equals(cpin)) {
                        JOptionPane.showMessageDialog((Component)null, "PINs don't match each other.");
                    } else if (pin.length() != 4) {
                        JOptionPane.showMessageDialog((Component)null, "PIN must have exactly 4 digits.");
                    } else if (mail.charAt(n) == 'm' && mail.charAt(n - 1) == 'o' && mail.charAt(n - 2) == 'c' && mail.indexOf(64) != -1) {
                        if (phone.length() >= 4 && phone.length() <= 19) {
                            if (!this.check.isSelected()) {
                                JOptionPane.showMessageDialog((Component)null, "Please accept to our Terms and Conditions.");
                            } else {
                                JOptionPane.showMessageDialog((Component)null, "Register was succesfully, going back to login page.");
                                query1 = "insert into login(username, password, realname, e_mail, phone, pin) values('" + user + "', '" + pass + "', '" + real + "', '" + mail + "', '" + phone + "', '" + pin + "')";
                                c.st.executeUpdate(query1);
                                this.setVisible(false);
                                new LoginPage();
                            }
                        } else {
                            JOptionPane.showMessageDialog((Component)null, "Please enter a valid phone number.");
                        }
                    } else {
                        JOptionPane.showMessageDialog((Component)null, "Please enter a valid e-mail address.");
                    }
                } else {
                    JOptionPane.showMessageDialog((Component)null, "All fields must be completed!");
                }
            } catch (Exception var16) {
                var16.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        new RegisterPage();
    }

    private static enum Actions {
        backLOGIN,
        EXIT,
        REGISTER;

        private Actions() {
        }
    }
}
