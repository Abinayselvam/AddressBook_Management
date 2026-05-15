import java.util.ArrayList;
import java.util.Scanner;

public class AddressBook {
    ArrayList<Contact> contacts = new ArrayList<>();
    // UC1
    public void displayContacts() {
        for (Contact c : contacts) {
            c.displayContact();
        }
    }
    // UC2 → Add Contact
    public void addContact(Contact contact) {
        contacts.add(contact);
        System.out.println("Contact added successfully.");
    }


    //UC3 -> Edit Contact
    public void editContact(String firstName, Scanner sc) {
        for (Contact c : contacts) {
            if (c.firstName.equalsIgnoreCase(firstName)) {

                System.out.println("Editing contact...");

                System.out.print("New Address: ");
                c.address = sc.nextLine();

                System.out.print("New City: ");
                c.city = sc.nextLine();

                System.out.print("New State: ");
                c.state = sc.nextLine();

                System.out.print("New Zip: ");
                c.zip = sc.nextDouble();

                System.out.print("New Phone: ");
                c.phoneNumber = sc.nextDouble();

                System.out.print("New Email: ");
                c.email = sc.nextLine();

                System.out.println("Contact updated.");
                return;
            }
        }
        System.out.println("Contact not found.");
    }
    //UC4 -Delete Contact
    public void deleteContact(String firstName) {
        Contact toRemove = null;

        for (Contact c : contacts) {
            if (c.firstName.equalsIgnoreCase(firstName)) {
                toRemove = c;
                break;
            }
        }

        if (toRemove != null) {
            contacts.remove(toRemove);
            System.out.println("Contact deleted.");
        } else {
            System.out.println("Contact not found.");
        }
    }
}
