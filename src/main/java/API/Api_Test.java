package API;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;

public class Api_Test {
    public static void main(String[] args) throws IOException {
        URL url = new URL("http://localhost:3000/contacts");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        conn.setRequestMethod("GET");

        System.out.println("Response Code: " + conn.getResponseCode());
    }
}
