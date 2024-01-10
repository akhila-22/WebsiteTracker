// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main {

    public static void main(String[] args) throws IOException, SQLException, InterruptedException {
        WebsiteControl c=new WebsiteControl();
           ResultSet rs=c.getfromdatabase();
        double runtimeInSeconds=0.0;
           while(rs.next()){
               String url=rs.getString("url");
               String name=rs.getString("name");
               int id=rs.getInt("id");
               int statuscode =rs.getInt("statuscode");
               WebsiteModel website=new WebsiteModel(id,url,name,statuscode);
               WebsiteView view=new WebsiteView();
               int code=HttpConnection.HttpConnect(website);
               System.out.println(code);
               view.show(website);
               if(code!= website.getStatus())
               {
                 Thread thread1 = new Thread(() -> {
                      try {
                          c.updatecurrentstatus(code,website);
                      } catch (SQLException e) {
                          throw new RuntimeException(e);
                      }
                  });

                   Thread thread2 = new Thread(() -> {
                       try {
                           c.updatestatuslog(code,website);
                       } catch (SQLException e) {
                           throw new RuntimeException(e);
                       }
                   });

                   /*long startTime = System.nanoTime();
                   c.updatecurrentstatus(code,website);
                   c.updatestatuslog(code,website);*/
                   thread1.start();
                   thread2.start();
                   thread1.join();
                   thread2.join();
                  /* long endTime = System.nanoTime();
                   long runtimeInNanos = endTime - startTime;
                   runtimeInSeconds += (double) runtimeInNanos / 1_000_000_000.0;

                   System.out.println("Runtime: " + runtimeInSeconds + " seconds");*/

               }
               else {

                   Thread thread3 = new Thread(() -> {
                       try {
                           c.updatestatuslog(code,website);
                       } catch (SQLException e) {
                           throw new RuntimeException(e);
                       }
                   });
                   thread3.start();
                   thread3.join();
               }
           }
       }

}
