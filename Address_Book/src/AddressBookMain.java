import java.util.Scanner;

public class AddressBookMain {
    public  static  void main(String[] args)
    {
        System.out.println("Welcome to the Book Management System");
        Scanner sc=new Scanner(System.in);
        AddressBook book=new AddressBook();

        System.out.println("Enter the firstName:");
        String firstName=sc.nextLine();

        System.out.println("Enter the lastName:");
        String lastName=sc.nextLine();

        System.out.println("Enter the address:");
        String address=sc.nextLine();

        System.out.println("Enter the City Name:");
        String city=sc.nextLine();

        System.out.println("Enter the State Name:");
        String state=sc.nextLine();

        System.out.println("Enter the ZIP Code:");
        Double zipCode=sc.nextDouble();

        System.out.println("Enter the Phone:");
        Double phone= sc.nextDouble();

        System.out.println("Enter the Email:");
        String email=sc.nextLine();


        Contact contact=new Contact(firstName,lastName,address,city,state,zipCode,email,phone);
        book.addContact(contact);
        book.editContact(firstName,sc);
        System.out.println("Show the Contact Details:");
        contact.displayContact();
        sc.close();
    }
}
