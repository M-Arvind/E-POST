package Admin;

import Database.DatabaseOperations;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
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
import javax.swing.table.TableColumn;
import profile.DeliveryProfile;

public class NewConsignment extends JPanel implements ActionListener,ItemListener{
    JPanel PConTable;
    public static JTable table;
    JScrollPane scroll;
    public static DefaultTableModel newModel;
    private int font = 16;
    private int font1 = 16;
    private Font text = new Font("Verdana", Font.BOLD, font);
    private Font text1 = new Font("arial", Font.BOLD, font1);
    int Select;
    JComboBox<String> comboBox;
    String value;
    NewConsignment() {

        this.setLayout(null);
        this.setBackground(Color.white);
        Object[][] rows = {{"12345", "Keshav", "Arvind", "E Post", "    ", "E PAY", "29.09.2001", "Order Placed"}, {"2345", "Keshav", "Arvind", "E Post", "   ", "E PAY", "29.09.2001", "Order Placed"}};
        String[] columns = {"Consignment ID", "From","To", "Item", "Delivery ID", "Payment Method", "Date", "Status"};
        
        Border border = new LineBorder(new Color(71, 63, 145), 1, true);
        
        newModel = new DefaultTableModel();
        newModel.setColumnIdentifiers(columns);
        table =new JTable(newModel);
    
        table.setRowHeight(30);
        table.setBorder(border);
        table.setRowSelectionAllowed(true);
 
        ListSelectionModel select = table.getSelectionModel();
        select.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        select.addListSelectionListener(new ListSelectionListener() 
        {
            public void valueChanged(ListSelectionEvent e) 
            {
                Select=table.getSelectedRow();
            }
        });    
        
        TableColumn testColumn = table.getColumnModel().getColumn(4);
        comboBox = new JComboBox<>(NewConsignment.getDeliveryMembers());
        comboBox.addItemListener(this);
        comboBox.setFont(text1);
        testColumn.setCellEditor(new DefaultCellEditor(comboBox));
        
        JTableHeader tab = table.getTableHeader();
        JTableHeader tableHeader = table.getTableHeader();
        tab.setBackground(new Color(71, 63, 145));
        tab.setForeground(Color.white);

        
        scroll = new JScrollPane(table);
        
        scroll.setBounds(30, 30, 1200, 500);
        scroll.setVisible(true);
        this.add(scroll);
    }


    
    @Override
    public void actionPerformed(ActionEvent e) {
    }
    public static String[] getDeliveryMembers(){
        ArrayList<DeliveryProfile> details = Database.DatabaseOperations.getDeliveryDetails();
        String[] delivery = new String[details.size()];
        for(int i=0;i<details.size();i++){
            DeliveryProfile temp = details.get(i);
            if(!temp.getId().equals("Keshav B"))
                delivery[i] = temp.getId();
        }
        return delivery;        
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
//if(e.getStateChange()== 2)
//        {
               
            if(Select != -1)
            {
                int column = 0;
                String newStatus = comboBox.getSelectedItem().toString();
                //Selected_row = table.getSelectedRow(); 
//                System.out.println(Select);
                value = table.getModel().getValueAt(Select, column).toString();
//                System.out.println(value);
//                System.out.println(newStatus);   
                DatabaseOperations.updateConsignmentDelivery(newStatus,value); 
                Consignment.consignment.setNewdAdminConsignmentDetails();
                //model.removeRow(Selected_row);
                //model.setRowCount(model.getRowCount()-1);
                //System.out.println(model.getRowCount());
//            }
            
            }           
            }
    
}

