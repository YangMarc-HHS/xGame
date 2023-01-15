import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.DecimalFormat;

public class LoginGUI extends JFrame
        implements ActionListener
{
    private JTextField userfield;
    private JTextField passfield;
    private DecimalFormat money = new DecimalFormat("$0.00");
    public String userObtained;
    public String passObtained;

    public LoginGUI()
    {
        super("Login");

        JPanel panel = new JPanel();
        JPanel panel1 = new JPanel();
        panel.setLayout(new GridLayout(6,2));

        panel.add(new JLabel("   Username:"));
        userfield = new JTextField(10);
        userfield.setHorizontalAlignment(JTextField.RIGHT);
        panel.add(userfield);

        panel.add(new JLabel("   Password"));
        passfield = new JTextField(20);
        passfield.setHorizontalAlignment(JTextField.RIGHT);
        panel.add(passfield);

        JButton login = new JButton("Login");
        //login.setPreferredSize(new Dimension(4, 2));
        login.addActionListener(this);

        Container c = getContentPane();
        c.add(panel, BorderLayout.CENTER);
        c.add(login, BorderLayout.SOUTH);

        JButton newAccount = new JButton("New Account");
        newAccount.addActionListener(this);

        c.add(panel, BorderLayout.CENTER);
        c.add(newAccount, BorderLayout.SOUTH);
    }


    public void actionPerformed(ActionEvent e)
    {
        userObtained = userfield.getText();
        passObtained = passfield.getText();


    }

    public static void main(String[] args)
    {
        LoginGUI window = new LoginGUI();
        window.setBounds(300, 300, 400, 300);
        window.setDefaultCloseOperation(EXIT_ON_CLOSE);
        window.setVisible(true);
    }
}