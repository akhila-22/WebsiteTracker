import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UserInput {
public static void main(String[] args) throws SQLException {
    Connection con = JdbcConnection.CreateConnection();
    String query1 = "insert into currentstatus(name,url,statuscode) values(?,?,?)";
    PreparedStatement p = con.prepareStatement(query1);
    Scanner scanner = new Scanner(System.in);

    System.out.println("Enter name: ");
    String name = scanner.nextLine();

    System.out.print("Enter url: ");
    String url = scanner.nextLine();

    System.out.println("Enter status code,If the status code id unknown enter 0: ");
    int statuscode = scanner.nextInt();

    p.setString(1, name);
    p.setString(2, url);
    p.setInt(3, statuscode);
    p.executeUpdate();

}
}
