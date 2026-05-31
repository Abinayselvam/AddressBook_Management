import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AddressBookSystem {

     Map<String, AddressBook> addressBooks = new HashMap<>();
    Map<String,List<Contact>>
            cityMap = new HashMap<>();

    Map<String,List<Contact>>
            stateMap = new HashMap<>();

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
    public AddressBook getBook(
            String bookName) {

        return addressBooks.get(
                bookName
        );
    }
    // SEARCH BY CITY

    public List<Contact>
    searchByCity(
            String city) {

        return addressBooks.values()

                .stream()

                .flatMap(

                        book ->

                                book.getContacts()
                                        .stream()
                )

                .filter(

                        person ->

                                person.city
                                        .equalsIgnoreCase(
                                                city
                                        )
                )

                .collect(
                        Collectors.toList()
                );
    }

    // SEARCH BY STATE

    public List<Contact>
    searchByState(
            String state) {

        return addressBooks.values()

                .stream()

                .flatMap(

                        book ->

                                book.getContacts()
                                        .stream()
                )

                .filter(

                        person ->

                                person.state
                                        .equalsIgnoreCase(
                                                state
                                        )
                )

                .collect(
                        Collectors.toList()
                );
    }
}