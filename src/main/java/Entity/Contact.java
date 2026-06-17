package Entity;
import java.util.Objects;

public class Contact {

  private int id;
    private   String firstName;
    private   String lastName;
    private   String address;
    private   String city;
    private   String state;
    private   String zip;
    private   String email;
    private   String phoneNumber;
  public Contact(){}

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setAddress(String address){ this.address = address; }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
    public String getAddress() {return  address;}

    public String getZip() {return zip;}
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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