
package Admin;

import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.JTableHeader;
import main.main;

public class deliveryDetails extends JPanel implements ListSelectionListener {
    private JScrollPane tableScroll;
    private JTable deliveryDetailsTable;
    public deliveryDetails() {
        
        Object[][] rows = {{"12345", "Keshav", "Arvind", "E Post", "12345", "E PAY", "29.09.2001", "Order Placed"}, {"2345", "Keshav", "Arvind", "E Post", "12345", "E PAY", "29.09.2001", "Order Placed"}};
        String[] columns = {"Customer ID", "First Name","Last Name", "DOB", "Join Date" ,"Contact Number", "Gender", "Salary"};
        
        deliveryDetailsTable = new JTable(rows, columns);
        Border border = new LineBorder(new Color(71, 63, 145), 1, true);
        
        deliveryDetailsTable.setRowHeight(30);
        deliveryDetailsTable.setBorder(border);
        deliveryDetailsTable.setRowSelectionAllowed(true);
        
        JTableHeader tableHeader = deliveryDetailsTable.getTableHeader();
        tableHeader.setBackground(new Color(71, 63, 145));
        tableHeader.setForeground(Color.WHITE);
        
        ListSelectionModel deliverySelect = deliveryDetailsTable.getSelectionModel();
        deliverySelect.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        deliverySelect.addListSelectionListener(this);
        
        tableScroll = new JScrollPane(deliveryDetailsTable);
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
        int selectedRow = deliveryDetailsTable.getSelectedRow();
        System.out.println(deliveryDetailsTable.getValueAt(selectedRow, 1));
        main.switchPage("AdminProfileView");
    }
}
