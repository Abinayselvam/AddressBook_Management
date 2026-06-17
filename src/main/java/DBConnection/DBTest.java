package DBConnection;
import Entity.Contact;
import Services.PayrollDBService;
import java.sql.Connection;
import java.sql.SQLException;


public class DBTest {

     public static void main(String[] args)
     {

         try{

             Connection connection= PayrollDBService.getConnection();
             PayrollDBService.readContactData();
             PayrollDBService service=new PayrollDBService();
             Contact contact =
                     service.getContactByName(
                             "Abi"
                     );
             service.getContactsByDateRange(
                     "2026-01-01",
                     "2026-12-31"
             );

             boolean result =
                     service.checkContactInSync(
                             "Abi",
                             contact
                     );

             System.out.println(
                     "Sync Status : " + result
             );
             service.countByCity();
             service.countByState();
             Contact contacts =
                     new Contact(
                             "Abi",
                             "Selvam",
                             "Chennai",
                             "Chennai",
                             "TN",
                             "600001",
                             "abi@gmail.com",
                             "9876543210"
                     );

             service.addContact(
                     contacts
             );
             connection.close();


         } catch (SQLException e) {
             throw new RuntimeException(e);
         }
     }




}
