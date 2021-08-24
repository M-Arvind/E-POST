package main;

import Admin.*;
import javax.swing.*;
import java.awt.*;
import Login.*;
import customer.*;

public class main extends JFrame {
    static JPanel mainPanel;
    static CardLayout card;
    main() {
        card = new CardLayout();
        mainPanel = new JPanel(card);
        mainPanel.setBackground(new Color(34, 34, 45));
        mainPanel.setPreferredSize(new Dimension(1350, 890));
        
        login login = new login();
        register register = new register();
        CustomerPanel customerPanel = new CustomerPanel();
        Profile_View profileView = new Profile_View();
        Profile_Update profileUpdate = new Profile_Update();
        
        mainPanel.add(login, "login");
        mainPanel.add(register, "register");
        mainPanel.add(customerPanel, "customerPanel");
        mainPanel.add(profileView, "Profile");
        mainPanel.add(profileUpdate, "Profile update");
        
        card.first(mainPanel);
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
