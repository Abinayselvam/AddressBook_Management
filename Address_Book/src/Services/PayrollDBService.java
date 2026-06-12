package Services;

import Entity.Contact;

import java.sql.*;

public class PayrollDBService {

    private static Connection connection;

    public static Connection getConnection()
            throws SQLException {

        String url =
                "jdbc:mysql://localhost:3306/addressbook_service";

        String username = "root";
        String password = "root";

        connection =
                DriverManager.getConnection(
                        url,
                        username,
                        password
                );

        System.out.println(
                "Database Connected Successfully"
        );

        return connection;
    }

    public static void readContactData() {

        try {

            Connection connection =
                    getConnection();

            Statement statement =
                    connection.createStatement();

            ResultSet resultSet =
                    statement.executeQuery(
                            "SELECT * FROM addressbook_service"
                    );

            while (resultSet.next()) {

                System.out.println(

                        resultSet.getInt("id") + " " +

                                resultSet.getString("first_name") + " " +

                                resultSet.getString("last_name") + " " +

                                resultSet.getString("address") + " " +

                                resultSet.getString("city") + " " +

                                resultSet.getString("state") + " " +

                                resultSet.getString("zip") + " " +

                                resultSet.getString("phone_number") + " " +

                                resultSet.getString("email")
                );
            }

            resultSet.close();
            statement.close();
            connection.close();

        }
        catch (Exception e) {

            e.printStackTrace();
        }
    }
    public void updateContact(
            String firstName,
            String city,
            String state) {
        try {

            Connection connection =
                    getConnection();

            String query =

                    "UPDATE addressbook_service " +
                            "SET city=?, state=? " +
                            "WHERE first_name=?";

            PreparedStatement ps =
                    connection.prepareStatement(query);

            ps.setString(1, city);
            ps.setString(2, state);
            ps.setString(3, firstName);

            int rows = ps.executeUpdate();

            System.out.println(
                    rows + " record updated"
            );

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
        public Contact getContactByName(
            String firstName)
        {
            Contact contact = null;

            try {

                Connection connection =
                        getConnection();

                String query =

                        "SELECT * FROM addressbook_service " +
                                "WHERE first_name = ?";

                PreparedStatement ps =
                        connection.prepareStatement(
                                query
                        );

                ps.setString(
                        1,
                        firstName
                );

                ResultSet rs =
                        ps.executeQuery();

                if(rs.next())
                {
                    contact =
                            new Contact(

                                    rs.getString(
                                            "first_name"
                                    ),

                                    rs.getString(
                                            "last_name"
                                    ),

                                    rs.getString(
                                            "address"
                                    ),

                                    rs.getString(
                                            "city"
                                    ),

                                    rs.getString(
                                            "state"
                                    ),

                                    rs.getString(
                                            "zip"
                                    ),

                                    rs.getString(
                                            "email"
                                    ),

                                    rs.getString(
                                            "phone_number"
                                    )
                            );
                }

            }
            catch(Exception e)
            {
                e.printStackTrace();
            }

            return contact;
        }
    public boolean checkContactInSync(
            String firstName,
            Contact memoryContact)
    {
        Contact dbContact =
                getContactByName(
                        firstName
                );

        return memoryContact.equals(
                dbContact
        );
    }
    public void getContactsByDateRange(
            String startDate,
            String endDate)
    {
        try {

            Connection connection =
                    getConnection();

            String query =

                    "SELECT * FROM addressbook_service " +
                            "WHERE date_added BETWEEN ? AND ?";

            PreparedStatement ps =
                    connection.prepareStatement(
                            query
                    );

            ps.setString(1, startDate);
            ps.setString(2, endDate);

            ResultSet rs =
                    ps.executeQuery();

            while(rs.next())
            {
                System.out.println(

                        rs.getString("first_name")
                                + " "
                                +
                                rs.getString("last_name")
                );
            }

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

}