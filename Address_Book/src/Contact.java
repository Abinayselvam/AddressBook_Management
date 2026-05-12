public class Contact {

    private final String fistName;
    private final String lastName;
    private final String address;
    private final String city;
    private final String state;
    private final double zip;
    private final String email;
    private final double phoneNumber;
    public Contact(String firstName,String lastName,String address,String city,String state,Double zip,String email,Double phoneNumber)
    {
        this.fistName=firstName;
        this.lastName=lastName;
        this.address=address;
        this.city=city;
        this.state=state;
        this.zip=zip;
        this.email=email;
        this.phoneNumber=phoneNumber;

    }
    public void displayContact() {
        System.out.println("Name: " + fistName + " " + lastName);
        System.out.println("Address: " + address);
        System.out.println("City: " + city);
        System.out.println("State: " + state);
        System.out.println("Zip: " + zip);
        System.out.println("Phone: " + phoneNumber);
        System.out.println("Email: " + email);
    }
}
