package Connection;

import java.sql.*;

public class ConnectionDb {
    public static Connection connect() throws SQLException {
        String url = "jdbc:mysql://192.168.64.2:3306/movierental";
        String user = "ecwork";
        String password = "pass.word.1";
        System.out.println("Connection to the database is successful");
        return DriverManager.getConnection(url,user,password);
    }
}
