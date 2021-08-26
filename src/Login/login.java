package Login;
import main.main;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonUI;


public class login extends JPanel implements ActionListener, MouseListener
{
    JPanel loginPanel;
    JPanel registerPanel;
    private JLabel loginLabel,usernameLabel, passwordLabel, forgotPasswordLabel, messageLabel;
    private JLabel registerLabel;
    private JTextField usernameTextField;
    private JPasswordField passwordField;
    private JButton loginButton, createOneButton;
    private String pass;
    private String salt;
    private String hash_pass;
    private ArrayList list;
    
    public login()
    {
        loginPanel = new JPanel(null);
        loginPanel.setPreferredSize(new Dimension(1350, 890));
        loginPanel.setBackground(new Color(34, 34, 45));
        
        loginLabel = new JLabel("Login");
        loginLabel.setBounds(620, 220, 150, 45);
        loginLabel.setFont(new Font(Font.SANS_SERIF,  Font.BOLD, 40));
        loginLabel.setForeground(Color.WHITE);
        
        usernameLabel = new JLabel("Username/Phone Number");
        usernameLabel.setBounds(500, 320, 300, 40);
        usernameLabel.setFont(new Font(Font.SANS_SERIF,  Font.BOLD, 20));
        usernameLabel.setForeground(Color.WHITE);
        
        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(500, 450, 300, 40);
        passwordLabel.setFont(new Font(Font.SANS_SERIF,  Font.BOLD, 20));
        passwordLabel.setForeground(Color.WHITE);
        
        usernameTextField = new JTextField(20);
        usernameTextField.setBounds(500, 370, 350, 40);
        usernameTextField.setFont(new Font(Font.SANS_SERIF,  Font.BOLD, 20));
        usernameTextField.setBorder(BorderFactory.createEmptyBorder(10,10, 10, 10));
        usernameTextField.setForeground(Color.BLACK);
        
        passwordField = new JPasswordField(20);
        passwordField.setBounds(500, 500, 350, 40);
        passwordField.setFont(new Font(Font.SANS_SERIF,  Font.BOLD, 20));
        passwordField.setBorder(BorderFactory.createEmptyBorder(10,10, 10, 10));
        passwordField.setForeground(Color.BLACK);
        
        forgotPasswordLabel = new JLabel("Forgot Password?");
        forgotPasswordLabel.setBounds(723, 540, 300, 40);
        forgotPasswordLabel.setFont(new Font(Font.SANS_SERIF,  Font.BOLD, 15));
        forgotPasswordLabel.setForeground(Color.WHITE);
        forgotPasswordLabel.addMouseListener(this);
        
        messageLabel = new JLabel("New to E-Post?");
        messageLabel.setBounds(570, 700, 300, 40);
        messageLabel.setFont(new Font(Font.SANS_SERIF,  Font.BOLD, 15));
        messageLabel.setForeground(Color.WHITE);
        
        createOneButton = new JButton("Create One!");
        createOneButton.setBounds(690, 700, 100, 40);
        createOneButton.setFont(new Font(Font.SANS_SERIF,  Font.BOLD, 15));
        createOneButton.setBackground(new Color(34, 34, 45));
        createOneButton.setForeground(Color.WHITE);
        createOneButton.setBorder(null);
        createOneButton.setRequestFocusEnabled(false);
        createOneButton.setContentAreaFilled(false);
        createOneButton.addActionListener(this);
        
        loginButton = new JButton("Login");
        loginButton.setBounds(615, 630, 130, 40);
        loginButton.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 17));
        loginButton.setBackground(new Color(71, 63, 145));
        loginButton.setForeground(Color.WHITE);
        loginButton.setBorder(null);
        loginButton.setUI(new BasicButtonUI());
        //loginButton.addActionListener(this);
        loginButton.addActionListener(this);
        
        
        loginPanel.add(loginLabel);
        loginPanel.add(usernameLabel);
        loginPanel.add(passwordLabel);
        loginPanel.add(forgotPasswordLabel);
        loginPanel.add(messageLabel);
        loginPanel.add(createOneButton);
        loginPanel.add(usernameTextField);
        loginPanel.add(passwordField);
        loginPanel.add(loginButton);
        
        this.add(loginPanel);
    }
    
    String createHash(String input, String salt)
    {
	String hashtext = new String();
        for(int i=0;i<5;i++)
        {
            try 
            {

                input += salt;
                MessageDigest md = MessageDigest.getInstance("MD5");

                byte[] messageDigest = md.digest(input.getBytes());

                BigInteger no = new BigInteger(1, messageDigest);

                hashtext = no.toString(16);
                while (hashtext.length() < 32) {
                    hashtext = "0" + hashtext;
                }
                input = hashtext;

            } 
  
            catch (NoSuchAlgorithmException e) 
            {
                throw new RuntimeException(e);
            }
        }
        return hashtext;
    }


    //Database
    public List getLoginCredentials()
    {
          List loginCredentials = new List();
          
          try
            {                
                String userName = usernameTextField.getText();
                String userPassword = passwordField.getText();                

                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","E_Post","123");
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("select user_ID from Login where user_ID like '"+'%'+userName+'%'+"'");
                boolean next = rs.next();
                
                if(next)
                {
                    ResultSet rspass = st.executeQuery("select password,salt,login_type from Login where user_ID like '"+'%'+userName+'%'+"'");
                    if(rspass.next())
                    {         
                        String pass = rspass.getString("password");
                        String salt = rspass.getString("salt");
                        String type = rspass.getString("login_type");
                        String hash_pass = createHash(userPassword, salt);
                        
                        System.out.println(pass);
                        System.out.println(salt);
                        System.out.println(type);
                        System.out.println(hash_pass);
                        
                        loginCredentials.add(pass);
                        loginCredentials.add(salt);
                        loginCredentials.add(type);
                        loginCredentials.add(hash_pass);                        
                        
                        if(pass.equals(hash_pass))
                        {
                            JOptionPane.showMessageDialog(null,"Login Successful");                            
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(this, "Wrong E-mail/Password");
                        }   
                    }                    
                }
                else
                {
                    JOptionPane.showMessageDialog(this, "This account is not yet Registered");
                }
                  
            }
            catch(Exception ex)
            {
                JOptionPane.showMessageDialog(this, ex.toString());
            }
          
          return loginCredentials;
    }
    
    public void actionPerformed(ActionEvent e) 
    {
        Object source = e.getSource();
        
        if(source == createOneButton)
            main.switchPage("register");
        else if(source == loginButton)
            main.switchPage("AdminPanel");
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Object source = e.getSource();
        
        if(source == forgotPasswordLabel)
            new ForgetPassword();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }
}
