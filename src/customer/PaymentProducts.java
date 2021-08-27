/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customer;

/**
 *
 * @author kavya
 */
import Database.DatabaseOperations;
import customer.DatasForCustomer.WalletDataG;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import warehouse.Warehouse;


public class PaymentProducts  implements KeyListener
{
    JDialog newdialog = new JDialog();
    
    Color background_Color = new Color(34,34,45);
    Color on_background_Color = new Color(254,254,254);
    Color primary_Color = new Color(71,63,145);
    
    JLabel pro_payment_product_name;
    JLabel pro_payment_product_quantity;
    JLabel pro_payment_amount;
    JLabel pro_payment_password;
    
    JLabel pro_payment_product_name_info;
    
    JTextField pro_payment_product_quantity_info;
    
    JLabel pro_payment_amount_info;
    
    JTextField pro_payment_password_info;
    
    JButton pro_payment_btn_confirm;
    Warehouse stock;
    int price;
    int stockQuantity;
    int quantity;
    public PaymentProducts(int i) 
    {
        ArrayList<Warehouse> temp=DatabaseOperations.getStocks();
        stock=temp.get(i);
        price=Integer.valueOf(stock.getItemPrice());
        WalletDataG.setBalence(5000F); // getBalanceFromDatabase
        stockQuantity=Integer.valueOf(stock.getItemQuantity());
        
        newdialog.setSize(600, 650);
        newdialog.setLayout(null);

        JLabel e_payment_auth = new JLabel("Payment");
        e_payment_auth.setFont(new Font("Segoe UI", Font.PLAIN, 22));
        e_payment_auth.setBounds(250, 30, 187, 30);
        e_payment_auth.setForeground(on_background_Color);
        newdialog.add(e_payment_auth);
        
        pro_payment_product_name = new JLabel("Product Name");
        pro_payment_product_quantity = new JLabel("Product Quantity");
        pro_payment_amount = new JLabel("Amount");
        pro_payment_password = new JLabel("Enter Your Password");
        
        pro_payment_product_name_info = new JLabel( ":           " +stock.getItem());
        
        pro_payment_product_quantity_info = new JTextField();
        pro_payment_amount_info = new JLabel(":           " + "");
        pro_payment_password_info = new JTextField();
        
        pro_payment_btn_confirm = new JButton("Confirm");
        
        pro_payment_product_name.setBounds(130, 120, 200, 20);
        pro_payment_product_quantity.setBounds(130, 180, 200, 20);
        pro_payment_amount.setBounds(130, 290, 200, 20);
        pro_payment_password.setBounds(130, 350, 200, 20);
        
        pro_payment_product_name_info.setBounds(315, 115, 310, 30);
        pro_payment_product_quantity_info.setBounds(130, 220, 310, 30);
        pro_payment_amount_info.setBounds(315, 290, 310, 30);
        pro_payment_password_info.setBounds(130, 400, 310, 30);
        
        pro_payment_btn_confirm.setBounds(220, 500, 150, 40);
        
        pro_payment_product_name.setForeground(on_background_Color);
        pro_payment_product_quantity.setForeground(on_background_Color);
        pro_payment_amount.setForeground(on_background_Color);
        pro_payment_password.setForeground(on_background_Color);
        
        pro_payment_product_name_info.setForeground(on_background_Color);
        pro_payment_product_quantity_info.setForeground(background_Color);
        pro_payment_amount_info.setForeground(on_background_Color);
        pro_payment_password_info.setForeground(background_Color);
        pro_payment_btn_confirm.setForeground(on_background_Color);
        
        pro_payment_product_name.setFont(new Font("Segoe UI", Font.PLAIN, 22));
        pro_payment_product_quantity.setFont(new Font("Segoe UI", Font.PLAIN, 22));
        pro_payment_amount.setFont(new Font("Segoe UI", Font.PLAIN, 22));
        pro_payment_password.setFont(new Font("Segoe UI", Font.PLAIN, 22));
        pro_payment_product_name_info.setFont(new Font("Segoe UI", Font.PLAIN, 22));
        pro_payment_amount_info.setFont(new Font("Segoe UI", Font.PLAIN, 22));
        
        newdialog.add(pro_payment_product_name);
        newdialog.add(pro_payment_product_quantity);
        newdialog.add(pro_payment_amount);
        newdialog.add(pro_payment_password);
        newdialog.add(pro_payment_product_name_info);
        newdialog.add(pro_payment_product_quantity_info);
        newdialog.add(pro_payment_amount_info);
        newdialog.add(pro_payment_password_info);
        newdialog.add(pro_payment_btn_confirm);
        
        //auth_password_info.setColumns(10);

        pro_payment_btn_confirm.setBackground(primary_Color);
        pro_payment_btn_confirm.setBorder(null);
        
        pro_payment_btn_confirm.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                if(getAuthentication()){
                    WalletDataG.setTransationType("Products");
                    WalletDataG.setItemWeight(Float.valueOf(quantity));
                    stock.setItemQuantity(String.valueOf(stockQuantity-quantity));
                    ArrayList<Warehouse> tempstock=new ArrayList();
                    tempstock.add(stock);
                    DatabaseOperations.updateStocks(tempstock);
                    DatabaseOperations.updateConsignment();
                    DatabaseOperations.updateWalletTransaction();
                    JOptionPane.showMessageDialog(null, "Payment Successful!");
                    newdialog.dispose();
                    
                }
                else{
                    JOptionPane.showMessageDialog(null, "Password Incorrect.Try Again");
                }
                                
            }
                        
        });
        
        

        newdialog.getContentPane().setBackground(background_Color);
        newdialog.setVisible(true);
        

    }

    @Override
    public void keyTyped(KeyEvent ke) {
        //pro_payment_amount_info = new JLabel(":           " + "");
       quantity= Integer.valueOf(pro_payment_product_quantity_info.getText());
       WalletDataG.setItemPrice(Float.valueOf(quantity*price));
       pro_payment_amount_info.setText(":           "+WalletDataG.getItemPrice());
       
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        
    }
    private boolean getAuthentication(){
        return true;
    }
    
}
