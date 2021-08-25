package Delivery;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class delivery extends JPanel implements ActionListener
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
       
       deliveryCard=new CardLayout();
       ContentForDelivery=new JPanel(deliveryCard);
       PCompleted=new completed();
       Pongoing=new ongoing();
       
       ContentForDelivery.add(PCompleted,"completed");
       ContentForDelivery.add(Pongoing,"ongoing");
       ContentForDelivery.setBounds(X_FORCUSTOMER,Y_FORCUSTOMER,WIDTHFORCUSTOMER,HIGHTFORCUSTOMER);
       
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
       //IProfile.addMouseListener(this);
       IProfile.setBounds(1240,22, 50, 50);
       add(IProfile);
     
      
       userLogo=new JLabel();
       userLogo.setFont(new Font("Bold",Font.BOLD,20));
       userLogo.setBounds(1000+90,30,200,30);
       add( userLogo);
       
       BCompleted=new JButton("Completed");
       BCompleted.setFont(font);
       BCompleted.setBorder(null);
       BCompleted.setUI(new StyledButtonUI());
       BCompleted.setBounds(X_FORCUSTOMER,120,160,30);
       BCompleted.setBackground(Buttoncolor);
       
       BCompleted.addActionListener((e1)->{
       BCompleted.setBounds(X_FORCUSTOMER,120,160,30); 
       BOngoing.setBounds(X_FORCUSTOMER+120+60,110,160,30);
       deliveryCard.show(ContentForDelivery,"completed");
       });
       add(BCompleted); 
       
       BOngoing=new JButton("OnGoing");
       BOngoing.setFont(font);
       BOngoing.setBorder(null);
       BOngoing.setUI(new StyledButtonUI());
       BOngoing.setBackground(Buttoncolor);
       BOngoing.setBounds(X_FORCUSTOMER+120+60,110,160,30);
       
       BOngoing.addActionListener((e2)->{
       BCompleted.setBounds(X_FORCUSTOMER,110,160,30); 
       BOngoing.setBounds(X_FORCUSTOMER+120+60,120,160,30);
       deliveryCard.show(ContentForDelivery,"ongoing");
       });
       add(BOngoing);
       
       
    }
    public static void main(String [] args)
    {
        JFrame frame = new JFrame();
        frame.add(new delivery());
        frame.pack();
        frame.setVisible(true);
    }

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
}
