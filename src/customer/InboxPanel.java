package customer;
import Database.DatabaseOperations;
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
import customer.DatasForCustomer.*;
import java.sql.*;
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
       // my insertion
       DatabaseOperations.getInboxDetails();
       // my insertion
       while(i<InboxData.ListForInbox.size()){
           JPanel temp=this.getPanel(i, y);
           temp.addMouseListener(this);
           MyPanel.add(temp); 
           y=y+130;
           
           i++;
       } 
      scroll=new JScrollPane(MyPanel,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
      add(scroll,"MessagePanel");
      card.show(this,"MessagePanel");
      //CustomerPanel.customerCard.show(CustomerPanel.contentForCustomer,"MessagePanel");
     
  
    }
     public JPanel getPanel(Integer i,Integer y){
        JPanel panel1=new JPanel(null);
        icon=new JLabel(image);
        icon.setBounds(10,10,50,50);
        Sender_Name=new JLabel(InboxData.ListForInbox.get(i).getSender_name());
        Sender_Name.setBounds(70,-20,100,100);
        Sender_Name.setFont(font);
        Subject=new JLabel(InboxData.ListForInbox.get(i).getSubject());
        Subject.setBounds(90,5,300,100);
        Subject.setFont(font);
        Date=new JLabel(InboxData.ListForInbox.get(i).getSent_Date().substring(0,10));
        Date.setBounds(900,15,100,28);
        Date.setFont(font);
        Time=new JLabel(InboxData.ListForInbox.get(i).getTime().substring(10));
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
        
        Sender_Name=new JLabel(InboxData.ListForInbox.get(i).getSender_name());
        Sender_Name.setBounds(120,50,200,28);
        Sender_Name.setFont(font);
        Subject=new JLabel(InboxData.ListForInbox.get(i).getSubject());
        Subject.setBounds(120,90,500,100);
        Subject.setFont(font);
        
        Date=new JLabel(InboxData.ListForInbox.get(i).getSent_Date().substring(0,10));
        Date.setBounds(900,15,100,28);
        Date.setFont(font);
        
        Time=new JLabel(InboxData.ListForInbox.get(i).getTime().substring(10));
        Time.setBounds(900,40,100,28);
        Time.setFont(font);
        
        JTextArea message=new JTextArea();
        message.setWrapStyleWord(true);
        message.setLineWrap(true);
        message.setEditable(false);
        String m=InboxData.ListForInbox.get(i).getMessage();
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
