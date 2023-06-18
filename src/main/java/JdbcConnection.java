import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcConnection {
    static Connection con;
    public static Connection CreateConnection(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String user="root";
            String password="myroot";
            String url="jdbc:mysql://localhost:3306/website_log";
            con=DriverManager.getConnection(url,user,password);

        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
}
