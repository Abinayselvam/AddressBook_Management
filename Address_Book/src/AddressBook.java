import java.util.ArrayList;

public class AddressBook {
    ArrayList<Contact> contacts = new ArrayList<>();

    // UC1 → Add Contact
    public void addContact(Contact contact) {
        contacts.add(contact);
        System.out.println("Contact added successfully.");
    }

    // Display all contacts
    public void displayContacts() {
        for (Contact c : contacts) {
            c.displayContact();
        }
    }
}
