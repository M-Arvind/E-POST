package customer;
import customer.DatasForCustomer.ConsignmentData;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileNotFoundException;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import main.main;
import Admin.StyledButtonUi;
import javax.swing.plaf.ButtonUI;
public class CustomerPanel extends JPanel implements ActionListener, MouseListener{
    
    private JLabel LE_Post,IProfile;
    Icon image=new ImageIcon(getClass().getResource("/Images/ProfileImage.png"));
    private  JPanel customerPanel;
    public static JPanel contentForCustomer;
    public static CardLayout customerCard=null;
    public  static JButton BInbox,BConsignment,BE_Post,BParcel,BProducts,BWallet;
    private  int xForInbox=0,xForConsignment=0,xForE_post=0,xForParcel=0,xForProducts=0,xForWallets=0;
    public  static JPanel PInbox,PConsignment,PE_Post,PParcel,PProducts,PWallet,PConsignmentDetails;
    int X_FORCUSTOMER=55,Y_FORCUSTOMER=150,WIDTHFORCUSTOMER=1260,HIGHTFORCUSTOMER=570;
    int R=34,G=34,B=45;
    private Color Buttoncolor=new Color(240,238,240);
    private JTextArea search;
    private JLabel LCustomer;
    private Font font=new Font("Bold",Font.BOLD,20);
    private JLabel userLogo;
    ButtonUI ui=new StyledButtonUi();
   public CustomerPanel() {
    
       setLayout(null);
       customerCard=new CardLayout();
       contentForCustomer=new JPanel(customerCard);
       //PInbox=new InboxPanel();
       //PConsignment=new ConsignmentPanel();
       PE_Post=new E_PostPanel();
       PParcel=new ParcelPanel();
       PProducts=new ProductsPanel();
       PWallet=new WalletPanel();
       PConsignmentDetails=new ConsignmentDetails();
      
       //InboxPanel inboxPanel=(InboxPanel)PInbox;
       //contentForCustomer.add(PInbox,"Inbox");
       //contentForCustomer.add(PConsignment,"Consignment");
       contentForCustomer.add(PE_Post,"E-Post");
       contentForCustomer.add(PParcel,"Parcel");
       contentForCustomer.add(PProducts,"Products");
       contentForCustomer.add(PWallet,"Wallet");
       contentForCustomer.add(PConsignmentDetails,"ConsignmentDetails");
       //contentForCustomer.add(inboxPanel.scroll,"MessagePanel");
       customerCard.first(contentForCustomer);
       contentForCustomer.setBounds(X_FORCUSTOMER,Y_FORCUSTOMER,WIDTHFORCUSTOMER,HIGHTFORCUSTOMER);
       add(contentForCustomer);
       setPreferredSize(new Dimension(1350,890));
       setVisible(true);
       setBackground(new Color(R,G,B));
       LE_Post=new JLabel("E-Post");
       LE_Post.setFont(new Font("Segoe UI",Font.BOLD,30));
       LE_Post.setBounds(X_FORCUSTOMER, 30,100,30);
       LE_Post.setForeground(Color.WHITE);
       add(LE_Post);
       
       LCustomer=new JLabel("Customer");
       LCustomer.setFont(new Font("Segoe UI",Font.PLAIN,20));
       LCustomer.setBounds(X_FORCUSTOMER+125,32,160,30);
       LCustomer.setForeground(Color.WHITE);
       add(LCustomer);
       
       search=new JTextArea("Search ID...");
       search.setFont(new Font("Segoe UI",Font.PLAIN,18));
       search.setBounds(1000,32,200,30);
       search.addMouseListener(this);
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
       
       BInbox=new JButton("Inbox");
       BInbox.setFont(font);
       BInbox.setBorder(null);
       BInbox.setUI(ui);
       BInbox.setBounds(X_FORCUSTOMER,120,160,30);
       BInbox.setBackground(Buttoncolor);
       BInbox.addActionListener(this);
       add(BInbox); 
       
       BConsignment=new JButton("Consignment");
       BConsignment.setFont(font);
       BConsignment.setBackground(Buttoncolor);
       BConsignment.setUI(ui);
       BConsignment.setBounds(X_FORCUSTOMER+120+60,110,160,30);
       BConsignment.addActionListener(this);
       add(BConsignment);
       
       BE_Post=new JButton("E-Post");
       BE_Post.setFont(font);
       BE_Post.setBackground(Buttoncolor);
       BE_Post.setUI(ui);
       BE_Post.setBounds(X_FORCUSTOMER+180+180,110,160,30);
       BE_Post.addActionListener(this);
       add(BE_Post);
       
       
       
       BParcel=new JButton("Parcel");
       BParcel.setFont(font);
       BParcel.setBackground(Buttoncolor);
       BParcel.setUI(ui);
       BParcel.setBounds(X_FORCUSTOMER+180+180+180,110,160,30);
       BParcel.addActionListener(this);
       add(BParcel);
       
       BProducts=new JButton("Products");
       BProducts.setFont(font);
       BProducts.setBackground(Buttoncolor);
       BProducts.setUI(ui);
       BProducts.setBounds(X_FORCUSTOMER+180+180+180+180,110,160,30);
       BProducts.addActionListener(this);
       add(BProducts);
       
       BWallet=new JButton("Wallet");
       BWallet.setBackground(Buttoncolor);
       BWallet.setFont(font);
       BWallet.setUI(ui);
       BWallet.setBounds(X_FORCUSTOMER+180+180+180+180+180,110,160,30);
       BWallet.addActionListener(this);
       add(BWallet);
       
       
   }
   
