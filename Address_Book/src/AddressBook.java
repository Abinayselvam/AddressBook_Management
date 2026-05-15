import java.util.ArrayList;
import java.util.Scanner;

public class AddressBook {

    private final ArrayList<Contact> contacts = new ArrayList<>();

    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    public void displayContacts() {
        for (Contact c : contacts) {
            c.displayContact();
        }
    }

    public void editContact(String firstName, Scanner sc) {
        for (Contact c : contacts) {
            if (c.firstName.equalsIgnoreCase(firstName)) {

                System.out.print("New City: ");
                c.city = sc.nextLine();

                System.out.print("New Phone: ");
                c.phoneNumber = sc.nextLine();

                return;
            }
        }
        System.out.println("Contact not found");
    }

    public void deleteContact(String firstName) {
        contacts.removeIf(c -> c.firstName.equalsIgnoreCase(firstName));
    }
}