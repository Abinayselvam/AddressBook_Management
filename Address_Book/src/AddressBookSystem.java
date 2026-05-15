import java.util.HashMap;
import java.util.Map;

public class AddressBookSystem {

     Map<String, AddressBook> addressBooks = new HashMap<>();

    public void addAddressBook(String name) {
        if (addressBooks.containsKey(name)) {
            System.out.println("Address Book already exists!");
        } else {
            addressBooks.put(name, new AddressBook());
            System.out.println("Address Book '" + name + "' created.");
        }
    }

    public AddressBook getAddressBook(String name) {
        return addressBooks.get(name);
    }

    public void displayAllBooks() {
        for (String name : addressBooks.keySet()) {
            System.out.println(name);
        }
    }
}