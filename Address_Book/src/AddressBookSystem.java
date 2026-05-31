import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AddressBookSystem {

     Map<String, AddressBook> addressBooks = new HashMap<>();
    HashMap<String,List<Contact>>
            cityDictionary =
            new HashMap<>();

    HashMap<String,List<Contact>>
            stateDictionary =
            new HashMap<>();
    // BUILD CITY DICTIONARY

    public void buildCityDictionary() {

        cityDictionary =

                (HashMap<String, List<Contact>>) addressBooks.values()

                        .stream()

                        .flatMap(

                                book ->

                                        book.getContacts()
                                                .stream()
                        )

                        .collect(

                                Collectors.groupingBy(

                                        person ->
                                                person.city
                                )
                        );
    }

    // BUILD STATE DICTIONARY

    public void buildStateDictionary() {

        stateDictionary =

                (HashMap<String, List<Contact>>) addressBooks.values()

                        .stream()

                        .flatMap(

                                book ->

                                        book.getContacts()
                                                .stream()
                        )

                        .collect(

                                Collectors.groupingBy(

                                        person ->
                                                person.state
                                )
                        );
    }
    public void viewByCity() {

        buildCityDictionary();

        cityDictionary.forEach(

                (city,persons) -> {

                    System.out.println(

                            "\nCity : "
                                    + city
                    );

                    persons.forEach(
                            Contact::displayContact
                    );
                }
        );
    }

    public void viewByState() {

        buildStateDictionary();

        stateDictionary.forEach(

                (state,persons) -> {

                    System.out.println(

                            "\nState : "
                                    + state
                    );

                    persons.forEach(
                            Contact::displayContact
                    );
                }
        );
    }

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
    // COUNT BY CITY

    public void countByCity() {

        Map<String,Long> cityCount =

                addressBooks.values()

                        .stream()

                        .flatMap(

                                book ->

                                        book.getContacts()
                                                .stream()
                        )

                        .collect(

                                Collectors.groupingBy(

                                        person ->
                                                person.city,

                                        Collectors.counting()
                                )
                        );

        System.out.println(
                "\nCOUNT BY CITY"
        );

        cityCount.forEach(

                (city,count) ->

                        System.out.println(

                                city
                                        + " -> "
                                        + count
                                        + " Persons"
                        )
        );
    }

    // COUNT BY STATE

    public void countByState() {

        Map<String,Long> stateCount =

                addressBooks.values()

                        .stream()

                        .flatMap(

                                book ->

                                        book.getContacts()
                                                .stream()
                        )

                        .collect(

                                Collectors.groupingBy(

                                        person ->
                                                person.state,

                                        Collectors.counting()
                                )
                        );

        System.out.println(
                "\nCOUNT BY STATE"
        );

        stateCount.forEach(

                (state,count) ->

                        System.out.println(

                                state
                                        + " -> "
                                        + count
                                        + " Persons"
                        )
        );
    }
    public void sortByName() {

        System.out.println(
                "\nSORT BY NAME"
        );

        addressBooks.values()

                .stream()

                .flatMap(

                        book ->
                                book.getContacts()
                                        .stream()
                )

                .sorted(

                        Comparator.comparing(
                                person ->
                                        person.firstName
                        )
                )

                .forEach(
                        System.out::println
                );
    }
    public void sortByCity() {

        System.out.println(
                "\nSORT BY CITY"
        );

        addressBooks.values()

                .stream()

                .flatMap(

                        book ->
                                book.getContacts()
                                        .stream()
                )

                .sorted(

                        Comparator.comparing(
                                person ->
                                        person.city
                        )
                )

                .forEach(
                        System.out::println
                );
    }
    public void sortByState() {

        System.out.println(
                "\nSORT BY STATE"
        );

        addressBooks.values()

                .stream()

                .flatMap(

                        book ->
                                book.getContacts()
                                        .stream()
                )

                .sorted(

                        Comparator.comparing(
                                person ->
                                        person.state
                        )
                )

                .forEach(
                        System.out::println
                );
    }
    public void sortByZip() {

        System.out.println(
                "\nSORT BY ZIP"
        );

        addressBooks.values()

                .stream()

                .flatMap(

                        book ->
                                book.getContacts()
                                        .stream()
                )

                .sorted(

                        Comparator.comparing(
                                person ->
                                        person.zip
                        )
                )

                .forEach(
                        System.out::println
                );
    }


}