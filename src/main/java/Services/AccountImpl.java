package Services;

import Model.Staff;
import java.sql.*;
import java.util.Scanner;
import static Connection.ConnectionDb.connect;

public class AccountImpl implements Account{
    Scanner sc = new Scanner(System.in);

    private String user;
    private String pass;

    @Override
    public Staff login(String user, String pass) {
        if (isloggedin()) {
            System.out.println(Staff.getUserName()+" is currently logged in.");
        }
        System.out.println("Please enter your username and password to login.");
        System.out.println("Enter your username");
        Staff.userName = sc.next();
        System.out.println("Enter your password");
        Staff.password = sc.next();

        try {
            Connection conn = connect();
            PreparedStatement ps = conn.prepareStatement("SELECT FROM staff WHERE userName=? AND password=?");
            ps.setString(1, Staff.userName);
            ps.setString(2, Staff.password);
            ResultSet rs = ps.executeQuery();

            if (rs.next()){
                return extractStaffFromResultSet(rs);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public Staff extractStaffFromResultSet(ResultSet rs) {
        Staff staff = new Staff();
        try {
            staff.setStaffId(rs.getInt("staffId"));
            staff.setFirstName(rs.getString("firstName"));
            staff.setLastName(rs.getString("lastName"));
            staff.setEmail(rs.getString("email"));
            staff.setUserName(rs.getString("userName"));
            staff.setPassword(rs.getString("password"));
            staff.setLastUpdate(rs.getTimestamp("lastUpdate"));
            staff.setPictureUrl(rs.getString("pictureUrl"));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return staff;
    }

    @Override
    public boolean isloggedin() {
        return true;
    }
}

