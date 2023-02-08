import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.DecimalFormat;

public class LoginGUI extends JFrame implements ActionListener
{
    private JTextField userfield;
    private JTextField passfield;
    public String userObtained;
    public String passObtained;

    public LoginGUI()
    {
        super("Login");

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setBounds(300, 300, 400, 300);

        JLabel label = new JLabel();
        label.setBounds(0,0,100,100);
        label.setBackground(Color.blue);

        label.setVisible(true);
        frame.add(label);
        frame.setVisible(true);

        Container c = getContentPane();

    }


    public void actionPerformed(ActionEvent e)
    {

    }

    public static void main(String[] args)
    {
        LoginGUI window = new LoginGUI();
        window.setBounds(300, 300, 400, 300);
        window.setDefaultCloseOperation(EXIT_ON_CLOSE);
        //window.setVisible(true);
    }
}