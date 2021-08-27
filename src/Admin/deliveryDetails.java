
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
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import main.main;

public class deliveryDetails extends JPanel implements ListSelectionListener {
    private JScrollPane tableScroll;
    public static JTable deliveryDetailsTable;
    public static DefaultTableModel deliveryModel;
    
    public deliveryDetails() {
        
      
        String[] columns = {"Delivery ID", "First Name","Last Name", "DOB", "Join Date" ,"Contact Number", "Gender", "Salary"};
        deliveryModel = new DefaultTableModel();
        deliveryModel.setColumnIdentifiers(columns);
        deliveryDetailsTable = new JTable(deliveryModel);
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
        int selectRow = deliveryDetailsTable.getSelectedRow();
            if(selectRow != -1){
            String selectedData = (String) deliveryDetailsTable.getValueAt(selectRow, 0);
            profile.DeliveryProfile.setDeliveryProfile(selectedData);
            main.switchPage("AdminDeliveryprofile");
            System.out.println("Selected: " + selectedData);
            deliveryDetailsTable.clearSelection();
            }

      }

    }
