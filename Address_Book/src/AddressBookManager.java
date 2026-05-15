import java.util.HashMap;

public class AddressBookManager {

    private final HashMap<String, AddressBook> books = new HashMap<>();

    public void addAddressBook(String name) {
        books.put(name, new AddressBook());
    }

    public AddressBook getAddressBook(String name) {
        return books.get(name);
    }

    public void displayAllBooks() {
        for (String name : books.keySet()) {
            System.out.println("AddressBook: " + name);
        }
    }
}