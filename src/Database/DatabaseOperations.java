package Database;
import customer.Authentication;

import java.awt.List;
import java.awt.TextField;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import login.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import customer.DatasForCustomer.*;
import customer.WalletAuthentication;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.sql.Date;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import warehouse.*;
import profile.*;

public class DatabaseOperations 
{
   private static Connection connection;

   public static Connection getConnection() 
   {
        
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","E-Post","123");
        }
  
        
        catch(Exception ex)
        {
            System.out.println("  "+ex);
        }
        return connection;
    }  
    public static Object[][] getCustomerConsignmentDetails(){
       try {
           Connection con=DatabaseOperations.getConnection();
           String Customer_ID="Kishore P";
           String query="select *from Consignment where customer_ID='"+Customer_ID+"'";
           PreparedStatement  st1=con.prepareStatement(query);
           ResultSet res=st1.executeQuery(query);
           
           while(res.next()){
              ConsignmentData ob=new ConsignmentData();
            
              ob.setConsignment_ID(res.getString("consignment_ID"));
              ob.setCustomer_ID(res.getString("customer_ID"));
              ob.setDelivery_ID(res.getString("delivery_ID"));
              ob.setReceiver_ID(res.getString("receiver_ID"));
              ob.setItem_code(res.getString("item_code"));
              ob.setItem(res.getString("item"));
              ob.setItem_price(res.getFloat("item_price"));
              ob.setItem_weight(res.getFloat("item_weight"));
              ob.setReceiver_first_name(res.getString("receiver_first_name"));
              ob.setReceiver_last_name(res.getString("receiver_last_name"));
              ob.setReceiver_address(res.getString("receiver_address"));
              ob.setReceiver_contact_number(res.getLong("receiver_contact_number"));
              ob.setCustomer_first_name(res.getString("customer_first_name"));
              ob.setCustomer_last_name(res.getString("customer_last_name"));
              ob.setCustomer_contact_number(res.getLong("customer_contact_number"));
              ob.setShipping_address(res.getString("shipping_address"));
              ob.setPayment_method(res.getString("payment_method"));
              ob.setOrder_date(res.getDate("order_date"));
              ob.setDelivery_date(res.getDate("delivery_date"));
              ob.setStatus(res.getString("status"));

              ConsignmentData.listForConsignment.add(ob); 
             
              
           }
           System.out.println("Success in Consignment--->"+ConsignmentData.listForConsignment.size());
       } catch (Exception ex) {
           System.out.println("Error in getCustomerConsignmentDetails---->"+ex.toString());
       }
       Object[][] row=new Object[ConsignmentData.listForConsignment.size()][8];
       int i=0;
       for(ConsignmentData Data:ConsignmentData.listForConsignment){
           row[i][0]=Data.getConsignment_ID();
           row[i][1]=Data.getCustomer_first_name();
           row[i][2]=Data.getReceiver_first_name();
           row[i][3]=Data.getItem();
           row[i][4]=Data.getDelivery_ID();
           row[i][5]=Data.getPayment_method();
           row[i][6]=Data.getOrder_date();
           row[i][7]=Data.getStatus();
          
          
         i++;
             
       }
       return row;
    }
    
    
    
    
    public static boolean CheckIdPresentOrNot(String UserId){
        try{
        Connection con=DatabaseOperations.getConnection();
        Statement st=con.createStatement();
        String query="select * from customer where customer_ID='"+UserId+"'";
        ResultSet rs=st.executeQuery(query);
        
        if(rs.next()){
            //new WalletAuthentication();
            return true;
            
        }
        /**
        else{
            
            JOptionPane.showMessageDialog(null,"Invalid userId");
        }
        * */
        }catch(SQLException ex){
            
            System.out.println("Error in checkIdPresentOrNot Function (DatabaseOperations)---->"+ex.toString());
            
        }
        return false;
        
        
        
    }
    
    public static void WalletUpdatationOnMoneyOrder(){
        
        try{
        String senderid="",recieverid="",recieverName="",balanceS="",balanceR="";
        Connection con=DatabaseOperations.getConnection();
        String saccountnoquery="select account_number from Customer where customer_id='Kishore P'";
        PreparedStatement  stSAccNo=con.prepareStatement(saccountnoquery);
        ResultSet rs1=stSAccNo.executeQuery(saccountnoquery);
        if(rs1.next()){
            senderid=rs1.getString(1);
        }
        
        String raccountnoquery="select account_number from Customer where customer_id='"+WalletData.MoneyOrderValues.get(0)+"'";
        PreparedStatement  stRAccNo=con.prepareStatement(raccountnoquery);
        ResultSet rs2=stRAccNo.executeQuery(raccountnoquery);
        if(rs2.next()){
            recieverid=rs2.getString(1);
        }
        
        String rnamequery="select first_name from Customer where customer_id='"+WalletData.MoneyOrderValues.get(0)+"'";
        PreparedStatement  rnamest=con.prepareStatement(rnamequery);
        ResultSet rs3=rnamest.executeQuery(rnamequery);
        if(rs3.next()){
            recieverName=rs3.getString(1);
        }
        
        String bsquery="select bank_balance from Customer where customer_id='Kishore P'";
        PreparedStatement  stsbal=con.prepareStatement(bsquery);
        ResultSet rs4=stsbal.executeQuery(bsquery);
        if(rs4.next()){
            balanceS=rs4.getString(1);
        }
        
        String brquery="select bank_balance from Customer where customer_id='"+WalletData.MoneyOrderValues.get(0)+"'";
        PreparedStatement  strbal=con.prepareStatement(brquery);
        ResultSet rs5=strbal.executeQuery(brquery);
        if(rs5.next()){
            balanceR=rs5.getString(1);
        }
        
        
        String q="insert into wallet values(?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement  st=con.prepareStatement(q);
        
        st.setString(1,getTransactionIdGenerator());
        st.setString(2,"Kishore P");
        st.setString(3,WalletData.MoneyOrderValues.get(0));
        st.setString(4,WalletData.MoneyOrderValues.get(2));
        st.setString(5,WalletData.MoneyOrderValues.get(3));
        st.setString(6,WalletData.MoneyOrderValues.get(4) );
        st.setDate(7,java.sql.Date.valueOf(java.time.LocalDate.now()));
        st.setString(8,senderid);
        st.setString(9, recieverid);
        st.setString(10,WalletData.MoneyOrderValues.get(1));
        st.setString(11,recieverName);
        st.setString(12,Integer.toString(Integer.parseInt(balanceS)-Integer.parseInt(WalletData.MoneyOrderValues.get(1))));
        st.executeUpdate();
        
        String q1="update customer  set BANK_BALANCE='"+Integer.toString(Integer.parseInt(balanceS)-Integer.parseInt(WalletData.MoneyOrderValues.get(1)))+"' where customer_id='Kishore P'";
        PreparedStatement stq1=con.prepareStatement(q1);
        stq1.executeQuery();
        
        String q2="update customer set BANK_BALANCE='"+Integer.toString(Integer.parseInt(balanceR)+Integer.parseInt(WalletData.MoneyOrderValues.get(1)))+"' where customer_id='"+WalletData.MoneyOrderValues.get(0)+"'";
        PreparedStatement stq2=con.prepareStatement(q2);
        stq2.executeQuery();
        
        con.setAutoCommit(true);
        con.close(); 
        
        }catch(Exception e){
            System.out.println("Error in WalletUpdatationOnMoneyOrder() in DatabaseOperations------->"+e.toString());
        }
    }
    
    public static ArrayList getOngoingDeliveryConsignmentDetils(String delivery_id)
    {
        ArrayList ongoing = new ArrayList();        
        try
        {
            Statement st = getConnection().createStatement();
            ResultSet rs =  st.executeQuery("select * from Consignment where delivery_ID ='"+delivery_id+"'");
            if(rs.next())
            {
                ongoing.add(rs.getString("consignment_id"));
                ongoing.add(rs.getString("customer_id"));
                ongoing.add(rs.getString("receiver_id"));
                ongoing.add(rs.getString("item"));
                ongoing.add(rs.getString("delivery_id"));        
                ongoing.add(rs.getString("payment_method"));                
                ongoing.add(rs.getString("order_date"));
                ongoing.add(rs.getString("status"));
                
                /*ongoing.add(rs.getString("consignment_id"));
                ongoing.add(rs.getString("consignment_id"));
                ongoing.add(rs.getString("consignment_id"));
                ongoing.add(rs.getString("consignment_id"));
                ongoing.add(rs.getString("consignment_id"));
                ongoing.add(rs.getString("consignment_id"));
                ongoing.add(rs.getString("consignment_id"));
                ongoing.add(rs.getString("consignment_id"));
                ongoing.add(rs.getString("consignment_id"));
                ongoing.add(rs.getString("consignment_id"));
                ongoing.add(rs.getString("consignment_id"));
                ongoing.add(rs.getString("consignment_id"));*/
                
                
            }
        }
        catch(Exception e)
        {
            
        }
        
        return ongoing;
    }
    
   public static String getConsignmentIdGenerator() {
       try{
          Connection con=DatabaseOperations.getConnection();
				Statement st=con.createStatement();
				String stsql="select count(*) from CONSIGNMENT";
				ResultSet rs=st.executeQuery(stsql);
				rs.next();
				int c=rs.getInt(1);
				con.setAutoCommit(true);
				
				String s="CONID";
                                System.out.println(s+Integer.toString(c+1));
				return s+Integer.toString(c+1); 
       }
       catch(Exception ex1){
            System.out.println("Error in getconsignmentIdGenerator---->"+ex1.toString());
       }
				
	return "";			
     }
   public static String getTransactionIdGenerator()  {
       try{
          Connection con=DatabaseOperations.getConnection();
		Statement st=con.createStatement();
		String stsql="select count(*) from WALLET";
		ResultSet rs=st.executeQuery(stsql);
		rs.next();
		int c=rs.getInt(1);
		con.setAutoCommit(true);
		String s="TRANSID";
		return s+Integer.toString(c+1); 
       }
       catch(Exception ex1){
            System.out.println("Error in getTransactionIdGenerator---->"+ex1.toString());
       }
       
      return "";
   }
   
   public static String getMessageIdGenerator() {
      try{
          Connection con=DatabaseOperations.getConnection();
		Statement st=con.createStatement();
		String stsql="select count(*) from INBOX";
		ResultSet rs=st.executeQuery(stsql);
		rs.next();
		int c=rs.getInt(1);
		con.setAutoCommit(true);
		String s="MSGID";
		return s+Integer.toString(c+1);
          
      }
      catch(Exception ex1){
            System.out.println("Error in getTransactionIdGenerator---->"+ex1.toString());
       }
	return "";	
  }
 
   
   //Database
    public static ArrayList getLoginCredentials(JTextField usernameTextField, JTextField passwordField)
    {
          ArrayList loginCredentials = new ArrayList();
          
          try
            {                
                String userName = usernameTextField.getText();
                String userPassword = passwordField.getText();                

                
                Statement st = getConnection().createStatement();
                ResultSet rs = st.executeQuery("select user_ID from Login where user_ID like '"+userName+"'");
                boolean next = rs.next();
                
                if(next)
                {
                    ResultSet rspass = st.executeQuery("select password,salt,login_type from Login where user_ID like '"+userName+"'");
                    if(rspass.next())
                    {         
                        String pass = rspass.getString("password");
                        String salt = rspass.getString("salt");
                        String type = rspass.getString("login_type");
                        
                        System.out.println(pass);
                        System.out.println(salt);
                        System.out.println(type);
                        //System.out.println(hash_pass);
                        
                        loginCredentials.add(pass);
                        loginCredentials.add(salt);
                        loginCredentials.add(type);
                        //loginCredentials.add(hash_pass);                          
                    }
                }                  
            }
            catch(Exception ex)
            {
                JOptionPane.showMessageDialog(null, ex.toString());
            }
          
          return loginCredentials;
    }
    
    public static void customerCreate(ArrayList list)
    {
        
        String userName = list.get(0).toString();
        
        try
        {                
            Statement st = getConnection().createStatement();
            ResultSet rs = st.executeQuery("select customer_ID  from Customer where customer_ID  like '"+userName+"'");
            boolean next = rs.next();   

            if(next)
            {
               JOptionPane.showMessageDialog(null, "You have Already Registered to E-Post"); 
            }
            else
            {
               String query="INSERT INTO Customer VALUES ('"+list.get(0).toString()+"','"+list.get(1).toString()+"','"+list.get(2).toString()+"','"+list.get(3).toString()+"','"+list.get(4).toString()+"','"+list.get(5).toString()+"',"
                       + "'"+list.get(6).toString()+"','"+list.get(7).toString()+"','"+list.get(8).toString()+"','"+list.get(9).toString()+"','"+list.get(10).toString()+"','"+list.get(11).toString()+"','"+list.get(12).toString()+"')";

               st.executeUpdate(query);
               getConnection().setAutoCommit(true);
               JOptionPane.showMessageDialog(null, "Registration Success!"); 
            }
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex.toString());
        }
    }
    
    public static void loginUpdate(String userName, String password, String confirmPassword, int salt)
    {
        try
        {                
            Statement st = getConnection().createStatement();
            ResultSet rs = st.executeQuery("select user_ID  from Login where user_ID like '"+userName+"'");
            boolean next = rs.next();
            
            if(next)
            {
                String query="UPDATE Login SET password = '"+password+"', salt = '"+salt+"' WHERE user_ID = '"+userName+"'";
                st.executeUpdate(query);
                getConnection().setAutoCommit(true);
                JOptionPane.showMessageDialog(null, "Successful");
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Account Does not Exist. Please Register");
            }
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex.toString());
        }
    }
    public static void updateInbox(){
        try{
            
            String query="INSERT INTO Inbox VALUES(?,?,?,?,?,?,?,?,?)";
            Connection con=DatabaseOperations.getConnection();
            PreparedStatement pst=con.prepareStatement(query);
            pst.setString(1,DatabaseOperations.getMessageIdGenerator());
            pst.setString(2,EPostData.getMessage());
            pst.setString(3,"Gowtham");//userName
            pst.setString(4, EPostData.getFirstName());
            pst.setDate(5,java.sql.Date.valueOf(java.time.LocalDate.now()));//new java.sql.Date(System.currentTimeMillis())
            pst.setTimestamp(6,Timestamp.valueOf(LocalDateTime.now()));//new java.sql.Timestamp(9000)
            pst.setString(7, "Kishore P");//Login.login.user_ID)
            pst.setString(8, EPostData.getTo());
            pst.setString(9,EPostData.getSubject());
            pst.executeUpdate();
            con.setAutoCommit(true);
            con.close();
            JOptionPane.showMessageDialog(null,"Inbox Updated Succesfully ID:"+DatabaseOperations.getMessageIdGenerator());
            
            
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"Inbox Updated Failed ID:"+e.toString());
        }
    }
    public static void updateConsignment(){
         try{ 
            String query="INSERT INTO Consignment VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            Connection con=DatabaseOperations.getConnection();
            PreparedStatement pst=con.prepareStatement(query);
            pst.setString(1,DatabaseOperations.getConsignmentIdGenerator());//consignment_ID
            pst.setString(2,"Kishore P");//customer_ID
            pst.setString(3, "");//delivery_ID
            pst.setString(4,EPostData.getTo());//receiver_ID
            pst.setString(5,"WH0001");//item_code
            pst.setString(6,"E-Post");//item
            pst.setString(7,"5");//item_price
            pst.setString(8,"");//item_weight
            pst.setString(9,EPostData.getFirstName());//receiver_first_name                                             
            pst.setString(10, EPostData.getLastName()); //receiver_last_name             
            pst.setString(11, EPostData.getAddress()); //receiver_address                                                      
            pst.setLong(12, EPostData.getPhoneNumber()); //receiver_contact_number                                                       
            pst.setString(13,"Kishore");      //customer_first_name 
            pst.setString(14, "P");           //customer_last_name 
            pst.setLong(15,9095305385L);   //customer_contact_number
            pst.setString(16, "No.24 Second street, Yelankahana New Town, Karanataka, Bangalore");//shipping_address
            pst.setString(17,"E-Pay");  //payment_method 
            pst.setDate(18,java.sql.Date.valueOf(java.time.LocalDate.now()));//order_date DATE
            pst.setDate(19,java.sql.Date.valueOf(java.time.LocalDate.now()));  //delivery_date DATE                                                    
            pst.setString(20,"In-Order");//status 
            pst.executeUpdate();
            con.setAutoCommit(true);
            con.close();
            JOptionPane.showMessageDialog(null,"Consignment Updated Succesfully ID:"+DatabaseOperations.getConsignmentIdGenerator());
    
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"Consignment Updated Failed ID:"+e.toString());
        }
    }
    public static void updateWalletTransaction(){
        try{ 
            String query="INSERT INTO Wallet VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
            Connection con=DatabaseOperations.getConnection();
            PreparedStatement pst=con.prepareStatement(query);
            pst.setString(1,DatabaseOperations.getTransactionIdGenerator());
            pst.setString(2,"Kishore P");//Customer ID
            pst.setString(3,"Admin001");//Reciver Id
            pst.setString(4, EPostData.getFirstName());
            pst.setString(5, EPostData.getLastName());
            pst.setString(6, WalletDataG.getTransationType());
            pst.setDate(7,java.sql.Date.valueOf(java.time.LocalDate.now()));//new java.sql.Date(System.currentTimeMillis())
            pst.setLong(8,350700001);//current logged in customer's wallet account number
            pst.setLong(9,350700000);//Admin Account Number
            pst.setFloat(10,WalletDataG.getAmount());//amount
            pst.setString(11,"Admin");
            pst.setFloat(12,WalletDataG.getBalence());//balence
            pst.executeUpdate();
            con.setAutoCommit(true);
            con.close();
            JOptionPane.showMessageDialog(null,"Wallet Updated Succesfully ID:"+DatabaseOperations.getMessageIdGenerator());
            
            
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"Wallet  Updated Failed ID:"+e.toString());
        }
    }
    public static ArrayList getStocks(){
        ArrayList<Warehouse> stocks = new ArrayList<Warehouse>();
        try{
        Statement st = getConnection().createStatement();
        String query = "SELECT * from warehouse";
        ResultSet rs = st.executeQuery(query);
        while(rs.next()){
            Warehouse temp = new Warehouse();
            temp.setItemCode(rs.getString("S_ITEM_CODE"));
            temp.setItem(rs.getString("S_ITEM"));
            temp.setItemPrice(rs.getString("S_ITEM_PRICE"));
            temp.setItemQuantity(rs.getString("S_ITEM_QUANTITY"));
            stocks.add(temp);
        }
        }
        catch(Exception e){
            System.out.print(e);
        }
        return stocks;
    }

    public static void updateStocks(ArrayList<Warehouse> stock){
        for(int i=0;i<stock.size();i++){
            Warehouse temp = stock.get(i);
            try{
                Connection con = getConnection();
                Statement st = con.createStatement();
                String query = "update warehouse set S_Item_Quantity = ? where s_item_Code = ?";
                PreparedStatement pst = con.prepareStatement(query);
                pst.setString(1, temp.getItemQuantity());
                pst.setString(2, temp.getitemCode());
                pst.executeQuery();
                con.setAutoCommit(true);
            }
            catch(Exception e){
                System.out.println(e);
            }

        }
        JOptionPane.showMessageDialog(null, "Updated Successfully");
    }

    public static AdminProfile getAdminProfile(String id){
        AdminProfile details = new AdminProfile();
        try{
            Connection con = getConnection();
            Statement st = con.createStatement();
            String query = "select * from Admin where Admin_id = ?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, id);
            ResultSet rst = pst.executeQuery();
            while(rst.next()){
                details.setId(rst.getString("ADMIN_ID"));
                details.setFirstName(rst.getString("FIRST_NAME"));
                details.setLastName(rst.getString("LAST_NAME"));
                details.setDob(rst.getDate("DOB"));
                details.setJoinDate(rst.getDate("JOIN_DATE"));
                details.setExperience(rst.getInt("EXPERIANCE"));
                details.setAge(rst.getInt("AGE"));
                details.setMartialStatus(rst.getString("MARTIAL_STATUS"));
                details.setContactNumber(rst.getString("CONTACT_NUMBER"));
                details.setGender(rst.getString("GENDER"));
                details.setPermanentAddress(rst.getString("PERMANENT_ADDRESS"));
                details.setTemporaryAddress(rst.getString("TEMPORARY_ADDRESS"));
                details.setSalary(rst.getInt("SALARY"));
                details.setState(rst.getString("STATE"));
                details.setDistrict(rst.getString("DISTRICT"));
                details.setDesignation(rst.getString("DESIGNATION"));
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        return details;
    }
    
    public static ArrayList<CustomerProfile> getCustomerDetails(){
        ArrayList<CustomerProfile> customerDetails = new ArrayList<CustomerProfile>();
        try{
            Connection con = getConnection();
            Statement st = con.createStatement();
            String query = "select * from Customer";
            PreparedStatement pst = con.prepareStatement(query);
            ResultSet rst = pst.executeQuery();
            while(rst.next()){
                CustomerProfile details = new CustomerProfile();
                details.setId(rst.getString("CUSTOMER_ID"));
                details.setFirstName(rst.getString("FIRST_NAME"));
                details.setLastName(rst.getString("LAST_NAME"));
                details.setDob(rst.getDate("DOB"));
                details.setAge(rst.getInt("AGE"));
                details.setContactNumber(rst.getString("CONTACT_NUMBER"));
                details.setGender(rst.getString("GENDER"));
                details.setAddress(rst.getString("ADDRESS"));
                details.setState(rst.getString("STATE"));
                details.setDistrict(rst.getString("DISTRICT"));
                details.setPinCode(rst.getString("PIN_CODE"));
                details.setBankBalance(rst.getString("BANK_BALANCE"));
                details.setAccountNumber(rst.getString("ACCOUNT_NUMBER"));
                customerDetails.add(details);
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        return customerDetails;
    }
    
    public static ArrayList<DeliveryProfile> getDeliveryDetails(){
        ArrayList<DeliveryProfile> deliveryDetails = new ArrayList<DeliveryProfile>();
        try{
            Connection con = getConnection();
            Statement st = con.createStatement();
            String query = "select * from Delivery";
            PreparedStatement pst = con.prepareStatement(query);
            ResultSet rst = pst.executeQuery();
            while(rst.next()){
                DeliveryProfile details = new DeliveryProfile();
                details.setId(rst.getString("DELIVERY_ID"));
                details.setFirstName(rst.getString("FIRST_NAME"));
                details.setLastName(rst.getString("LAST_NAME"));
                details.setDob(rst.getDate("DOB"));
                details.setJoinDate(rst.getDate("JOIN_DATE"));
                details.setAge(rst.getInt("AGE"));
                details.setMartialStatus(rst.getString("MARTIAL_STATUS"));
                details.setContactNumber(rst.getString("CONTACT_NUMBER"));
                details.setGender(rst.getString("GENDER"));
                details.setPermanentAddress(rst.getString("PERMANENT_ADDRESS"));
                details.setTemporaryAddress(rst.getString("TEMPORARY_ADDRESS"));
                details.setSalary(rst.getInt("SALARY"));
                details.setState(rst.getString("STATE"));
                details.setDistrict(rst.getString("DISTRICT"));
                deliveryDetails.add(details);
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        return deliveryDetails;
    }


}

    