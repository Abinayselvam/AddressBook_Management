import java.util.List;
import java.util.Scanner;

public class AddressBookMain {

    public static void main(String[] args) {

        System.out.println(
                "Welcome To Address Book Program"
        );

        Scanner sc =
                new Scanner(System.in);

        AddressBookSystem system =
                new AddressBookSystem();

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

            System.out.println(

                    "\n1.Add Contact" +
                            "\n2.Edit Contact" +
                            "\n3.Delete Contact" +
                            "\n4.Display Contacts" +
                            "\n5.Search By City" +
                            "\n6.Search By State" +
                            "\n7.Count By City" +
                            "\n8.Count By State" +
                            "\n9.Exit"
            );

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
                    ).forEach(
                            Contact::displayContact
                    );
                }

                case 7 -> {

                    System.out.print(
                            "Enter City: ");

                    String city =
                            sc.nextLine();

                    System.out.println(

                            "Count = " +

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

                            "Count = " +

                                    book.countByState(
                                            state
                                    )
                    );
                }

                case 9 -> {

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
            system.viewByCity();
        }

    }
}