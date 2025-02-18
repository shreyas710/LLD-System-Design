import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    Connection mysqlConnection;

    DBConnection(){
        try {
            mysqlConnection = DriverManager.getConnection("url", "username", "password");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
