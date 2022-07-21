import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class LoginPage extends JFrame implements ActionListener {
    JPasswordField pass;
    JTextField user_input;
    JLabel user_name,password,not_acc,avatarlabel,sign_msg;
    JButton Login,Cancel,Register;
    
    public LoginPage() {
        this.getContentPane().setBackground(Color.white);
        this.setLayout((LayoutManager)null);
        
        ImageIcon image2 = new ImageIcon(ClassLoader.getSystemResource("images/MarketAuto.jpg"));
        JLabel miniature = new JLabel(image2);
        miniature.setBounds(0, 0, 82, 60);
        this.add(miniature);
        ////////// Labels
        this.sign_msg = new JLabel("Welcome to Login page!");
        this.sign_msg.setBounds(180, 5, 500, 100);
        this.sign_msg.setFont(new Font("SansSerif", 1, 30));
        this.add(this.sign_msg);
        
        this.user_name = new JLabel("Username:");
        this.user_name.setBounds(65, 80, 100, 30);
        this.user_name.setFont(new Font("serif", 3, 20));
        this.add(this.user_name);
        
        this.user_input = new JTextField();
        this.user_input.setBounds(160, 85, 150, 25);
        this.add(this.user_input);
        
        this.password = new JLabel("Password:");
        this.password.setBounds(70, 120, 100, 30);
        this.password.setFont(new Font("serif", 3, 20));
        this.add(this.password);
        
        this.pass = new JPasswordField();
        this.pass.setBounds(160, 125, 150, 25);
        this.pass.setFont(new Font("serif", 3, 20));
        this.add(this.pass);
        
        this.not_acc = new JLabel("Don't have an account?");
        this.not_acc.setBounds(30, 250, 180, 20);
        this.not_acc.setFont(new Font("serif", 3, 16));
        this.add(this.not_acc);
        
        ////////////// Buttons
        
        this.Login = new JButton("Log in");
        this.Login.setBounds(65, 200, 100, 30);
        this.Login.addActionListener(this);
        this.Login.setActionCommand(LoginPage.Actions.LOGIN.name());
        this.Login.setBackground(Color.black);
        this.Login.setForeground(Color.white);
        this.Login.setFont(new Font("SansSerif", 3, 18));
        this.add(this.Login);
        
        this.Cancel = new JButton("Exit");
        this.Cancel.setBounds(200, 200, 100, 30);
        this.Cancel.setBackground(Color.black);
        this.Cancel.setForeground(Color.white);
        this.Cancel.addActionListener(this);
        this.Cancel.setActionCommand(LoginPage.Actions.EXIT.name());
        this.Cancel.setFont(new Font("SansSerif", 3, 18));
        this.add(this.Cancel);
        
        this.Register = new JButton("Register now!");
        this.Register.setBounds(200, 244, 150, 30);
        this.Register.setBackground(Color.black);
        this.Register.setForeground(Color.white);
        this.Register.addActionListener(this);
        this.Register.setActionCommand(LoginPage.Actions.REGISTER.name());
        this.Register.setFont(new Font("SansSerif", 3, 17));
        this.add(this.Register);
        
        ImageIcon avatar = new ImageIcon(ClassLoader.getSystemResource("images/avatar.jpg"));
        ImageIcon avatarSized = new ImageIcon(avatar.getImage().getScaledInstance(200, 200, 1));
        this.avatarlabel = new JLabel(avatarSized);
        this.avatarlabel.setBounds(400, 100, 200, 200);
        this.add(this.avatarlabel);
        
        this.setBounds(400, 150, 700, 350);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        String user = this.user_input.getText();
        String passw = this.pass.getText();
        
        if (ae.getActionCommand().equals(LoginPage.Actions.EXIT.name())) {
            this.setVisible(false);
        } else if (ae.getActionCommand().equals(LoginPage.Actions.REGISTER.name())) {
            this.setVisible(false);
            new RegisterPage();
        } else if (ae.getActionCommand().equals(LoginPage.Actions.LOGIN.name())) {
            try {
                SQLConnection c = new SQLConnection();
                String query = "select * from login where username = '" + user + "' and password = '" + passw + "'";
                ResultSet rs = c.st.executeQuery(query);
                if (rs.next()) {
                    JOptionPane.showMessageDialog((Component)null, "Welcome back!");
                    this.setVisible(false);
                    new MainPage();
                } else {
                    JOptionPane.showMessageDialog((Component)null, "Invalid username or password! Or non-existing account!");
                    JOptionPane.showMessageDialog((Component)null, "Try again or create a new account!");
                }
            } catch (Exception var7) {
                var7.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        new LoginPage();
    }

    private static enum Actions {
        LOGIN,
        EXIT,
        REGISTER;

        private Actions() {
        }
    }
}
