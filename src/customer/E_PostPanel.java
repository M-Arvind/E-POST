package customer;
import main.*;
import java.awt.Color;
import customer.DatasForCustomer.*;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Line2D;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Vector;
import javax.swing.BorderFactory;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
public class E_PostPanel extends JPanel implements ActionListener {
    private JButton BSend;
     private JLabel LTo,LHardCopy,LSoftCopy,LFirstName,LLastName,LAddress,LState,LDistrict,LPincode,LPhoneNumber,LMessage;
     private JTextField TTo,TFirstname,TLastName,TPincode,TPhoneNumber,TSubject;
     private JTextArea TAddress,Message;
     private JComboBox CState,CDistrict,CPincode;
     private JCheckBox SoftCopy,HardCopy;
     private Font font=new Font("Segoe UI",Font.PLAIN,22);
     private Font fontForText=new Font("Segoe UI",Font.PLAIN,17);
     private Border border;
     private Color Cpanel = new Color(254,254,254);
    private Color Cback = new Color(34,34,44);
    private Color Cbutton = new Color(71,63,144);	
    private static Vector<String> infoState=new Vector();
    private static Vector<String> infoCity=new Vector();
    public E_PostPanel(){
          setLayout(null);
          LTo=new JLabel("To");
          LTo.setBounds(40,25,25,40);
          LTo.setFont(font);
          add(LTo);
          
          border=BorderFactory.createLineBorder(Color.BLACK,1);
          TTo=new JTextField();
          TTo.setBounds(40,70,200,28);
          TTo.setBorder(border);
          TTo.setFont(fontForText);
          add(TTo);
          
          LFirstName=new JLabel("FirstName");
          LFirstName.setFont(font);
          LFirstName.setBounds(40,100,100,40);
          add(LFirstName);
          
          TFirstname=new JTextField();
          TFirstname.setBounds(40,145,200,28);
          TFirstname.setBorder(border);
          TFirstname.setFont(fontForText);
          add(TFirstname);
          
          
          LLastName=new JLabel("LastName");
          LLastName.setFont(font);
          LLastName.setBounds(350,100,100,40);
          add(LLastName);
          
          TLastName=new JTextField();
          TLastName.setBounds(350,145,200,28);
          TLastName.setBorder(border);
          TLastName.setFont(fontForText);
          add(TLastName);
          
          LAddress=new JLabel("Address");
          LAddress.setFont(font);
          LAddress.setBounds(40,175,100,40);
          add(LAddress);
          
          TAddress=new JTextArea();
          TAddress.setLineWrap(true);
          TAddress.setBounds(40,215,565,100);
          TAddress.setBorder(border);
          TAddress.setFont(fontForText);
          add(TAddress);
          
          LState=new JLabel("State");
          LState.setBounds(40,318,60,40);
          LState.setFont(font);
          add(LState);
          
          CState=new JComboBox(this.getState());
          CState.setBounds(40,360,200,28);
          CState.setFont(font);
          add(CState);
          
          LDistrict=new JLabel("District");
          LDistrict.setFont(font);
          LDistrict.setBounds(350,318,80,40);
          add(LDistrict);
          
          CDistrict=new JComboBox(this.getCity());
          CDistrict.setBounds(350,318+42,200,28);
          CDistrict.setFont(font);
          add(CDistrict);
          
          LPincode=new JLabel("Pincode");
          LPincode.setBounds(40,400,80,40);
          LPincode.setFont(font);
          add(LPincode);
          
          TPincode=new JTextField();
          TPincode.setBounds(40,440,200,28);
          TPincode.setBorder(border);
          TPincode.setFont(fontForText);
          add(TPincode);
         
          LPhoneNumber=new JLabel("Phone Number");
          LPhoneNumber.setBounds(350,400, 130, 40);
          LPhoneNumber.setFont(font);
          add(LPhoneNumber);
          
          TPhoneNumber=new JTextField();
          TPhoneNumber.setBounds(350,400+42,200,28);
          TPhoneNumber.setFont(fontForText);
          TPhoneNumber.setBorder(border);
          add(TPhoneNumber);
          
           LMessage=new JLabel("Message");
          LMessage.setBounds(680,25, 130, 40);
          LMessage.setFont(font);
          add(LMessage);
          
           TSubject=new JTextField();
          TSubject.setBounds(680,70,500,28);
          TSubject.setFont(fontForText);
          TSubject.setBorder(border);
          add(TSubject);
          
          Message=new JTextArea();
          Message.setLineWrap(true);
          Message.setFont(fontForText);
          Message.setBorder(BorderFactory.createLineBorder(Color.black, 1));
          JScrollPane messageScrool=new JScrollPane(Message);
          messageScrool.setBounds(680,110,500,442-32-50);
          add(messageScrool);
         
         
          SoftCopy=new JCheckBox("Soft Copy");
          SoftCopy.setBounds(300,60,123,40);
          SoftCopy.setFont(font);
          add(SoftCopy);
          
          HardCopy=new JCheckBox("HardCopy");
          HardCopy.setBounds(450,60,125,40);
          HardCopy.setFont(font);
          add( HardCopy);
          //WIDTHFORCUSTOMER=1260,HIGHTFORCUSTOMER=570;
          BSend=new JButton("Send");
          BSend.setBounds((1260/2)-20,520,120,30);
          BSend.setBackground(Cbutton);
          BSend.setForeground(Color.white);
          BSend.setFont(font);
          BSend.addActionListener(this);
          add(BSend);
        
          
 
    }
    @Override
    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2=(Graphics2D)g;
        Line2D lin=new Line2D.Float(630,100,1260/2,450);
        g2.draw(lin);
    }
    public Vector getState(){
     
         infoState.add("Andhra Pradesh");
         infoState.add("Haryana");
         infoState.add("Manipur");
         infoState.add("Sikkim");
         infoState.add("Andhra Pradesh");
         infoState.add("Arunachal Pradesh");
         infoState.add("Himachal Pradesh");
         infoState.add("Meghalaya");
            infoState.add("Tamil Nadu");
         infoState.add("Assam");
         infoState.add("Jharkhand");
         infoState.add("Mizoram");
                infoState.add("Telangana");
         infoState.add("Bihar");
         infoState.add("Karnataka");
         infoState.add("Nagaland");
            infoState.add("Tripura");
         infoState.add("Chhattisgarh");
         infoState.add("Kerala");
         infoState.add("Odisha");
               infoState.add("Uttarakhand");
         infoState.add("Goa");
         infoState.add("Madhya Pradesh");
         infoState.add("Punjab");
               infoState.add("Uttar Pradesh");
         infoState.add("Gujarat");
         infoState.add("Maharashtra");
         infoState.add("Rajasthan");
             infoState.add("West Bengal");
         infoState.add("Haryana");
         infoState.add("Manipur");
         infoState.add("Sikkim");

        return infoState;
    }
    public Vector getCity(){
        infoCity.add("Chennai");
         infoCity.add("Coimbatore");
         infoCity.add("Madurai");
         infoCity.add("Tiruchirappalli");
         infoCity.add("Tiruppur");
         infoCity.add("Salem");infoCity.add("Erode");
         infoCity.add("Tirunelveli");
         infoCity.add("Vellore");
         infoCity.add("Thoothukkudi");
          infoCity.add("Dindigul");
         infoCity.add("Thanjavur");
         infoCity.add("Ranipet");
         infoCity.add("Sivakasi");
         infoCity.add("Karur");
         infoCity.add("Udhagamandalam");infoCity.add("Hosur");
         infoCity.add("Nagercoil");
         infoCity.add("Kanchipuram");
         infoCity.add("Kumarapalayam");
         infoCity.add("Karaikkudi");
         infoCity.add("Neyveli");
         infoCity.add("Cuddalore");
         infoCity.add("Kumbakonam");
         infoCity.add("Tiruvannamalai");
         infoCity.add("Pollachi");infoCity.add("Rajapalayam");
         infoCity.add("Gudiyatham");
         infoCity.add("Pudukkottai");
         infoCity.add("Vaniyambadi");
         infoCity.add("Ambur");
         infoCity.add("Nagapattinam");
        return infoCity;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        main.switchPage("paymentEPost");
        TTo,TFirstname,TLastName,TPincode,TPhoneNumber,TSubject;
        TAddress,Message
      
    }
    
}
