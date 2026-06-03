import java.io.*;
import java.util.List;

public class AddressBookFileIOService {

    public static String FILE_NAME =
            "AddressBookData.txt";

    // WRITE TO FILE

    public void writeData(
            List<Contact> contacts)

            throws IOException {

        BufferedWriter writer =

                new BufferedWriter(

                        new FileWriter(
                                FILE_NAME
                        )
                );

        for(Contact person : contacts) {

            writer.write(

                    person.toString()
            );

            writer.newLine();
        }

        writer.close();

        System.out.println(
                "Data Written Successfully"
        );
    }

    // READ FROM FILE

    public void readData()

            throws IOException {

        BufferedReader reader =

                new BufferedReader(

                        new FileReader(
                                FILE_NAME
                        )
                );

        String line;

        while((line = reader.readLine())
                != null) {

            System.out.println(
                    line
            );
        }

        reader.close();
    }

    // COUNT ENTRIES

    public long countEntries()

            throws IOException {

        BufferedReader reader =

                new BufferedReader(

                        new FileReader(
                                FILE_NAME
                        )
                );

        return reader.lines()
                .count();
    }
}