package Admin;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Image;
import javax.swing.JScrollPane;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.ScrollPaneConstants;
import static javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER;


public class Stocks extends JPanel implements ActionListener{
    
    JButton revenueStamp, postageStamp, postageStamp1, collectorStamp, inlandLetter, postCard, envelope;
    JLabel revenueStampName, postageStampName, postageStamp1Name, collectorStampName, inlandLetterName, postCardName, envelopeName;
    JLabel revenueStampPrice, postageStampPrice, postageStamp1Price, collectorStampPrice, inlandLetterPrice, postCardPrice, envelopePrice;
    JLabel revenueStampQuantity, postageStampQuantity, postageStamp1Quantity, collectorStampQuantity, inlandLetterQuantity, postCardQuantity, envelopeQuantity;
    ImageIcon revenueStampImage, postageStampImage, postageStamp1Image, collectorStampImage, inlandLetterImage, postCardImage, envelopeImage;
    Image image,newimg;
    public Stocks() {
        Color bg = new Color(34, 34, 45);
        Color fg = new Color(254, 254, 254);
        Border border = new LineBorder(new Color(71, 63, 145), 5, true);
        
        
        JPanel prod = new JPanel(null);
        prod.setBackground(fg);
        prod.setPreferredSize(new Dimension(1260, 780));
        
        revenueStampImage = new ImageIcon(getClass().getResource("/Images/REVENUE STAMP.jpg"));
        image = revenueStampImage.getImage(); // transform it 
        newimg = image.getScaledInstance(200, 200,  java.awt.Image.SCALE_SMOOTH);
        revenueStampImage = new ImageIcon(newimg);
        
        revenueStamp = new JButton(revenueStampImage);
        revenueStamp.setBorder(border);
        revenueStamp.setBounds(50, 50, 180, 180);
        revenueStamp.addActionListener(this);
        
        revenueStampName = new JLabel("Item Name  : Revenue Stamp");
        revenueStampName.setBounds(50, 250, 240, 40);
        revenueStampPrice = new JLabel("Item Price : Rs.5");
        revenueStampPrice.setBounds(50, 290, 240, 40);
        revenueStampQuantity = new JLabel("Item Quantity : 10");
        revenueStampQuantity.setBounds(50, 330, 240, 40);
        
        prod.add(revenueStamp);
        prod.add(revenueStampName);
        prod.add(revenueStampPrice);
        prod.add(revenueStampQuantity);
        
        
        postageStampImage = new ImageIcon(getClass().getResource("/Images/M.S. SUBULAKSHMI STAMP.jpg"));
        image = postageStampImage.getImage();
        newimg = image.getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH);
        postageStampImage = new ImageIcon(newimg);
        
        postageStamp = new JButton(postageStampImage);
        postageStamp.setBorder(border);
        postageStamp.setBounds(350, 50, 180, 180);
        postageStamp.addActionListener(this);
        
        postageStampName = new JLabel("Item Name  : Postage Stamp");
        postageStampName.setBounds(350, 250, 240, 40);
        postageStampPrice = new JLabel("Item Price : Rs.5");
        postageStampPrice.setBounds(350, 290, 240, 40);
        postageStampQuantity = new JLabel("Item Quantity : 10");
        postageStampQuantity.setBounds(350, 330, 240, 40);
        
