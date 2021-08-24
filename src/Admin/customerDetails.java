
package Admin;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.table.JTableHeader;

public class customerDetails extends JPanel {
    private JScrollPane tableScroll;
    private JTable customerDetailsTable;
    public customerDetails() {
        
        Object[][] rows = {{"12345", "Keshav", "Arvind", "E Post", "12345", "E PAY", "29.09.2001", "Order Placed"}, {"2345", "Keshav", "Arvind", "E Post", "12345", "E PAY", "29.09.2001", "Order Placed"}};
        String[] columns = {"Consignment ID", "From","To", "Item", "Delivery ID", "Payment Method", "Date", "Status"};
        
        customerDetailsTable = new JTable(rows, columns);
        Border border = new LineBorder(new Color(71, 63, 145), 1, true);
        
        customerDetailsTable.setRowHeight(30);
        customerDetailsTable.setBorder(border);
        customerDetailsTable.setRowSelectionAllowed(true);
        
        JTableHeader tableHeader = customerDetailsTable.getTableHeader();
        tableHeader.setBackground(new Color(71, 63, 145));
        tableHeader.setForeground(Color.WHITE);
        
        tableScroll = new JScrollPane(customerDetailsTable);
        tableScroll.setBounds(25, 30, 1200, 500);
        tableScroll.setVisible(true);
        
        this.add(tableScroll);
        this.setBounds(45, 250, 1250, 590);
        this.setLayout(null);
        this.setVisible(true);
    }
}
