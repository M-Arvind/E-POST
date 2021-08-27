package Delivery;
import Consignment.*;
import Database.DatabaseOperations;
import static Delivery.ongoing.model;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import main.main;

public class delivery extends JPanel implements ActionListener,MouseListener
{    
    Icon image=new ImageIcon(getClass().getResource("/Images/ProfileImage.png"));
    public static CardLayout deliveryCard;
    public JPanel PCompleted,Pongoing;
    public JPanel ContentForDelivery;
    private JLabel LCustomer;
    private JLabel LE_Post,IProfile;
    private JTextArea search;
    private JLabel userLogo;
    private  JButton BCompleted,BOngoing;
    int X_FORCUSTOMER=55,Y_FORCUSTOMER=150,WIDTHFORCUSTOMER=1260,HIGHTFORCUSTOMER=570;
    private Font font=new Font("Bold",Font.BOLD,20);
    int R=34,G=34,B=45;
    private Color Buttoncolor=new Color(240,238,240);
    public delivery()
    {
       setLayout(null);
       
       deliveryCard = new CardLayout();
       ContentForDelivery=new JPanel(deliveryCard);
       Pongoing = new ongoing();
       PCompleted=new completed();
       
       
        ContentForDelivery.add(Pongoing,"ongoing");
       ContentForDelivery.add(PCompleted,"completed");      
       ContentForDelivery.setBounds(X_FORCUSTOMER,Y_FORCUSTOMER,WIDTHFORCUSTOMER,HIGHTFORCUSTOMER);
       deliveryCard.first(ContentForDelivery);
       
       add(ContentForDelivery);
       setPreferredSize(new Dimension(1350,890));
       setVisible(true);
       setBackground(new Color(R,G,B));
       
       LE_Post=new JLabel("E-Post");
       LE_Post.setFont(new Font("Segoe UI",Font.BOLD,30));
       LE_Post.setBounds(X_FORCUSTOMER, 30,100,30);
       LE_Post.setForeground(Color.WHITE);
       add(LE_Post);
       
       LCustomer=new JLabel("Delivery");
       LCustomer.setFont(new Font("Segoe UI",Font.PLAIN,20));
       LCustomer.setBounds(X_FORCUSTOMER+125,32,160,30);
       LCustomer.setForeground(Color.WHITE);
       add(LCustomer);
       
       search=new JTextArea("Search ID...");
       search.setFont(new Font("Segoe UI",Font.PLAIN,18));
       search.setBounds(1000,32,200,30);
       //search.addMouseListener(this);
       search.setBorder(BorderFactory.createEmptyBorder(2,5,0,5));
       add(search);
       
       IProfile=new JLabel(image);
       IProfile.addMouseListener(this);
       IProfile.setBounds(1240,22, 50, 50);
       add(IProfile);
     
      
       userLogo=new JLabel();
       userLogo.setFont(new Font("Bold",Font.BOLD,20));
       userLogo.setBounds(1000+90,30,200,30);
       add( userLogo);
       
       BOngoing=new JButton("OnGoing");
       BOngoing.setFont(font);
       BOngoing.setBorder(null);
       BOngoing.setUI(new StyledButtonUI());
       BOngoing.setBackground(Buttoncolor);
       BOngoing.setBounds(X_FORCUSTOMER+120+60,110,160,30);
       
       BOngoing.addActionListener((e2)->{       
       
       
       setOngoingDeliveryConsignmentDetails();
       BCompleted.setBounds(X_FORCUSTOMER,110,160,30); 
       BOngoing.setBounds(X_FORCUSTOMER+120+60,120,160,30);
       deliveryCard.show(ContentForDelivery,"ongoing");
       });
       add(BOngoing);
       
       BCompleted=new JButton("Completed");
       BCompleted.setFont(font);
       BCompleted.setBorder(null);
       BCompleted.setUI(new StyledButtonUI());
       BCompleted.setBounds(X_FORCUSTOMER-2,110,160,30);
       BCompleted.setBackground(Buttoncolor);
       
       BCompleted.addActionListener((e1)->{
       
       completedremoverow();  
       setCompletedDeliveryConsignmentDetails();                  
       BCompleted.setBounds(X_FORCUSTOMER-2,120,160,30); 
       BOngoing.setBounds(X_FORCUSTOMER+120+60,110,160,30);
       deliveryCard.show(ContentForDelivery,"completed");
       });
       add(BCompleted); 
       
       
       
       
    }
    public void ongoingremoverow()
    {
      
//       while(ongoing.model.getRowCount() > 0)
//       {
//         ongoing.model.removeRow(0);
//       }
        DefaultTableModel dm = (DefaultTableModel)ongoing.table.getModel();
        dm.getDataVector().removeAllElements();
        dm.fireTableDataChanged();
    }
    public void completedremoverow()
    {
      
       while(completed.model1.getRowCount() > 0)
       {
         completed.model1.removeRow(0);
       }
    }
    void setOngoingDeliveryConsignmentDetails()
    {
        ongoing.table.getSelectionModel().clearSelection();
        ongoingremoverow();        
        ArrayList<consignment> listForDeliveryConsignment = DatabaseOperations.getOnGoingDeliveryConsignmentDetails();         
        for(int i=0;i<listForDeliveryConsignment.size();i++)
        {
            consignment temp = listForDeliveryConsignment.get(i);
            ongoing.model.addRow(new Object[]{temp.getConsignment_ID(),temp.getCustomer_ID(),temp.getReceiver_ID(),temp.getItem(),temp.getDelivery_ID(),temp.getPayment_method(),temp.getDelivery_date(),temp.getStatus()});
        } 
    }
    void setCompletedDeliveryConsignmentDetails()
    {
        ArrayList<consignment> listForCompletedDeliveryConsignment = DatabaseOperations.getCompletedDeliveryConsignmentDetails();         
        for(int i=0;i<listForCompletedDeliveryConsignment.size();i++)
        {
           consignment temp1 = listForCompletedDeliveryConsignment.get(i);
           completed.model1.addRow(new Object[]{temp1.getConsignment_ID(),temp1.getCustomer_ID(),temp1.getReceiver_ID(),temp1.getItem(),temp1.getDelivery_ID(),temp1.getPayment_method(),temp1.getDelivery_date(),temp1.getStatus()});
        } 
    }
    /*public static void main(String [] args)
    {
        JFrame frame = new JFrame();
        frame.add(new delivery());
        frame.pack();
        frame.setVisible(true);
    }*/

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        Object select = e.getSource();
        System.out.println("ongoing");
        if(select == Pongoing)
        {
          System.out.println("in -ongoing");
          BCompleted.setBounds(X_FORCUSTOMER,110,160,30); 
          BOngoing.setBounds(X_FORCUSTOMER+120+60,120,160,30);
          deliveryCard.show(ContentForDelivery,"ongoing");
        }
        else if(select == PCompleted)
        {
           System.out.println("in -ongoing");
           BCompleted.setBounds(X_FORCUSTOMER,110,170,30); 
           BOngoing.setBounds(X_FORCUSTOMER+120+60,110,160,30);
           deliveryCard.show(ContentForDelivery,"completed");
        }      
    
    }
    @Override
    public void mouseClicked(MouseEvent e) 
    {
        //if(e.getSource()==search){
            //search.setText("");
        //}
            if(e.getSource() == IProfile)
            main.switchPage("deliveryProfileView");
        }

    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getSource() == IProfile)
            main.switchPage("DeliveryProfile");
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
