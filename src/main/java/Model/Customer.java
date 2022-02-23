package Model;

import java.sql.*;

import static Connection.ConnectionDb.connect;

public class Customer {
    private int address_Id;
    private static int customerId;
    private String firstName;
    private String lastName;
    public static String email;
    private Timestamp dateCreated;
    private Timestamp lastUpdate;

    public static int getCustomerId() {
        return customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public Timestamp getDateCreated() {
        return dateCreated;
    }

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setCustomerId(int customerId){
        this.customerId = customerId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDateCreated(Timestamp dateCreated) {
        this.dateCreated = dateCreated;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public static Customer extractCustomerFromResultSet(ResultSet rs) {
        Customer customer = new Customer();
        try {
            customer.setCustomerId(rs.getInt("customerId"));
            customer.setFirstName(rs.getString("firstName"));
            customer.setLastName(rs.getString("lastName"));
            customer.setEmail(rs.getString("email"));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return customer;
    }

    public static Customer viewCustomerDetails() {
        Customer customer = new Customer();
        try{
            Connection conn = connect();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM customer WHERE email=?");
            ps.setString(1, Customer.email);
            ResultSet rs = ps.executeQuery();

            if (rs.next()){
                return extractCustomerFromResultSet(rs);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return customer;
    }
}
