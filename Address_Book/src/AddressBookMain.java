import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class AddressBookMain {

    public static void main(String[] args) {

        System.out.println(
                "Welcome To Address Book Program"
        );

        Scanner sc = new Scanner(System.in);

        AddressBookSystem system =
                new AddressBookSystem();

        AddressBookFileIOService fileIO =
                new AddressBookFileIOService();

        AddressBookCSVService csvService=new AddressBookCSVService();
        AddressBookJSONService jsonService=new AddressBookJSONService();


        System.out.print(
                "Enter Address Book Name: "
        );

        String bookName =
                sc.nextLine();

        system.addAddressBook(
                bookName
        );

        AddressBook book =
                system.getBook(
                        bookName
                );

        while(true) {

            System.out.println("""

                    ===== MENU =====

                    1.Add Contact
                    2.Edit Contact
                    3.Delete Contact
                    4.Display Contacts
                    5.Search By City
                    6.Search By State
                    7.Count By City
                    8.Count By State
                    9.Sort By Name
                    10.Sort By City
                    11.Sort By State
                    12.Sort By Zip
                    13.Write To File
                    14.Read From File
                    15.Count File Entries
                    16.CSV Write
                    17.CSV Read
                    18.CSV Read
                    19.CSV Write
                    20.Exit
                    """);

            int choice =
                    sc.nextInt();

            sc.nextLine();

            switch(choice) {

                case 1 -> {

                    System.out.print(
                            "First Name: ");
                    String firstName =
                            sc.nextLine();

                    System.out.print(
                            "Last Name: ");
                    String lastName =
                            sc.nextLine();

                    System.out.print(
                            "Address: ");
                    String address =
                            sc.nextLine();

                    System.out.print(
                            "City: ");
                    String city =
                            sc.nextLine();

                    System.out.print(
                            "State: ");
                    String state =
                            sc.nextLine();

                    System.out.print(
                            "Zip: ");
                    String zip =
                            sc.nextLine();

                    System.out.print(
                            "Email: ");
                    String email =
                            sc.nextLine();

                    System.out.print(
                            "Phone: ");
                    String phone =
                            sc.nextLine();

                    Contact contact =
                            new Contact(
                                    firstName,
                                    lastName,
                                    address,
                                    city,
                                    state,
                                    zip,
                                    email,
                                    phone
                            );

                    book.addContact(
                            contact
                    );
                }

                case 2 -> {

                    System.out.print(
                            "Enter Name To Edit: ");

                    book.editContact(
                            sc.nextLine(),
                            sc
                    );
                }

                case 3 -> {

                    System.out.print(
                            "Enter Name To Delete: ");

                    book.deleteContact(
                            sc.nextLine()
                    );
                }

                case 4 ->

                        book.displayContacts();

                case 5 -> {

                    System.out.print(
                            "Enter City: ");

                    String city =
                            sc.nextLine();

                    List<Contact> result =

                            system.searchByCity(
                                    city
                            );

                    result.forEach(
                            Contact::displayContact
                    );
                }

                case 6 -> {

                    System.out.print(
                            "Enter State: ");

                    String state =
                            sc.nextLine();

                    system.searchByState(
                                    state
                            )
                            .forEach(
                                    Contact::displayContact
                            );
                }

                case 7 -> {

                    System.out.print(
                            "Enter City: ");

                    String city =
                            sc.nextLine();

                    System.out.println(

                            "Count = "

                                    +

                                    book.countByCity(
                                            city
                                    )
                    );
                }

                case 8 -> {

                    System.out.print(
                            "Enter State: ");

                    String state =
                            sc.nextLine();

                    System.out.println(

                            "Count = "

                                    +

                                    book.countByState(
                                            state
                                    )
                    );
                }

                case 9 ->

                        system.sortByName();

                case 10 ->

                        system.sortByCity();

                case 11 ->

                        system.sortByState();

                case 12 ->

                        system.sortByZip();

                case 13 -> {

                    try {

                        fileIO.writeData(
                                book.getContacts()
                        );

                    }

                    catch(IOException e) {

                        System.out.println(

                                "File Write Error : "

                                        +

                                        e.getMessage()
                        );
                    }
                }

                case 14 -> {

                    try {

                        fileIO.readData();
                    }

                    catch(IOException e) {

                        System.out.println(

                                "File Read Error : "

                                        +

                                        e.getMessage()
                        );
                    }
                }

                case 15 -> {

                    try {

                        System.out.println(

                                "Entries : "

                                        +

                                        fileIO.countEntries()
                        );
                    }

                    catch(IOException e) {

                        System.out.println(

                                "Count Error : "

                                        +

                                        e.getMessage()
                        );
                    }
                }


                case 16 -> {

                    try {

                        csvService.writeFile(
                                book.getContacts()
                        );

                    } catch (Exception e) {

                        System.out.println(
                                e.getMessage()
                        );
                    }
                }
                case 17 ->{
                    try{
                        csvService.readFile();

                    }
                    catch (Exception e)
                    {
                        System.out.println(e.getMessage());
                    }
                }
                case 18 ->
                {
                    try {
                        jsonService.jsonRead();

                    }
                    catch (Exception  e)
                    {
                        System.out.println(e.getMessage());
                    }
                }
                case 19 ->
                {
                    try {
                        jsonService.jsonWrite(book.getContacts());
                    }
                    catch (Exception e)
                    {
                        System.out.println(e.getMessage());
                    }

                }
                case 20 -> {

                    System.out.println(
                            "Exiting..."
                    );

                    sc.close();

                    return;
                }

                default ->

                        System.out.println(
                                "Invalid Choice"
                        );
            }
        }
    }
}