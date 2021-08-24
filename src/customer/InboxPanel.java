package e_post;
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class InboxPanel extends JPanel implements MouseListener{
   private Integer index;
   private JLabel icon,Sender_Name,Subject,Date,Time;
   JList Jlist=new JList();
   BasicStroke stroke=new BasicStroke();
   Border border=BorderFactory.createRaisedBevelBorder();
   Icon image=new ImageIcon(getClass().getResource("/Images/profile.png"));
   int fontSize=16;
   Font font=new Font("Bold",Font.BOLD,fontSize);
   Integer i=0,y=0;
   JPanel MyPanel;
   public  JScrollPane scroll;
   CardLayout card=new CardLayout();
   InboxPanel(){
       setLayout(card);
       MyPanel=new JPanel();
       MyPanel.setLayout(null);
       MyPanel.setPreferredSize(new Dimension(1260,3000));
       while(i<=20){
           JPanel temp=this.getPanel(i, y);
           temp.addMouseListener(this);
           MyPanel.add(temp); 
           y=y+130;
           
           i++;
       } 
      scroll=new JScrollPane(MyPanel,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
      scroll.setPreferredSize(new Dimension(1230,540));
      add(scroll,"MessagePanel");
      card.show(this,"MessagePanel");
      //CustomerPanel.customerCard.show(CustomerPanel.contentForCustomer,"MessagePanel");
      setPreferredSize(new Dimension(1260,750));
  
    }
     public JPanel getPanel(Integer i,Integer y){
        JPanel panel1=new JPanel(null);
        icon=new JLabel(image);
        icon.setBounds(10,10,50,50);
        Sender_Name=new JLabel();
        Sender_Name.setBounds(70,-20,100,100);
        Sender_Name.setFont(font);
        Subject=new JLabel("Thanks For Your Dinner!..");
        Subject.setBounds(90,5,300,100);
        Subject.setFont(font);
        Date=new JLabel("08/18/2021");
        Date.setBounds(900,15,100,28);
        Date.setFont(font);
        Time=new JLabel("12:01:22");
        Time.setBounds(900,40,100,28);
        Time.setFont(font);
        panel1.add(Time);
        panel1.add(icon);
        panel1.add(Sender_Name);
        panel1.add(Subject);
        panel1.add(Date);
        panel1.setBounds(120,90+y,1000,85);
        panel1.setBackground(Color.white);
        panel1.setBorder(border);
        panel1.setName(i.toString());
        return panel1;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        JPanel p=(JPanel)e.getSource();
        System.out.println(p.getName());
        index=Integer.valueOf(p.getName());
        add(getViewInbox(index),"viewMessage");
        card.show(this,"viewMessage");

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
    public JPanel getViewInbox(int i){
        JPanel viewMessage=new JPanel(null);
        viewMessage.setPreferredSize(new Dimension(1260,750));
        
        Icon icon=new ImageIcon(getClass().getResource("/Images/back.png"));
        JButton back=new JButton(icon);
        back.setBounds(10,10,30,30);
        back.setBackground(Color.white);
        back.setBorder(null);
        back.addActionListener((e)->{card.show(this, "MessagePanel");}
        );
        
        JLabel ProfileIcon=new JLabel(image);
        ProfileIcon.setBounds(50,65,50,50);
        
        Sender_Name=new JLabel("Gowtham");
        Sender_Name.setBounds(120,50,200,28);
        Sender_Name.setFont(font);
        Subject=new JLabel("Thanks For Your Dinner!..");
        Subject.setBounds(120,90,500,100);
        Subject.setFont(font);
        
        Date=new JLabel("08/18/2021");
        Date.setBounds(900,15,100,28);
        Date.setFont(font);
        
        Time=new JLabel("12:01:22");
        Time.setBounds(900,40,100,28);
        Time.setFont(font);
        
        JTextArea message=new JTextArea();
        message.setWrapStyleWord(true);
        message.setLineWrap(true);
        message.setEditable(false);
        String m="POST OFFICE walks in every walk of our life. The world has had so many evolutions but still there are some people who couldn’t handle the emailing system especially in rural areas. To make things simpler and make the postal service available for anyone from anywhere E POST OFFICE SYSTEM is introduced. With the E Post system, we can send messages as soft copy and it will be delivered to the destination as a hard copy. The vision lies in focusing on those rural areas of India which face problems of accessing internet facilities";
        message.setText(m);
        message.setFont(font);
        message.setBounds(120,190,990,370);
        message.setBorder(BorderFactory.createRaisedBevelBorder());
        
        viewMessage.add(ProfileIcon);
        viewMessage.add(Time);
        viewMessage.add(Sender_Name);
        viewMessage.add(Subject);
        viewMessage.add(Date);
        viewMessage.add(back);
        viewMessage.add(message);
        viewMessage.setBackground(Color.white);
        return viewMessage;
        
    }
   
}
