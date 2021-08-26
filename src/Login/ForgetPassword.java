package Login;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
/**
 *
 * @author kesha
 */
public class ForgetPassword implements ActionListener{
        JDialog newdialog = new JDialog();
    
    Color background_Color = new Color(34,34,45);
    Color on_background_Color = new Color(254,254,254);
    Color primary_Color = new Color(71,63,145);
    
    JLabel fPass_User;
    JLabel fPass_Password;
    JLabel fPass_RePassword;
    
    JTextField fPass_User_info;
    JTextField fPass_Password_info;
    JTextField fPass_Repassword_info;
    
    JButton fPass_btn_confirm;

    public ForgetPassword() 
    {
        newdialog.setSize(600, 600);
        newdialog.setLayout(null);

        JLabel fPass_La = new JLabel("Forget Password");
        fPass_La.setFont(new Font("Times New Roman", Font.PLAIN, 28));
        fPass_La.setBounds(190, 30, 187, 30);
        fPass_La.setForeground(on_background_Color);
        newdialog.add(fPass_La);
        
        fPass_User = new JLabel("UserName");
        fPass_Password = new JLabel("Password");
        fPass_RePassword = new JLabel("Re-Enter Password");
        
        fPass_User_info = new JTextField();
        fPass_Password_info = new JTextField();
        fPass_Repassword_info = new JTextField();
        
        fPass_btn_confirm = new JButton("Confirm");
        
        fPass_User.setBounds(135, 120, 200, 20);
        fPass_Password.setBounds(135, 210, 200, 20);
        fPass_RePassword.setBounds(135, 300, 200, 20);
        
        fPass_User_info.setBounds(135, 160, 310, 30);
        fPass_Password_info.setBounds(135, 250, 310, 30);
        fPass_Repassword_info.setBounds(135, 340, 310, 30);
        
        fPass_btn_confirm.setBounds(220, 440, 150, 40);
        
        fPass_User.setForeground(on_background_Color);
        fPass_Password.setForeground(on_background_Color);
        fPass_RePassword.setForeground(on_background_Color);
        
        fPass_User_info.setForeground(background_Color);
        fPass_Password_info.setForeground(background_Color);
        fPass_Repassword_info.setForeground(background_Color);
        
        fPass_btn_confirm.setForeground(on_background_Color);
        
        fPass_User.setFont(new Font("Segoe UI", Font.PLAIN, 22));
        fPass_Password.setFont(new Font("Segoe UI", Font.PLAIN, 22));
        fPass_RePassword.setFont(new Font("Segoe UI", Font.PLAIN, 22));
        
        newdialog.add(fPass_User);
        newdialog.add(fPass_Password);
        newdialog.add(fPass_RePassword);
        newdialog.add(fPass_User_info);
        newdialog.add(fPass_Password_info);
        newdialog.add(fPass_Repassword_info);
        newdialog.add(fPass_btn_confirm);
        
        //auth_password_info.setColumns(10);

        fPass_btn_confirm.setBackground(primary_Color);
        fPass_btn_confirm.setBorder(null);
        
        fPass_btn_confirm.addActionListener(this);

        newdialog.getContentPane().setBackground(background_Color);
        newdialog.setVisible(true);

    } 

    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null, "This goes to Back to Wallet");
    }
        
}

