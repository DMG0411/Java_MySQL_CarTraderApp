import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WelcomePage extends JFrame implements ActionListener {
    WelcomePage() {
        this.setBounds(80, 100, 1260, 565);
        this.setLayout((LayoutManager)null);

        ImageIcon image1 = new ImageIcon(ClassLoader.getSystemResource("images/first_Page.jpg"));
        JLabel firstPage = new JLabel(image1, 0);
        firstPage.setBounds(0, 0, 1260, 565);
        this.add(firstPage);

        ImageIcon image2 = new ImageIcon(ClassLoader.getSystemResource("images/MarketAuto.jpg"));
        JLabel miniature = new JLabel(image2);
        miniature.setBounds(0, 0, 82, 60);
        firstPage.add(miniature);

        JLabel welc_text = new JLabel(" Welcome to");
        welc_text.setBounds(10, 350, 1000, 90);
        welc_text.setForeground(Color.yellow);
        welc_text.setFont(new Font("Sanserif", 0, 90));
        firstPage.add(welc_text);

        JLabel text = new JLabel("Car Trader Application");
        text.setBounds(20, 430, 1000, 90);
        text.setForeground(Color.yellow);
        text.setFont(new Font("Sanserif", 0, 50));
        firstPage.add(text);

        JButton next_main_button = new JButton("Enter");
        next_main_button.setBounds(1050, 450, 150, 50);
        next_main_button.setBackground(Color.PINK);
        next_main_button.setForeground(Color.BLACK);
        next_main_button.addActionListener(this);
        next_main_button.setFont(new Font("Serif", 0, 30));
        firstPage.add(next_main_button);

        this.setVisible(true);

        while(true) {
            text.setVisible(false);
            welc_text.setVisible(false);

            try {
                Thread.sleep(200L);
            } catch (Exception var10) {
                var10.printStackTrace();
            }

            text.setVisible(true);
            welc_text.setVisible(true);

            try {
                Thread.sleep(1000L);
            } catch (Exception var9) {
                var9.printStackTrace();
            }
        }
    }

    public void actionPerformed(ActionEvent ae) {
        this.setVisible(false);
        new LoginPage();
    }

    public static void main(String[] args) {
        new WelcomePage();
    }
}