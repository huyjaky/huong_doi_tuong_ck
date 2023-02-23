package dataunit;

import java.sql.Connection;
import java.sql.DriverManager;

import com.mysql.cj.jdbc.Driver;

public class dataunit {
    
    public static Connection getConnection() {
        Connection c = null;

        String url = "jdbc:mySQL://localhost:3306/quanlytaikhoancanhan";
        String user_name = "root";
        String password = "";

        try {
            DriverManager.registerDriver(new Driver());
            c = DriverManager.getConnection(url, user_name, password);
            
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return c;
    }

    public static void closeConnection (Connection c) {
        try {
            if ( c != null) c.close();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
}
