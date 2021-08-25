package Database;
import java.sql.Connection;
import java.sql.DriverManager;
public class DatabaseOperations 
{
   private static Connection connection;

   public static Connection getConnection() 
   {
        
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","E_post","123");
          
        }
  
        
        catch(Exception ex)
        {
            System.out.println("  "+ex);
        }
        return connection;
    }
    
}
