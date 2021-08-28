package customer;
import Database.DatabaseOperations;
import Login.login;
import customer.DatasForCustomer.ConsignmentData;
import main.*;
import customer.DatasForCustomer.EPostData;
import customer.DatasForCustomer.ParcelData;
import customer.DatasForCustomer.WalletDataG;
import static customer.DatasForCustomer.WalletDataG.setBalence;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author htara
 */
public class AuthenticationForParcel
{
    JDialog newdialog = new JDialog();
    
    Color background_Color = new Color(34,34,45);
    Color on_background_Color = new Color(254,254,254);
    Color primary_Color = new Color(71,63,145);
    
    JLabel auth_password;
    JTextField auth_password_info,userID;
    JButton auth_btn_confirm;
    private static boolean flag;

    public AuthenticationForParcel() 
    {
        newdialog.setSize(600, 450);
        newdialog.setLayout(null);

        JLabel e_payment_auth = new JLabel("Authentication");
        e_payment_auth.setFont(new Font("Segoe UI", Font.PLAIN, 22));
        e_payment_auth.setBounds(220, 30, 187, 20);
        e_payment_auth.setForeground(on_background_Color);
        newdialog.add(e_payment_auth);
        
        auth_password = new JLabel("Enter Your Password");
        auth_password_info = new JTextField();
        userID=new JTextField();
        auth_btn_confirm = new JButton("Confirm");
        
        auth_password.setBounds(135, 120, 200, 20);
        auth_password_info.setBounds(135, 160, 310, 30);
        auth_btn_confirm.setBounds(220, 250, 150, 40);
        
        auth_password.setForeground(on_background_Color);
        auth_password_info.setForeground(background_Color);
        auth_btn_confirm.setForeground(on_background_Color);
        
        auth_password.setFont(new Font("Segoe UI", Font.PLAIN, 22));
        
        newdialog.add(auth_password);
        newdialog.add(auth_password_info);
        newdialog.add(auth_btn_confirm);
        
        //auth_password_info.setColumns(10);

        auth_btn_confirm.setBackground(primary_Color);
        auth_btn_confirm.setBorder(null);
        
        auth_btn_confirm.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
             ParcelData.setIsPasswordCorrect(getAuthentication());
           
              if(ParcelData.isIsPasswordCorrect()){
               JOptionPane.showMessageDialog(null,"Password Successful");
              WalletDataG.setBalence(5000.25F);//
              WalletDataG.setTransationType("Parcel");
              WalletDataG.setAmount(Float.valueOf(DatabaseOperations.getStocks().get(1).getItemPrice()));//fees for Parcel 1kg
          

              Database.DatabaseOperations.updateConsignment();
              Database.DatabaseOperations.updateWalletTransaction();
      
              ConsignmentData.listForConsignment.clear();
              ConsignmentData.setIsUpdate(true);
              CustomerPanel.contentForCustomer.add(new ConsignmentPanel(),"update");
              main.switchPage("customerPanel");
              CustomerPanel.BParcel.setBounds(55+180+180+180,110,160,30);
              CustomerPanel.BConsignment.setBounds(55+120+60,120,160,30);
              CustomerPanel.customerCard.show(CustomerPanel.contentForCustomer,"update");
              newdialog.dispose();

                }
             else{
                JOptionPane.showMessageDialog(null,"Incorrect Password"+DatabaseOperations.getMessageIdGenerator());
            
             }     
                               
            }
                        
        });        

        newdialog.getContentPane().setBackground(background_Color);
        newdialog.setVisible(true);

    }
  private  boolean getAuthentication(){
        ArrayList list = DatabaseOperations.getLoginCredentials(userID,auth_password_info);
        
        try
        {
            int salt = Integer.parseInt(list.get(1).toString());
            
            String password = login.createHash(auth_password_info.getText(), salt);
            System.out.println(list);
            System.out.println(password);
            System.out.println(list.get(1).toString());

            if(password.equals(list.get(0).toString()))
                return true;
    
            else
                 return false;
                     
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, "Wrong E-mail/Password");
        } 
    
        return false;
    }

}

