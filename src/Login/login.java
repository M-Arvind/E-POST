package Login;
import Database.DatabaseOperations;
import customer.CustomerPanel;
import static customer.CustomerPanel.customerCard;
import customer.InboxPanel;
import main.main;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import javax.swing.*;

public class login extends JPanel implements ActionListener
{
    JPanel loginPanel;
    JPanel registerPanel;
    
    //Private Variables
    private JLabel loginLabel,usernameLabel, passwordLabel, forgotPasswordLabel, messageLabel;
    private JLabel registerLabel;
    private JTextField usernameTextField;
    private JPasswordField passwordField;
    private JButton loginButton, createOneButton;
    private String pass;
    private String salt;
    private String hash_pass;
    private ArrayList list;
    
    public static String user_ID;
    
    public login()
    {
        //Login Panel
        loginPanel = new JPanel(null);
        loginPanel.setPreferredSize(new Dimension(1350, 890));
        loginPanel.setBackground(new Color(34, 34, 45));
        
        //Login Label
        loginLabel = new JLabel("Login");
        loginLabel.setBounds(620, 220, 150, 45);
        loginLabel.setFont(new Font(Font.SANS_SERIF,  Font.BOLD, 40));
        loginLabel.setForeground(Color.WHITE);
        
        //Username Label
        usernameLabel = new JLabel("Username/Phone Number");
        usernameLabel.setBounds(500, 320, 300, 40);
        usernameLabel.setFont(new Font(Font.SANS_SERIF,  Font.BOLD, 20));
        usernameLabel.setForeground(Color.WHITE);
        
        //Password Label
        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(500, 450, 300, 40);
        passwordLabel.setFont(new Font(Font.SANS_SERIF,  Font.BOLD, 20));
        passwordLabel.setForeground(Color.WHITE);
        
        //Username TextField
        usernameTextField = new JTextField(20);
        usernameTextField.setBounds(500, 370, 350, 40);
        usernameTextField.setFont(new Font(Font.SANS_SERIF,  Font.BOLD, 20));
        usernameTextField.setForeground(Color.BLACK);
        
        //Password TextField
        passwordField = new JPasswordField(20);
        passwordField.setBounds(500, 500, 350, 40);
        passwordField.setFont(new Font(Font.SANS_SERIF,  Font.BOLD, 20));
        passwordField.setForeground(Color.BLACK);
        
        //Forget Password Label
        forgotPasswordLabel = new JLabel("Forgot Password?");
        forgotPasswordLabel.setBounds(723, 540, 300, 40);
        forgotPasswordLabel.setFont(new Font(Font.SANS_SERIF,  Font.BOLD, 15));
        forgotPasswordLabel.setForeground(Color.WHITE);
        
        //Mouse Listener for Forget Password 
        forgotPasswordLabel.addMouseListener(new MouseListener()
        {
            @Override
            public void mouseClicked(MouseEvent e) 
            {
                new ForgetPassword();
            }

            @Override
            public void mousePressed(MouseEvent e) { //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseReleased(MouseEvent e) {//To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseEntered(MouseEvent e) { //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseExited(MouseEvent e) {//To change body of generated methods, choose Tools | Templates.
            }
        });
        
        //JLabel
        messageLabel = new JLabel("New to E-Post?");
        messageLabel.setBounds(570, 700, 300, 40);
        messageLabel.setFont(new Font(Font.SANS_SERIF,  Font.BOLD, 15));
        messageLabel.setForeground(Color.WHITE);
        
        //Button to Create An Account Wihch leads to Register Panel
        createOneButton = new JButton("Create One!");
        createOneButton.setBounds(690, 700, 100, 40);
        createOneButton.setFont(new Font(Font.SANS_SERIF,  Font.BOLD, 15));
        createOneButton.setBackground(new Color(34, 34, 45));
        createOneButton.setForeground(new Color(71,63,145));
        createOneButton.setBorder(null);
        createOneButton.setRequestFocusEnabled(false);
        createOneButton.setContentAreaFilled(false);
        createOneButton.addActionListener(this);
        
        //Login Button
        loginButton = new JButton("Login");
        loginButton.setBounds(615, 630, 130, 40);
        loginButton.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 17));
        loginButton.setBackground(new Color(71, 63, 145));
        loginButton.setForeground(Color.WHITE);
        loginButton.setBorder(null);
        loginButton.setUI(new StyledButtonUi());
        
        //Action Listener for Login Button
        loginButton.addActionListener(new ActionListener() 
    	{
            public void actionPerformed(ActionEvent e) 
            {
                {
                    login();
                    passwordField.setText("");
                }
            }
    	});
        
        //Adding components to Login Panel
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
    
    //Function that Validates and lets the user Login
    public void login()
    {
        //Gets the Login Credentials from DatabaseOperations
        ArrayList list = DatabaseOperations.getLoginCredentials(usernameTextField, passwordField);
        
        user_ID = usernameTextField.getText(); 
        
        try
        {
            int salt = Integer.parseInt(list.get(1).toString());
            
            String password = login.createHash(passwordField.getText(), salt);
//            System.out.println(list);
//            System.out.println(password);
//            System.out.println(list.get(1).toString());

            if(password.equals(list.get(0).toString()))
            {   
                JOptionPane.showMessageDialog(this,"Login Successful");

                //Switches to Admin Panel
                if(list.get(2).toString().equals("ADMIN"))
                {
                    main.switchPage("AdminPanel");
                }
                //Switches to Register Panel
                else if(list.get(2).toString().equals("DELIVERY"))
                {
                    main.switchPage("register");
                }
                //Switches to Customer Panel
                else if(list.get(2).toString().equals("Customer"))
                {
                    DatabaseOperations.getCustomerProfileForCustomerPanel(Login.login.user_ID);
                    CustomerPanel.contentForCustomer.add(new InboxPanel(),"Inbox");
                    customerCard.show(CustomerPanel.contentForCustomer,"Inbox");
                    main.switchPage("customerPanel");
                }

                //System.out.println(list.get(2).toString());
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Wrong E-mail/Password");
            }     
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(this, "Wrong E-mail/Password");
        } 
    }
    
    //This function Create an hash for the entered password
    public static String createHash(String input, int salt)
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
                
                while (hashtext.length() < 32) 
                {
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
    
    //Action Listener
    public void actionPerformed(ActionEvent e) 
    {
        Object source = e.getSource();
        
        if(source == createOneButton)
            main.switchPage("register");
    }
}