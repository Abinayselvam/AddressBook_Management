public class Contact {

    String firstName;
    String lastName;
    String address;
    String city;
    String state;
    String zip;
    String email;
    String phoneNumber;

    public Contact(String firstName, String lastName, String address,
                   String city, String state, String zip,
                   String email, String phoneNumber) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public void displayContact() {
        System.out.println(firstName + " " + lastName + " | " +
                address + ", " + city + ", " + state +
                " | " + zip + " | " + phoneNumber + " | " + email);
    }

    @Override
    public boolean equals(
            Object obj) {

        if(this == obj)
            return true;

        if(obj == null ||
                getClass() != obj.getClass())
            return false;

        Contact person =
                (Contact) obj;

        return firstName.equalsIgnoreCase(
                person.firstName
        )
                &&
                lastName.equalsIgnoreCase(
                        person.lastName
                );
    }

    @Override
    public int hashCode() {

        return Objects.hash(

                firstName.toLowerCase(),

                lastName.toLowerCase()
        );
    }


}