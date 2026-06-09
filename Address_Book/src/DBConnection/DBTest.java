package DBConnection;
import Services.PayrollDBService;
import java.sql.Connection;
import java.sql.SQLException;


public class DBTest {

     public static void main(String[] args)
     {

         try{

             Connection connection= PayrollDBService.getConnection();
             PayrollDBService.readEmployeeData();
             connection.close();

         } catch (SQLException e) {
             throw new RuntimeException(e);
         }
     }


}
