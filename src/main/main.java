package main;

import Admin.*;
import javax.swing.*;
import java.awt.*;
import Login.*;



public class main extends JFrame {
    static JPanel mainPanel;
    static CardLayout card;
    main() {
        mainPanel = new JPanel(null);
        mainPanel.setBackground(new Color(34, 34, 45));
        mainPanel.setPreferredSize(new Dimension(1350, 890));
        
        JPanel customerDetailsPanel = new deliveryDetails();
        
        mainPanel.add(customerDetailsPanel);
        this.add(mainPanel);
        this.pack();
        this.setVisible(true);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    static public void switchPage(String pageName){
        card.show(mainPanel, pageName);
    }
    
    public static void main(String[] args) {
        new main();
    }
}
