package Services;
import java.sql.*;

public class PayrollDBService {
    private static Connection connection;
    public static Connection getConnection()
            throws SQLException
    {
        String url="jdbc:mysql://localhost:3306/addressbook_service";
        String username="root";
        String password="root";
        connection = DriverManager.getConnection(url,username,password);
        System.out.println("DatabaseConnected Successfully");
        return connection;
    }
    public static void readEmployeeData() {

        try {

            Connection connection =
                    PayrollDBService.getConnection();

            Statement statement =
                    connection.createStatement();

            ResultSet resultSet =
                    statement.executeQuery(
                            "SELECT * FROM addressbook_service"
                    );

            while(resultSet.next()) {

                System.out.println(

                        resultSet.getInt("id")
                                + " "

                                + resultSet.getString("first_name")
                                + " "

                                + resultSet.getString("last_name")
                                + " "

                                + resultSet.getString("address")
                                +" "

                                + resultSet.getString("city")
                                +" "

                                + resultSet.getString("state")
                                +" "

                                + resultSet.getString("zip")
                                +" "

                                + resultSet.getString("phone_number")
                                 +" "

                                 +resultSet.getString("email")
                                +" "



                );
            }

            connection.close();

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}
