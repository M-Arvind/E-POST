package Delivery;

import Database.DatabaseOperations;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.JTableHeader;

public class ongoing extends JPanel 
{
    String delivery_ID = "Barath.B";
    private String column_name[] = {"Con-ID","From","To","Item","Delivery Id","Payment ","Date","Status"};
    Object row[][] = DatabaseOperations.getCustomerConsignmentDetails();
    
    private JTable table;
    private JScrollPane sp;
    private Color panel = new Color(240,238,240);
    private Color back = new Color(34,34,44);
    private Color button = new Color(71,63,144);
    private int font = 16;
    private int font1 = 16;
    private Font text = new Font("Verdana", Font.BOLD, font);
     private Font text1 = new Font("Verdana", Font.PLAIN, font1);
    ongoing()
    {
        this.setLayout(null);
	this.setBounds(55,150,1260,570);
	//this.setBackground(panel);
        
        table = new JTable(row,column_name);
        JTableHeader tableHeader = table.getTableHeader();
	tableHeader.setBackground(button);
	tableHeader.setForeground(Color.white);
	tableHeader.setFont(text1);
        
	table.setFont(text);
	table.setRowHeight(30);	       
        table.setBackground(Color.white);
	table.setForeground(back);       
        
        sp = new JScrollPane(table);
	sp.setBounds(30,30,1200,500);	
        sp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	sp.setBackground(button);
        sp.setForeground(Color.black);
	sp.setFont(new Font("arial", Font.BOLD	,20));
	sp.setVisible(true);
        //this.setBackground(panel);
        add(sp);
        setVisible(true);
        this.setBackground(panel);
    }
    
}
