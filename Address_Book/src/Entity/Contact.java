package Entity;
import java.util.Objects;

public class Contact {

  public   String firstName;
  public   String lastName;
  public   String address;
  public   String city;
  public   String state;
  public   String zip;
  public   String email;
  public   String phoneNumber;

    public String getFirstName() {
        return firstName;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZip() {
        return zip;
    }
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
    @Override
    public String toString() {

        return firstName + "," +

                lastName + "," +

                address + "," +

                city + "," +

                state + "," +

                zip + "," +

                phoneNumber + "," +

                email;
    }


}