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
        AdminPanel adminPanel = new AdminPanel();
        Profile_View profileView = new Profile_View();
        Profile_Update profileUpdate = new Profile_Update();
        AdminProfileView adminProfileVi = new AdminProfileView();
        AdminProfileUpdate adminprofileUp = new AdminProfileUpdate();
        PaymentEPost paymentEPost=new PaymentEPost();
        PaymentParcel paymentParcel=new PaymentParcel();
        MoneyOrder moneyOrder=new MoneyOrder();
        mainPanel.add(login, "login");
        mainPanel.add(register, "register");
        mainPanel.add(customerPanel, "customerPanel");
        mainPanel.add(adminPanel, "AdminPanel");
        mainPanel.add(profileView, "Profile");
        mainPanel.add(profileUpdate, "Profile update");
        mainPanel.add(adminProfileVi, "AdminProfileView");
        mainPanel.add(adminprofileUp, "AdminProfileUpdate");
        mainPanel.add(paymentEPost,"paymentEPost");
        mainPanel.add(paymentParcel,"paymentParcel");
        //me
        mainPanel.add(moneyOrder,"money order");
        //me
        card.first(mainPanel);
        JScrollPane scroll=new JScrollPane(mainPanel,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setBounds(0,0,2000, 1000);
        this.add(scroll);
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
