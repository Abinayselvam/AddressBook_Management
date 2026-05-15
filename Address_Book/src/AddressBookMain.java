import java.util.Scanner;

public class AddressBookMain {

    public static void main(String[] args) {

        System.out.println("Welcome to Address Book Program");

        Scanner sc = new Scanner(System.in);
        AddressBookManager manager = new AddressBookManager();

        // UC5 → create multiple address books
        System.out.print("Enter Address Book Name: ");
        String bookName = sc.nextLine();

        manager.addAddressBook(bookName);
        AddressBook book = manager.getAddressBook(bookName);

        // UC4 → multiple contacts
        while (true) {

            System.out.println("\n1.Add 2.Edit 3.Delete 4.Display 5.Exit");
            int choice = sc.nextInt();
            sc.nextLine(); // fix buffer

            switch (choice) {

                case 1 -> {
                    System.out.print("First Name: ");
                    String firstName = sc.nextLine();

                    System.out.print("Last Name: ");
                    String lastName = sc.nextLine();

                    System.out.print("Address: ");
                    String address = sc.nextLine();

                    System.out.print("City: ");
                    String city = sc.nextLine();

                    System.out.print("State: ");
                    String state = sc.nextLine();

                    System.out.print("Zip: ");
                    String zip = sc.nextLine();

                    System.out.print("Phone: ");
                    String phone = sc.nextLine();

                    System.out.print("Email: ");
                    String email = sc.nextLine();

                    book.addContact(new Contact(firstName, lastName,
                            address, city, state, zip, email, phone));
                }

                case 2 -> {
                    System.out.print("Enter name to edit: ");
                    book.editContact(sc.nextLine(), sc);
                }

                case 3 -> {
                    System.out.print("Enter name to delete: ");
                    book.deleteContact(sc.nextLine());
                }

                case 4 -> book.displayContacts();

                case 5 -> {
                    System.out.println("Exiting...");
                    return;
                }
            }
        }
    }
}