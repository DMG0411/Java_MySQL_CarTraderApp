import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class SQLConnection {
    Connection conn = null;
    Statement st = null;

    SQLConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.conn = DriverManager.getConnection("jdbc:mysql:///carstocks", "root", "Ampulamare22");
            this.st = this.conn.createStatement(1004, 1008);
        } catch (Exception var2) {
            var2.printStackTrace();
        }

    }
}