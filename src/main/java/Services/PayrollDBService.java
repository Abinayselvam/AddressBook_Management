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
                            "WHERE start_date BETWEEN ? AND ?";

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
    public void countByCity()
    {
        try {

            Connection connection =
                    getConnection();

            String query =

                    "SELECT city, COUNT(*) total " +
                            "FROM addressbook_service " +
                            "GROUP BY city";

            Statement statement =
                    connection.createStatement();

            ResultSet rs =
                    statement.executeQuery(
                            query
                    );

            while(rs.next())
            {
                System.out.println(

                        rs.getString("city")
                                + " : "
                                +
                                rs.getInt("total")
                );
            }

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public void countByState()
    {
        try {

            Connection connection =
                    getConnection();

            String query =

                    "SELECT state, COUNT(*) total " +
                            "FROM addressbook_service " +
                            "GROUP BY state";

            Statement statement =
                    connection.createStatement();

            ResultSet rs =
                    statement.executeQuery(
                            query
                    );

            while(rs.next())
            {
                System.out.println(

                        rs.getString("state")
                                + " : "
                                +
                                rs.getInt("total")
                );
            }

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public void addContact(
            Contact contact)
    {
        try {

            Connection connection =
                    getConnection();

            String query =

                    "INSERT INTO addressbook_service " +
                            "(first_name,last_name,address,city,state,zip,phone_number,email,start_date) " +
                            "VALUES(?,?,?,?,?,?,?,?,?)";

            PreparedStatement ps =
                    connection.prepareStatement(
                            query
                    );

            ps.setString(
                    1,
                    contact.getFirstName()
            );

            ps.setString(
                    2,
                    contact.getLastName()
            );

            ps.setString(
                    3,
                    contact.getAddress()
            );

            ps.setString(
                    4,
                    contact.getCity()
            );

            ps.setString(
                    5,
                    contact.getState()
            );

            ps.setString(
                    6,
                    contact.getZip()
            );

            ps.setString(
                    7,
                    contact.getPhoneNumber()
            );

            ps.setString(
                    8,
                    contact.getEmail()
            );

            ps.setDate(
                    9,
                    Date.valueOf(
                            java.time.LocalDate.now()
                    )
            );

            ps.executeUpdate();

            System.out.println(
                    "Contact Added Successfully"
            );

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

}