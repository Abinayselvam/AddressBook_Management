package Services;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Type;
import java.util.List;
import Entity.Contact;

public class AddressBookJSONService {
    private static final String FILE_NAME="AddressBook.json";
    Gson gson=new GsonBuilder().setPrettyPrinting().create();
public  void jsonRead()
        throws Exception
{
    JsonReader reader=new JsonReader(new FileReader(FILE_NAME));
    Type type=new TypeToken<List<Contact>>(){}.getType();
    List<Contact> contacts=gson.fromJson(reader,type);
    contacts.forEach(Contact::displayContact);
    reader.close();
}
public void jsonWrite(List<Contact> contacts)
        throws Exception
{
    FileWriter writer=new FileWriter(FILE_NAME);
    gson.toJson(contacts,writer);
    writer.close();
    System.out.println("JSON file written successfully");
}
}
