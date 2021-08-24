package e_post;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Line2D;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
class ConsignmentDetails extends JPanel implements ActionListener{
    private JLabel consignDetail, item, itemPrice, itemWeight, itemCode, agentId, orderDate, deliverDate, payment, status;
    private JLabel billingDetail, senderId, seFirstName, seLastName, seConstact, seAddress;
    private JLabel shipDetails, receId, receFirstName, receLastName, receContact, receAdress;
    
    private JLabel vConsignDetail, vItem, vItemPrice, vItemWeight, vItemCode, vAgentId, vOrderDate, vDeliverDate, vPayment, vStatus;
    private JLabel vSenderId, vSeFirstName, vSeLastName, vSeConstact, vSeAddress;
    private JLabel vReceId, vReceFirstName, vReceLastName, vReceContact, vReceAdress;
    
    Icon icon;
    private JButton back;
    private JPanel details; 
    
    public void paint(Graphics gp) { super.paint(gp); Graphics2D graphics = (Graphics2D) gp;
        Line2D line = new Line2D.Float(100, 210, 1160, 210);
        Line2D line1 = new Line2D.Float(620,210,620,480);
     
      graphics.draw(line);
      graphics.draw(line1);
    }
    
    public ConsignmentDetails(){
        Color bg = new Color(34, 34, 45);
        Color fg = new Color(254, 254, 254);
        Color pri = new Color(71, 63, 145);
         
        details = new JPanel(null);

        details.setBackground(fg);
        details.setPreferredSize(new Dimension(1260, 590));
        Font font = new Font("Segoe UI", Font.BOLD, 22);
        Font fon = new Font("Segoe UI", Font.PLAIN, 18);
        icon=new ImageIcon(getClass().getResource("/Images/back.png"));  
        
        back = new JButton(icon);
        back.setBounds(10, 10, 30, 30);
        back.setBackground(fg);
        back.setBorder(null);
        back.addActionListener(this);
        details.add(back);
        
        consignDetail = new JLabel("Consignment Details");
        consignDetail.setFont(font);
        item = new JLabel("Item             :");
        item.setFont(fon);
        itemPrice = new JLabel("ItemPrice      :");
        itemPrice.setFont(fon);
        itemWeight = new JLabel("Item Weight  :");
        itemWeight.setFont(fon);
        itemCode = new JLabel("Item Code   :");
        itemCode.setFont(fon);     
        agentId = new JLabel("Agent ID      :");
        agentId.setFont(fon);
        orderDate = new JLabel("Order Date  :");
        orderDate.setFont(fon);
        deliverDate = new JLabel("Delivery Date  :");
        deliverDate.setFont(fon);
        payment = new JLabel("Payment         :");
        payment.setFont(fon);
        status = new JLabel("Status            :");
        status.setFont(fon);
        
        vItem = new JLabel("E Post");
        vItem.setFont(fon);
        vItemPrice = new JLabel("5");
        vItemPrice.setFont(fon);
        vItemWeight = new JLabel("5 g");
        vItemWeight.setFont(fon);
        vItemCode = new JLabel("!@#$%");
        vItemCode.setFont(fon);
        vAgentId = new JLabel("12345");
        vAgentId.setFont(fon);
        vOrderDate = new JLabel("29.09.2001");
        vOrderDate.setFont(fon);
        vDeliverDate = new JLabel("29.09.2021");
        vDeliverDate.setFont(fon);
        vPayment = new JLabel("E PAY");
        vPayment.setFont(fon);
        vStatus = new JLabel("Delivered");
        vStatus.setFont(fon);
                  
        
        billingDetail = new JLabel("Billint Details");
        billingDetail.setFont(font);
        senderId = new JLabel("Sender ID          :");
        senderId.setFont(fon);
        seFirstName = new JLabel("First Name         :");
        seFirstName.setFont(fon); 
        seLastName = new JLabel("Last Name         :");
        seLastName.setFont(fon);
        seConstact = new JLabel("Contact Number :");
        seConstact.setFont(fon);
        seAddress = new JLabel("Address            :");
        seAddress.setFont(fon);
        
        vSenderId = new JLabel("1223241");
        vSenderId.setFont(fon);
        vSeFirstName = new JLabel("Keshav");
        vSeFirstName.setFont(fon);
        vSeLastName = new JLabel("B");
        vSeLastName.setFont(fon);
        vSeConstact = new JLabel("8754275064");
        vSeConstact.setFont(fon);
        vSeAddress = new JLabel("<html>"+"48/18c, Lakshmi nagar Convent Road Mittapudhur Salem asfjcbakvbcadljvhbcadjdsvc ksdhvhbc jhskdhvckjsdvcjshdvkjcsdzkjvc jhjv v vjk v"+"</html>");
        vSeAddress.setFont(fon);
        
        shipDetails = new JLabel("Shipping Details");
        shipDetails.setFont(font);
        receId = new JLabel("Reciever ID       :");
        receId.setFont(fon);
        receFirstName = new JLabel("First Name         :");
        receFirstName.setFont(fon);
        receLastName = new JLabel("Last Name         :");
        receLastName.setFont(fon);
        receContact = new JLabel("Contact Number :");
        receContact.setFont(fon);
        receAdress = new JLabel("Address            :");
        receAdress.setFont(fon);
        
        vReceId = new JLabel("12345");
        vReceId.setFont(fon);
        vReceFirstName = new JLabel("Arvind");
        vReceFirstName.setFont(fon);
        vReceLastName = new JLabel("M");
        vReceLastName.setFont(fon);
        vReceContact = new JLabel("123456789");
        vReceContact.setFont(fon);
        vReceAdress = new JLabel("<html>"+"48/18c, Lakshmi nagar Convent Road Mittapudhur Salem asfjcbakvbcadljvhbcadjdsvc ksdhvhbc jhskdhvckjsdvcjshdvkjcsdzkjvc jhjv v vjk v"+"</html>");       
        vReceAdress.setFont(fon);
        
        consignDetail.setBounds(80, 40, 240, 40);
        item.setBounds(100, 80, 200, 40);
        itemPrice.setBounds(100, 120, 240, 40);
        itemWeight.setBounds(100, 160, 240, 40);
        itemCode.setBounds(500, 80, 240, 40);
        agentId.setBounds(500, 120, 240, 40);
        orderDate.setBounds(500, 160, 240, 40);
        deliverDate.setBounds(930, 80, 240, 40);
        payment.setBounds(930, 120, 240, 40);
        status.setBounds(930, 160, 240, 40);
        
        vItem.setBounds(220, 80, 240, 40);
        vItemPrice.setBounds(220, 120, 240, 40);
        vItemWeight.setBounds(220, 160, 240, 40);
        vItemCode.setBounds(650, 80, 240, 40);
        vAgentId.setBounds(650, 120, 240, 40);
        vOrderDate.setBounds(650, 160, 240, 40);
        vDeliverDate.setBounds(1080, 80, 240, 40);
        vPayment.setBounds(1080, 120, 240, 40);
        vStatus.setBounds(1080, 160, 240, 40);
        
        billingDetail.setBounds(80, 210, 240, 40);
        senderId.setBounds(100, 250, 240, 40);
        seFirstName.setBounds(100, 290, 240, 40);
        seLastName.setBounds(100, 330, 240, 40);
        seConstact.setBounds(100, 370, 240, 40);
        seAddress.setBounds(100, 410, 240, 40);
        
        vSenderId.setBounds(270, 250, 240, 40);
        vSeFirstName.setBounds(270, 290, 240, 40);
        vSeLastName.setBounds(270, 330, 240, 40);
        vSeConstact.setBounds(270, 370, 240, 40);
        vSeAddress.setBounds(270, 410, 350, 120);
        
        shipDetails.setBounds(660, 210, 240, 40);
        receId.setBounds(680, 250, 240, 40);
        receFirstName.setBounds(680, 290, 240, 40);
        receLastName.setBounds(680, 330, 240, 40);
        receContact.setBounds(680, 370, 240, 40);
        receAdress.setBounds(680, 410, 240, 40);
        
        vReceId.setBounds(840, 250, 240, 40);
        vReceFirstName.setBounds(840, 290, 240, 40);
        vReceLastName.setBounds(840, 330, 240, 40);
        vReceContact.setBounds(840, 370, 240, 40);
        vReceAdress.setBounds(840, 410, 350, 120);
        
        details.add(vItem);
        details.add(vItemCode);
        details.add(vItemPrice);
        details.add(vItemWeight);
        details.add(vAgentId);
        details.add(vOrderDate);
        details.add(vDeliverDate);
        details.add(vPayment);
        details.add(vStatus);
        
        details.add(vSenderId);
        details.add(vSeFirstName);
        details.add(vSeLastName);
        details.add(vSeConstact);
        details.add(vSeAddress);
        
        details.add(vReceId);
        details.add(vReceFirstName);
        details.add(vReceLastName);
        details.add(vReceContact);
        details.add(vReceAdress);
        
        details.add(shipDetails);
        details.add(receId);
        details.add(receFirstName);
        details.add(receLastName);
        details.add(receContact);
        details.add(receAdress);
        
        details.add(billingDetail);
        details.add(senderId);
        details.add(seFirstName);
        details.add(seLastName);
        details.add(seConstact);
        details.add(seAddress);
        
        details.add(item);
        details.add(itemPrice);
        details.add(itemWeight);
        details.add(itemCode);
        details.add(agentId);
        details.add(orderDate);
        details.add(deliverDate);
        details.add(payment);
        details.add(status);
        details.add(consignDetail);


        this.add(details);
        
       
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        CustomerPanel.customerCard.show(CustomerPanel.contentForCustomer,"Consignment");
    }

}
