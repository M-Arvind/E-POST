package Admin;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

public class OnGoingConsignment extends JPanel implements ActionListener{
    JPanel PConTable;
    public static JTable table;
    JScrollPane scroll;
    public static String selectedData;
    public static DefaultTableModel model;
    private ListSelectionModel select;
    public static String[] columns = {"Consignment ID", "From","To", "Item", "Delivery ID", "Payment Method", "Date", "Status"};
    OnGoingConsignment() {

        this.setLayout(null);
        this.setBackground(Color.white);
        
        
        Border border = new LineBorder(new Color(71, 63, 145), 1, true);
        
        model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);
        table =new JTable(model);

    
        table.setRowHeight(30);
        table.setBorder(border);
        table.setSelectionBackground(new Color(255, 255, 200));

 
        select = table.getSelectionModel();
        select.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        select.addListSelectionListener(new ListSelectionListener() {
        public void valueChanged(ListSelectionEvent e) {
            int selectRow = table.getSelectedRow();
            if(selectRow != -1){
            selectedData = (String) table.getValueAt(selectRow, 0);
            Consignment.consignment.setConsignmentDetails(selectedData);
            AdminPanel.card = "OnGoingConsignment";
            AdminPanel.adminCard.show(AdminPanel.contentForAdmin,"ConsignmentDetails");
            System.out.println("Selected: " + selectedData);
            table.clearSelection();
            }

      }

    });
        
       /* TableColumn testColumn = table.getColumnModel().getColumn(7);
        JComboBox<String> comboBox = new JComboBox<>();
        comboBox.addItem("Picked Up");
        comboBox.addItem("In Transit");
        comboBox.addItem("Delivered");

        testColumn.setCellEditor(new DefaultCellEditor(comboBox));*/
        
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
    
}

