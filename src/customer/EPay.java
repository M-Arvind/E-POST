package customer;
import Database.DatabaseOperations;
import Login.login;
import customer.DatasForCustomer.WalletDataG;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
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
public class EPay{
        JDialog newdialog = new JDialog();
    
    Color background_Color = new Color(34,34,45);
    Color on_background_Color = new Color(254,254,254);
    Color primary_Color = new Color(71,63,145);
    
    JLabel ePay_to;
    JLabel ePay_amount;
    JLabel ePay_password;
    
    JTextField ePay_to_info;
    JTextField ePay_amount_info;
    JTextField ePay_password_info;
    
    JButton ePay_btn_confirm;

    public EPay() 
    {
        newdialog.setBounds(375,100, 600, 600);//1350,890
        newdialog.setLayout(null);

        JLabel e_payment_auth = new JLabel("E Pay");
        e_payment_auth.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        e_payment_auth.setBounds(220, 30, 187, 30);
        e_payment_auth.setForeground(on_background_Color);
        newdialog.add(e_payment_auth);
        
        ePay_to = new JLabel("To");
        ePay_amount = new JLabel("Amount");
        ePay_password = new JLabel("Password");
        
        ePay_to_info = new JTextField();
        ePay_amount_info = new JTextField();
        ePay_password_info = new JTextField();
        
        ePay_btn_confirm = new JButton("Confirm");
        
        ePay_to.setBounds(135, 120, 200, 20);
        ePay_amount.setBounds(135, 210, 200, 20);
        ePay_password.setBounds(135, 300, 200, 20);
        
        ePay_to_info.setBounds(135, 160, 310, 30);
        ePay_amount_info.setBounds(135, 250, 310, 30);
        ePay_password_info.setBounds(135, 340, 310, 30);
        
        ePay_btn_confirm.setBounds(220, 440, 150, 40);
        
        ePay_to.setForeground(on_background_Color);
        ePay_amount.setForeground(on_background_Color);
        ePay_password.setForeground(on_background_Color);
        
        ePay_to_info.setForeground(background_Color);
        ePay_amount_info.setForeground(background_Color);
        ePay_password_info.setForeground(background_Color);
        
        ePay_btn_confirm.setForeground(on_background_Color);
        
        ePay_to.setFont(new Font("Segoe UI", Font.PLAIN, 22));
        ePay_amount.setFont(new Font("Segoe UI", Font.PLAIN, 22));
        ePay_password.setFont(new Font("Segoe UI", Font.PLAIN, 22));
        
        newdialog.add(ePay_to);
        newdialog.add(ePay_amount);
        newdialog.add(ePay_password);
        newdialog.add(ePay_to_info);
        newdialog.add(ePay_amount_info);
        newdialog.add(ePay_password_info);
        newdialog.add(ePay_btn_confirm);
        
        //auth_password_info.setColumns(10);

        ePay_btn_confirm.setBackground(primary_Color);
        ePay_btn_confirm.setBorder(null);
        
        ePay_btn_confirm.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                if(getAuthentication()){
                    try{
                      WalletDataG.setBalence(Float.valueOf(WalletPanel.WalletBalance.getText()));
                      WalletDataG.setItemPrice(Float.valueOf(ePay_amount_info.getText()));  
                    }
                    catch(Exception r){}
                    DatabaseOperations.updateCustomerBalence();
                    WalletPanel.WalletBalance.setText(String.valueOf(WalletDataG.getBalence()));
                    ePay_amount_info.getText();
                   JOptionPane.showMessageDialog(null, "Money has been transfered successfully");  
                }
                else{
                     JOptionPane.showMessageDialog(null,"Incorrect Password");
                }
               
                newdialog.dispose();
            }
                        
        });

        newdialog.getContentPane().setBackground(background_Color);
        newdialog.setVisible(true);

    }
    
        private  boolean getAuthentication(){
            JTextField userID=new JTextField();
            userID.setText(Login.login.user_ID);
        ArrayList list = DatabaseOperations.getLoginCredentials(userID,ePay_password_info);
        
        try
        {
            int salt = Integer.parseInt(list.get(1).toString());
            
            String password = login.createHash(ePay_password_info.getText(), salt);
            

            if(password.equals(list.get(0).toString()))
            {   
                
                return true;
                
            }
            else
            {
                return false;
            }     
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, "Wrong E-mail/Password");
        } 
    
        return false;
    }
    
    
    
        
}