        prod.add(postageStamp);
        prod.add(postageStampName);
        prod.add(postageStampPrice);
        prod.add(postageStampQuantity);
        
        
        postageStamp1Image = new ImageIcon(getClass().getResource("/Images/BAL GANGADHAR TILAK STAMP.jpg"));
        image = postageStamp1Image.getImage();
        newimg = image.getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH);
        postageStamp1Image = new ImageIcon(newimg);
        
        postageStamp1 = new JButton(postageStamp1Image);
        postageStamp1.setBorder(border);
        postageStamp1.setBounds(650, 50, 180, 180);
        postageStamp1.addActionListener(this);
        
        postageStamp1Name = new JLabel("Item Name  : Postage Stamp");
        postageStamp1Name.setBounds(650, 250, 240, 40);
        postageStamp1Price = new JLabel("Item Price : Rs.5");
        postageStamp1Price.setBounds(650, 290, 240, 40);
        postageStamp1Quantity = new JLabel("Item Quantity : 10");
        postageStamp1Quantity.setBounds(650, 330, 240, 40);
        
        prod.add(postageStamp1);
        prod.add(postageStamp1Name);
        prod.add(postageStamp1Price);
        prod.add(postageStamp1Quantity);
        
        
        collectorStampImage = new ImageIcon(getClass().getResource("/Images/GURU NANAK DEV STAMP.jpg"));
        image = collectorStampImage.getImage();
        newimg = image.getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH);
        collectorStampImage = new ImageIcon(newimg);
        
        collectorStamp = new JButton(collectorStampImage);
        collectorStamp.setBorder(border);
        collectorStamp.setBounds(950, 50, 180, 180);
        collectorStamp.addActionListener(this);
        
        collectorStampName = new JLabel("Item Name  : Collector Stamp");
        collectorStampName.setBounds(950, 250, 240, 40);
        collectorStampPrice = new JLabel("Item Price : Rs.5");
        collectorStampPrice.setBounds(950, 290, 240, 40);
        collectorStampQuantity = new JLabel("Item Quantity : 10");
        collectorStampQuantity.setBounds(950, 330, 240, 40);
        
        prod.add(collectorStamp);
        prod.add(collectorStampName);
        prod.add(collectorStampPrice);
        prod.add(collectorStampQuantity);
        
        
        inlandLetterImage = new ImageIcon(getClass().getResource("/Images/INLAND LETTER CARD.jpg"));
        image = inlandLetterImage.getImage();
        newimg = image.getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH);
        inlandLetterImage = new ImageIcon(newimg);
        
        inlandLetter = new JButton(inlandLetterImage);
        inlandLetter.setBorder(border);
        inlandLetter.setBounds(50, 400, 180, 180);
        inlandLetter.addActionListener(this);
        
        inlandLetterName = new JLabel("Item Name  : Inland Letter");
        inlandLetterName.setBounds(50, 600, 240, 40);
        inlandLetterPrice = new JLabel("Item Price : Rs.5");
        inlandLetterPrice.setBounds(50, 640, 240, 40);
        inlandLetterQuantity = new JLabel("Item Quantity : 10");
        inlandLetterQuantity.setBounds(50, 680, 240, 40);
        
        prod.add(inlandLetter);
        prod.add(inlandLetterName);
        prod.add(inlandLetterPrice);
        prod.add(inlandLetterQuantity);
        
        
        envelopeImage = new ImageIcon(getClass().getResource("/Images/ENVELOPE.jpg"));
        image = envelopeImage.getImage();
        newimg = image.getScaledInstance(300, 100, java.awt.Image.SCALE_SMOOTH);
        envelopeImage = new ImageIcon(newimg);
        
        envelope = new JButton(envelopeImage);
        envelope.setBorder(border);
        envelope.setBounds(350, 400, 180, 180);
        envelope.addActionListener(this);
        envelope.setBackground(fg);
        
        envelopeName = new JLabel("Item Name  : Envelope");
        envelopeName.setBounds(350, 600, 240, 40);
        envelopePrice = new JLabel("Item Price : Rs.5");
        envelopePrice.setBounds(350, 640, 240, 40);
        envelopeQuantity = new JLabel("Item Quantity : 10");
        envelopeQuantity.setBounds(350, 680, 240, 40);
        
        prod.add(envelope);
        prod.add(envelopeName);
        prod.add(envelopePrice);
        prod.add(envelopeQuantity);
        
        
        postCardImage = new ImageIcon(getClass().getResource("/Images/POST CARD.jpg"));
        image = postCardImage.getImage();
        newimg = image.getScaledInstance(300, 100, java.awt.Image.SCALE_SMOOTH);
        postCardImage = new ImageIcon(newimg);
        
        postCard = new JButton(postCardImage);
        postCard.setBorder(border);
        postCard.setBounds(650, 400, 180, 180);
        postCard.addActionListener(this);
        postCard.setBackground(fg);
        
        postCardName = new JLabel("Item Name  : Postal Card");
        postCardName.setBounds(650, 600, 240, 40);
        postCardPrice = new JLabel("Item Price : Rs.5");
        postCardPrice.setBounds(650, 640, 240, 40);
        postCardQuantity = new JLabel("Item Quantity : 10");
        postCardQuantity.setBounds(650, 680, 240, 40);
        
        prod.add(postCard);
        prod.add(postCardName);
        prod.add(postCardPrice);
        prod.add(postCardQuantity);
        
        
        JScrollPane scroll = new JScrollPane(prod);
        scroll.setPreferredSize(new Dimension(1260, 570));
        scroll.setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_NEVER);
        this.add(scroll);
        this.setBackground(fg);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object oe = e.getSource();
        if(oe == revenueStamp){
            System.out.print("Revenue Stamp");
        }
        
        else if(oe == postageStamp){
            System.out.print("Postage Stamp");
        }
        else if(oe == postageStamp1){
            
        }
    }
    
    
}

