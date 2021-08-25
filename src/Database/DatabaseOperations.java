package Database;
import java.awt.List;
import java.awt.TextField;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
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
    public List getLoginCredentials(TextField usernameTextField, TextField passwordField)
    {
          List loginCredentials = new List();
          
          try
            {                
                String userName = usernameTextField.getText();
                String userPassword = passwordField.getText();                

                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","E_Post","123");
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("select user_ID from Login where user_ID like '"+'%'+userName+'%'+"'");
                boolean next = rs.next();
                
                if(next)
                {
                    ResultSet rspass = st.executeQuery("select password,salt,login_type from Login where user_ID like '"+'%'+userName+'%'+"'");
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
    
}
