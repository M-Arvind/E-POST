package customer;
import javax.swing.JPanel;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;
import main.main;
public class WalletPanel extends JPanel 
{
	private JLabel icon;	
	private JButton bE_pay,bMoney_Order,bAdd_Money;	
	private JLabel UserName,Account_no,WalletBalance;	
	private JTable table;
	private JScrollPane sp;	
	private Color panel = new Color(254,254,254);
	private Color back = new Color(34,34,44);
	private Color button = new Color(71,63,144);	
	private int font = 16;
	private Font text = new Font("Verdana", Font.BOLD, font);
	private int y = 120;	
	private String column_name[] = {"ID","Type","Date","Beneficiary","Receivers Id","Amount","Balance"};
	private Object row[][] = {};
	
	WalletPanel()
	{
		
		
		this.setLayout(null);
		this.setBounds(55,150,1260,570);
		this.setBackground(panel);
		
		table = new JTable(row,column_name);
		JTableHeader tableHeader = table.getTableHeader();
		tableHeader.setBackground(button);
		tableHeader.setForeground(Color.white);
		tableHeader.setFont(text);
		
		table.setBackground(button);
		sp = new JScrollPane(table);
		sp.setBounds(160,150,950,300);	
		sp.setBackground(back);
		sp.setFont(new Font("arial", Font.BOLD	,20));
		sp.setVisible(true);
			
		
		
		bMoney_Order = new JButton("Money Order");
    	bAdd_Money = new JButton("Add Money");    	
    	UserName = new JLabel("Username   : ABHI@2001 ");    	
    	Account_no = new JLabel("Account no : 1000125690");    	
    	WalletBalance = new JLabel("Rs.35,000");      	
    	bE_pay = new JButton("E-Pay");
    	bMoney_Order = new JButton("Money Order");
    	bAdd_Money = new JButton("Add Money");      	
    	UserName.setBounds(100,30,500,50);
    	UserName.setFont(new Font("arial", Font.PLAIN,font));
    	
    	Account_no.setBounds(100,60,500,50);
    	Account_no.setFont(new Font("arial", Font.PLAIN,font));   	
    	    
    	
    	WalletBalance.setBounds(980,10,200,100);
    	WalletBalance.setFont(new Font("arial", Font.BOLD,18));	
    	
    	bE_pay.setBounds(350,520,150,30);	    	
		bE_pay.setBackground(button);
		bE_pay.setForeground(Color.white);
		bE_pay.setFont(new Font("arial", Font.BOLD,font));
                bE_pay.addActionListener((l)->{
                new EPay();
                });
                    
                
    	
    	bMoney_Order.setBounds(550,520,150,30);	    	
		bMoney_Order.setBackground(button);
		bMoney_Order.setForeground(Color.white);
                bMoney_Order.addActionListener((l)->{//outer Panel switching
                    main.switchPage("money order");
                });
                
		bMoney_Order.setFont(new Font("arial", Font.BOLD,font));	
		
		
		
		bAdd_Money.setBounds(750,520,150,30);	    	
		bAdd_Money.setBackground(button);
		bAdd_Money.setForeground(Color.white);
                bAdd_Money.addActionListener((l)->{
                new AddMoney();
                });
		bAdd_Money.setFont(new Font("arial", Font.BOLD,font));
    	
    	
    	ImageIcon ion = new ImageIcon(getClass().getResource("/Images/wallet.png"));   	
    	icon = new JLabel(ion);    
    	icon.setBounds(1010,0,200,100);	    	
    	icon.setVisible(true);
    	this.add(Account_no);
    	this.add(UserName);     	
    	this.add(WalletBalance);
    	this.add(icon);
    	this.add(bMoney_Order);
    	this.add(bE_pay);
    	this.add(bAdd_Money);
    	this.add(sp);
    	
    	
    	
    	
	}

}