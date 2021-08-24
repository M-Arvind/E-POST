package e_post;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class PaymentParcel 
{
    
    Color background_Color = new Color(34,34,45);
    Color on_background_Color = new Color(254,254,254);
    Color primary_Color = new Color(71,63,145);
    
    JPanel p_payment_Panel;

    JLabel p_payment_title;
    JButton p_payment_btn_confirm;
    JButton p_payment_btn_back;
    
    //Left Label
    JLabel p_payment_beneficiary;
    JLabel p_payment_amount;
    JLabel p_payment_to;
    JLabel p_payment_contact;
    JLabel p_payment_type;
    JLabel p_payment_weight;
    JLabel p_payment_firstName;
    JLabel p_payment_lastName;
    JLabel p_payment_address;
    JLabel p_payment_state;
    JLabel p_payment_district;
    JLabel p_payment_pincode;
    
    //Content Label
    JLabel p_payment_beneficiary_info;
    JLabel p_payment_amount_info;
    JLabel p_payment_to_info;
    JLabel p_payment_contact_info;
    JLabel p_payment_type_info;
    JLabel p_payment_weight_info;
    JLabel p_payment_firstName_info;
    JLabel p_payment_lastName_info;
    JTextArea p_payment_address_info;
    JLabel p_payment_state_info;
    JLabel p_payment_district_info;
    JLabel p_payment_pincode_info;

    
    int X_FORCUSTOMER=0,Y_FORCUSTOMER=100,WIDTHFORCUSTOMER=1260,HIGHTFORCUSTOMER=750;
    
    public PaymentParcel()
    { 
        JFrame frame= new JFrame("Money Order");    
        p_payment_Panel = new JPanel();
        
        p_payment_btn_confirm = new JButton();
        p_payment_btn_back = new JButton();
        
        //Label
        p_payment_title = new JLabel("Payment");
        p_payment_beneficiary = new JLabel("Beneficiary");
        p_payment_amount = new JLabel("Amount");
        p_payment_to = new JLabel("To");
        p_payment_contact = new JLabel("Contact No.");
        p_payment_type = new JLabel("Type");
        p_payment_weight = new JLabel("Item Weight");
        p_payment_firstName = new JLabel("First Name");
        p_payment_lastName = new JLabel("Last Name");
        p_payment_address = new JLabel("Address");
        p_payment_state = new JLabel("State");
        p_payment_district = new JLabel("District");
        p_payment_pincode = new JLabel("Pincode");
        
        
        //Content Label
        p_payment_beneficiary_info = new JLabel();
        p_payment_amount_info = new JLabel();
        p_payment_to_info = new JLabel();
        p_payment_contact_info = new JLabel();
        p_payment_type_info = new JLabel();
        p_payment_weight_info = new JLabel();
        p_payment_firstName_info = new JLabel();
        p_payment_lastName_info = new JLabel();
        p_payment_address_info = new JTextArea();
        p_payment_state_info = new JLabel();
        p_payment_district_info = new JLabel();
        p_payment_pincode_info = new JLabel();
        
        
        p_payment_address_info.setBackground(background_Color);
        p_payment_address_info.setEditable(false);
        p_payment_address_info.setHighlighter(null);
        p_payment_address_info.setLineWrap(true);
        
        //Content Label Text
        p_payment_beneficiary_info.setText("Admin");
        p_payment_amount_info.setText("12345");
        p_payment_to_info.setText("User_369");
        p_payment_contact_info.setText("1234567890");
        p_payment_type_info.setText("Parcel");
        p_payment_weight_info.setText("99");
        p_payment_firstName_info.setText("Hello");
        p_payment_lastName_info.setText("World");
        p_payment_address_info.setText("Sai Leo Nagar,West Tambaram Poonthandalam, Village, Chennai Tamil Nadu 602109.");
        p_payment_state_info.setText("Tamil Name");
        p_payment_district_info.setText("Salem");
        p_payment_pincode_info.setText("123456");
        
        //Button and title
        p_payment_title.setBounds(585, 25, 200, 50);
        p_payment_btn_confirm.setBounds(585,675,150,40);
        p_payment_btn_confirm.setBackground(primary_Color);
        p_payment_btn_confirm.setText("Confirm");
        p_payment_btn_confirm.setForeground(on_background_Color);
        p_payment_btn_confirm.setBorder(null);
        
        p_payment_btn_back.setBounds(25,25,40,40);
        p_payment_btn_back.setBackground(null);
        p_payment_btn_back.setBorder(null);
        try 
        {
          Image img = ImageIO.read(getClass().getResource("/Images/arroe_back_button.png"));
          p_payment_btn_back.setIcon(new ImageIcon(img));
        } 
        catch (Exception ex) 
        {
          System.out.println(ex);
        }
        
        //Label Bounds
        p_payment_beneficiary.setBounds(120, 0, 150, 50);
        p_payment_amount.setBounds(120, 50, 150, 50);
        p_payment_to.setBounds(120,100,150,50);
        p_payment_contact.setBounds(120,150,150,50);
        p_payment_type.setBounds(120,200,150,50);
        p_payment_weight.setBounds(120,250,150,50);
        p_payment_firstName.setBounds(120,300,150,50);
        p_payment_lastName.setBounds(120,350,150,50);
        p_payment_address.setBounds(120,400,150,50);
        p_payment_state.setBounds(120,500,150,50);
        p_payment_district.setBounds(120,550,150,50);
        p_payment_pincode.setBounds(120,600,150,50);
        
        //Content Label Bounds
        p_payment_beneficiary_info.setBounds(400, 0, 150, 50);
        p_payment_amount_info.setBounds(400, 50, 150, 50);
        p_payment_to_info.setBounds(400,100,150, 50);
        p_payment_contact_info.setBounds(400,150,150, 50);
        p_payment_type_info.setBounds(400,200,150, 50);
        p_payment_weight_info.setBounds(400,250,150, 50);
        p_payment_firstName_info.setBounds(400,300,150, 50);
        p_payment_lastName_info.setBounds(400,350,150, 50);
        p_payment_address_info.setBounds(400,410,800,90);
        p_payment_state_info.setBounds(400,500,150, 50);
        p_payment_district_info.setBounds(400,550,150, 50);
        p_payment_pincode_info.setBounds(400,600,150, 50);
        
        
        //Label Text Color
        p_payment_title.setForeground(on_background_Color);
        p_payment_beneficiary.setForeground(on_background_Color);
        p_payment_amount.setForeground(on_background_Color);
        p_payment_to.setForeground(on_background_Color);
        p_payment_contact.setForeground(on_background_Color);
        p_payment_type.setForeground(on_background_Color);
        p_payment_weight.setForeground(on_background_Color);
        p_payment_firstName.setForeground(on_background_Color);
        p_payment_lastName.setForeground(on_background_Color);
        p_payment_address.setForeground(on_background_Color);
        p_payment_state.setForeground(on_background_Color);
        p_payment_district.setForeground(on_background_Color);
        p_payment_pincode.setForeground(on_background_Color);
        
        //Content Label Text Color
        p_payment_beneficiary_info.setForeground(on_background_Color);
        p_payment_amount_info.setForeground(on_background_Color);
        p_payment_to_info.setForeground(on_background_Color);
        p_payment_contact_info.setForeground(on_background_Color);
        p_payment_type_info.setForeground(on_background_Color);
        p_payment_weight_info.setForeground(on_background_Color);
        p_payment_firstName_info.setForeground(on_background_Color);
        p_payment_lastName_info.setForeground(on_background_Color);
        p_payment_address_info.setForeground(on_background_Color);
        p_payment_state_info.setForeground(on_background_Color);
        p_payment_district_info.setForeground(on_background_Color);
        p_payment_pincode_info.setForeground(on_background_Color);
        
        //Label Font
        p_payment_title.setFont(new Font("Segoe UI", Font.PLAIN, 30));
        p_payment_beneficiary.setFont(new Font("Segoe UI", Font.PLAIN, 22));
        p_payment_amount.setFont(new Font("Segoe UI", Font.PLAIN, 22));
        p_payment_to.setFont(new Font("Segoe UI", Font.PLAIN, 22));
        p_payment_contact.setFont(new Font("Segoe UI", Font.PLAIN, 22));
        p_payment_type.setFont(new Font("Segoe UI", Font.PLAIN, 22));
        p_payment_weight.setFont(new Font("Segoe UI", Font.PLAIN, 22));
        p_payment_firstName.setFont(new Font("Segoe UI", Font.PLAIN, 22));
        p_payment_lastName.setFont(new Font("Segoe UI", Font.PLAIN, 22));
        p_payment_address.setFont(new Font("Segoe UI", Font.PLAIN, 22));
        p_payment_state.setFont(new Font("Segoe UI", Font.PLAIN, 22));
        p_payment_district.setFont(new Font("Segoe UI", Font.PLAIN, 22));
        p_payment_pincode.setFont(new Font("Segoe UI", Font.PLAIN, 22));
        
        //Content Label Font
        p_payment_beneficiary_info.setFont(new Font("Segoe UI", Font.PLAIN, 22));
        p_payment_amount_info.setFont(new Font("Segoe UI", Font.PLAIN, 22));
        p_payment_to_info.setFont(new Font("Segoe UI", Font.PLAIN, 22));
        p_payment_contact_info.setFont(new Font("Segoe UI", Font.PLAIN, 22));
        p_payment_type_info.setFont(new Font("Segoe UI", Font.PLAIN, 22));
        p_payment_weight_info.setFont(new Font("Segoe UI", Font.PLAIN, 22));
        p_payment_firstName_info.setFont(new Font("Segoe UI", Font.PLAIN, 22));
        p_payment_lastName_info.setFont(new Font("Segoe UI", Font.PLAIN, 22));
        p_payment_address_info.setFont(new Font("Segoe UI", Font.PLAIN, 22));
        p_payment_state_info.setFont(new Font("Segoe UI", Font.PLAIN, 22));
        p_payment_district_info.setFont(new Font("Segoe UI", Font.PLAIN, 22));
        p_payment_pincode_info.setFont(new Font("Segoe UI", Font.PLAIN, 22));
        
        p_payment_Panel.setBounds(X_FORCUSTOMER,Y_FORCUSTOMER,WIDTHFORCUSTOMER,HIGHTFORCUSTOMER);  
        p_payment_Panel.setPreferredSize(new Dimension(1350, 890));
        
        //Add to Panel
        p_payment_Panel.add(p_payment_title);
        p_payment_Panel.add(p_payment_beneficiary); 
        p_payment_Panel.add(p_payment_amount); 
        p_payment_Panel.add(p_payment_to); 
        p_payment_Panel.add(p_payment_contact); 
        p_payment_Panel.add(p_payment_type); 
        p_payment_Panel.add(p_payment_weight); 
        p_payment_Panel.add(p_payment_firstName); 
        p_payment_Panel.add(p_payment_lastName); 
        p_payment_Panel.add(p_payment_address);
        p_payment_Panel.add(p_payment_state);
        p_payment_Panel.add(p_payment_district);
        p_payment_Panel.add(p_payment_pincode);        
        
        p_payment_Panel.add(p_payment_beneficiary_info); 
        p_payment_Panel.add(p_payment_amount_info); 
        p_payment_Panel.add(p_payment_to_info); 
        p_payment_Panel.add(p_payment_contact_info); 
        p_payment_Panel.add(p_payment_type_info); 
        p_payment_Panel.add(p_payment_weight_info); 
        p_payment_Panel.add(p_payment_firstName_info); 
        p_payment_Panel.add(p_payment_lastName_info); 
        p_payment_Panel.add(p_payment_address_info);
        p_payment_Panel.add(p_payment_state_info); 
        p_payment_Panel.add(p_payment_district_info); 
        p_payment_Panel.add(p_payment_pincode_info);
        p_payment_Panel.add(p_payment_btn_confirm);
        
        
        p_payment_btn_back.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                JOptionPane.showMessageDialog(null, "This goes back to Parcel Panel");
            }
            
        });
        
        p_payment_btn_confirm.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                //e_payment_authentication.show(p_payment_Panel, 500, 500);
                new Authentication();
            }
            
        });  
        
        //Panel
        p_payment_Panel.setLayout(null);
        p_payment_Panel.setBackground(background_Color);
        p_payment_Panel.setSize(1350, 900);
        
        //Frame
        frame.add(p_payment_Panel);
        frame.add(p_payment_title);
        frame.add(p_payment_btn_back);
        
        frame.setSize(1350,890);
        frame.getContentPane().setBackground(background_Color);
        frame.setLayout(null);
        frame.setVisible(true);    
    }
    
//    public static void main(String arg[])
//    {
//        PaymentParcel paymentParcel = new PaymentParcel();
//    }
    
}