    @Override
    public void actionPerformed(ActionEvent e) {
        Object o=e.getSource();
        
        if(o==BInbox){
            BInbox.setBounds(X_FORCUSTOMER,120,160,30);
            customerCard.show(contentForCustomer,"Inbox");
             
            BConsignment.setBounds(X_FORCUSTOMER+120+60,110,160,30);
            BE_Post.setBounds(X_FORCUSTOMER+180+180,110,160,30);
            BParcel.setBounds(X_FORCUSTOMER+180+180+180,110,160,30);
            BProducts.setBounds(X_FORCUSTOMER+180+180+180+180,110,160,30);
            BWallet.setBounds(X_FORCUSTOMER+180+180+180+180+180,110,160,30);
           
        }
        else if(o==BConsignment){
            BConsignment.setBounds(X_FORCUSTOMER+120+60,120,160,30);
             if(!ConsignmentData.isIsUpdate())
                 customerCard.show(contentForCustomer,"Consignment");
             else{
               if(PConsignment!=null){
                 PConsignment.removeAll();
                 PConsignment=null;  
                }
                 customerCard.show(contentForCustomer,"1");
             }
             BInbox.setBounds(X_FORCUSTOMER,110,160,30);
             BE_Post.setBounds(X_FORCUSTOMER+180+180,110,160,30);
            BParcel.setBounds(X_FORCUSTOMER+180+180+180,110,160,30);
            BProducts.setBounds(X_FORCUSTOMER+180+180+180+180,110,160,30);
            BWallet.setBounds(X_FORCUSTOMER+180+180+180+180+180,110,160,30);
        }    
        else if(o==BE_Post) {
            BE_Post.setBounds(X_FORCUSTOMER+180+180,120,160,30);
                customerCard.show(contentForCustomer,"E-Post");
                
                 BInbox.setBounds(X_FORCUSTOMER,110,160,30);
                 BConsignment.setBounds(X_FORCUSTOMER+120+60,110,160,30);
                 BParcel.setBounds(X_FORCUSTOMER+180+180+180,110,160,30);
                 BProducts.setBounds(X_FORCUSTOMER+180+180+180+180,110,160,30);
                BWallet.setBounds(X_FORCUSTOMER+180+180+180+180+180,110,160,30);
                }
        else if(o==BParcel)  {
             BParcel.setBounds(X_FORCUSTOMER+180+180+180,120,160,30);
                customerCard.show(contentForCustomer,"Parcel");
                
                 BInbox.setBounds(X_FORCUSTOMER,110,160,30);
                 BConsignment.setBounds(X_FORCUSTOMER+120+60,110,160,30);
                 BE_Post.setBounds(X_FORCUSTOMER+180+180,110,160,30);
                 BProducts.setBounds(X_FORCUSTOMER+180+180+180+180,110,160,30);
                 BWallet.setBounds(X_FORCUSTOMER+180+180+180+180+180,110,160,30);
                }
        else if(o==BProducts){
                BProducts.setBounds(X_FORCUSTOMER+180+180+180+180,120,160,30);
                customerCard.show(contentForCustomer,"Products");
                
                BInbox.setBounds(X_FORCUSTOMER,110,160,30);
                BConsignment.setBounds(X_FORCUSTOMER+120+60,110,160,30);
                BE_Post.setBounds(X_FORCUSTOMER+180+180,110,160,30);
                BParcel.setBounds(X_FORCUSTOMER+180+180+180,110,160,30);
                BWallet.setBounds(X_FORCUSTOMER+180+180+180+180+180,110,160,30);
               
        }
        else if(o==BWallet){
            BWallet.setBounds(X_FORCUSTOMER+180+180+180+180+180,120,160,30);
            customerCard.show(contentForCustomer,"Wallet");
            
            BInbox.setBounds(X_FORCUSTOMER,110,160,30);
            BConsignment.setBounds(X_FORCUSTOMER+120+60,110,160,30);
            BE_Post.setBounds(X_FORCUSTOMER+180+180,110,160,30);
            BParcel.setBounds(X_FORCUSTOMER+180+180+180,110,160,30);
            BProducts.setBounds(X_FORCUSTOMER+180+180+180+180,110,160,30);
   
        }
    
    }  
  
    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource()==search){
            search.setText("");
        }
        else if(e.getSource() == IProfile)
            main.switchPage("Profile");
        }

    @Override
    public void mousePressed(MouseEvent e) {
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
