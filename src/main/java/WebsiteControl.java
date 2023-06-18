import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
public class WebsiteControl{
    private WebsiteModel model;
    private WebsiteView view;
    public WebsiteControl() {
    }
    public WebsiteControl(WebsiteModel model, WebsiteView view) {
        this.model = model;
        this.view = view;
    }
    public void updateWebsiteDetails(String name, String url,int status) {
        model.setName(name);
        model.setUrl(url);
        model.setStatus(status);
    }
    public void displayWebsiteDetails() {
        view.show(model);
    }
    public static ResultSet getfromdatabase() throws SQLException {
        Connection con=JdbcConnection.CreateConnection();
        String query="select id,name,url,statuscode from currentstatus";
        PreparedStatement p2=con.prepareStatement(query);
        ResultSet rs= p2.executeQuery();
        return rs;

    }
    public void updatecurrentstatus(int code,WebsiteModel website) throws SQLException {
        Connection con=JdbcConnection.CreateConnection();
        String query1="update currentstatus set statuscode=? where id=?";
        PreparedStatement p3=con.prepareStatement(query1);
        p3.setInt(1,code);
        p3.setInt(2,website.getId());
        p3.executeUpdate();
    }
    public void updatestatuslog(int code,WebsiteModel website) throws SQLException {
        Connection con=JdbcConnection.CreateConnection();
        String query2="insert into statuslog(webid,name,url,statuscode,time) values(?,?,?,?,now())";
        PreparedStatement ps=con.prepareStatement(query2);
        ps.setInt(1,website.getId());
        ps.setString(2,website.getName());
        ps.setString(3,website.getUrl());
        ps.setInt(4,code);
        ps.executeUpdate();
    }



    }

