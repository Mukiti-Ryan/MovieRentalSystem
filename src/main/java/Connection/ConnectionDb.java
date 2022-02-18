package Connection;

import java.sql.*;

public class ConnectionDb {

    private static String url = "jdbc:mysql://192.168.64.2:3306/movierental";
    private static String user = "ecwork";
    private static String password = "pass.word.1";

    public static void main(String[] args) {
        ConnectionDb connection = new ConnectionDb();
        System.out.println("Connection to the database is successful: "+url);
    }

    public java.sql.Connection connect() throws SQLException {
        return DriverManager.getConnection(url,user,password);
    }
}
