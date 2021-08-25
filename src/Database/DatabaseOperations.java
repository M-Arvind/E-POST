package Database;
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

public class DatabaseOperations 
{
   private static Connection connection;

   public static Connection getConnection() 
   {
        
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","E_Post","123");
        }
  
        
        catch(Exception ex)
        {
            System.out.println("  "+ex);
        }
        return connection;
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
    
}