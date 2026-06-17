package Services;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;
import Entity.Contact;

public class AddressBookCSVService {
    private static final String FILE_NAME="AddressBook.csv";

    public void writeFile(List<Contact> contactList)
        throws Exception
    {
        CSVWriter writer=new CSVWriter(new FileWriter(FILE_NAME));
        for (Contact contact:contactList)
        {
            String[] data={
                    contact.getFirstName(),
                    contact.getLastName(),
                    contact.getEmail(),
                    contact.getAddress(),
                    contact.getCity(),
                    contact.getState(),
                    contact.getPhoneNumber(),
                    contact.getZip()
            };
            writer.writeNext(data);
        }
        writer.close();
        System.out.println("CSV File written successfully");
    }
    public void readFile()
        throws Exception
    {
        CSVReader reader=new CSVReader(new FileReader(FILE_NAME));
        String[] record;
        while ((record=reader.readNext())!=null)
        {
            System.out.println(String.join(" | ",record));
        }
        reader.close();
    }
}