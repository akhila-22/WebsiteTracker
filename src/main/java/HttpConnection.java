import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpConnection {
    public static int HttpConnect(WebsiteModel website) throws IOException {
        String s= website.getUrl();
        URL url=new URL(s);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        int responseCode;
        responseCode = connection.getResponseCode();
        return responseCode;
    }

}
