
package Admin;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.JTableHeader;
import main.main;

public class customerDetails extends JPanel implements ListSelectionListener {
    private JScrollPane tableScroll;
    private JTable customerDetailsTable;
    public customerDetails() {
        
        Object[][] rows = {{"12345", "Keshav", "Arvind", "E Post", "12345", "E PAY", "29.09.2001", "Order Placed"}, {"2345", "Keshav", "Arvind", "E Post", "12345", "E PAY", "29.09.2001", "Order Placed"}};
        String[] columns = {"Customer ID", "First Name","Last Name", "DOB", "Age" ,"Contact Number", "Gender", "Bank Balance"};
        
        customerDetailsTable = new JTable(rows, columns);
        Border border = new LineBorder(new Color(71, 63, 145), 1, true);
        
        customerDetailsTable.setRowHeight(30);
        customerDetailsTable.setBorder(border);
        customerDetailsTable.setRowSelectionAllowed(true);
        
        JTableHeader tableHeader = customerDetailsTable.getTableHeader();
        tableHeader.setBackground(new Color(71, 63, 145));
        tableHeader.setForeground(Color.WHITE);
        
        ListSelectionModel customerDetailSelect = customerDetailsTable.getSelectionModel();
        customerDetailSelect.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        customerDetailSelect.addListSelectionListener(this);
        
        tableScroll = new JScrollPane(customerDetailsTable);
        tableScroll.setBounds(30, 30, 1200, 500);
        tableScroll.setVisible(true);
        
        this.add(tableScroll);
        this.setBackground(Color.WHITE);
        this.setBounds(45, 250, 1250, 590);
        this.setLayout(null);
        this.setVisible(true);
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
            int SelectedRow = customerDetailsTable.getSelectedRow();
            System.out.println(customerDetailsTable.getValueAt(SelectedRow, 1));
            main.switchPage("AdminProfileView");
    }
}
