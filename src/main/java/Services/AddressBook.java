package Services;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import Entity.Contact;

public class AddressBook {

    private final ArrayList<Contact>
            contacts =
            new ArrayList<>();

    // UC7 — Duplicate Check

    public void addContact(Contact person) {

        if(contacts.contains(person)) {

            System.out.println(
                    "Duplicate Contact Found!"
            );

            return;
        }

        contacts.add(person);

        System.out.println(
                "Contact Added Successfully"
        );
    }


    public void displayContacts() {

        contacts.forEach(
                Contact::displayContact
        );
    }

    public void editContact(
            String firstName,
            Scanner sc) {

        for(Contact c : contacts) {

            if(c.getFirstName()
                    .equalsIgnoreCase(
                            firstName
                    )) {

                System.out.print(
                        "New City: "
                );

                c.setAddress(sc.nextLine());


                System.out.print(
                        "New Phone: "
                );

                c.setPhoneNumber( sc.nextLine());
                       ;

                return;
            }
        }

        System.out.println(
                "Contact not found"
        );
    }

    public void deleteContact(String firstName) {
        contacts.removeIf(c -> c.getFirstName().equalsIgnoreCase(firstName));
    }

    public ArrayList<Contact>
    getContacts() {

        return contacts;
    }

    // UC8 — Search By City

    public List<Contact>
    searchByCity(
            String city) {

        return contacts.stream()

                .filter(

                        c -> c.getCity()
                                .equalsIgnoreCase(
                                        city
                                )
                )

                .collect(
                        Collectors.toList()
                );
    }

    // UC8 — Search By State

    public List<Contact>
    searchByState(
            String state) {

        return contacts.stream()

                .filter(

                        c -> c.getState()
                                .equalsIgnoreCase(
                                        state
                                )
                )

                .collect(
                        Collectors.toList()
                );
    }

    // UC10 — Count By City

    public long countByCity(
            String city) {

        return contacts.stream()

                .filter(

                        c -> c.getCity()
                                .equalsIgnoreCase(
                                        city
                                )
                )

                .count();
    }

    // UC10 — Count By State

    public long countByState(
            String state) {

        return contacts.stream()

                .filter(

                        c -> c.getState()
                                .equalsIgnoreCase(
                                        state
                                )
                )

                .count();
    }
    public void sortByName() {

        contacts.stream()

                .sorted(

                        Comparator.comparing(
                                Contact::getFirstName
                        )
                )

                .forEach(
                        System.out::println
                );
    }


}