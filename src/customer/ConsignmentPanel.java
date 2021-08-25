package customer;
import Database.*;
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
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

class ConsignmentPanel extends JPanel implements ActionListener{
    JPanel PConTable;
    JTable table;
    JScrollPane scroll;
    public ConsignmentPanel() {

        this.setLayout(null);
        this.setBackground(Color.white);
        Object[][] rows =DatabaseOperations.getCustomerConsignmentDetails();
     
        
        String[] columns = {"Consignment ID", "From","To", "Item", "Delivery ID", "Payment Method", "Date", "Status"};
        
        Border border = new LineBorder(new Color(71, 63, 145), 1, true);
        
        
        table =new JTable(rows, columns){
          @Override
         public boolean editCellAt(int row, int column, java.util.EventObject e) {
            return false;
         }
        };
    
        table.setRowHeight(30);
        table.setBorder(border);
        table.setRowSelectionAllowed(true);
 
        ListSelectionModel select = table.getSelectionModel();
        select.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        select.addListSelectionListener(new ListSelectionListener() {
       public void valueChanged(ListSelectionEvent e) {
       
        
        //int[] selectedRow = table.getSelectedRows();
        int selectedRow=table.getSelectedRow();
        //selectedData = (String) table.getValueAt(selectedRow[0], 0);
        System.out.println(selectedRow);
        ConsignmentDetails ob=(ConsignmentDetails)CustomerPanel.PConsignmentDetails;
        ob.setConignmentDetails(new Integer(selectedRow));
        CustomerPanel.customerCard.show(CustomerPanel.contentForCustomer,"ConsignmentDetails");
     
      }

    });
    
        
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
