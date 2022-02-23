package Services;

import Model.Customer;
import Model.Film;
import Model.Inventory;
import Model.Staff;
import java.sql.*;
import java.util.Scanner;
import static Connection.ConnectionDb.connect;

public class Account{
    static Scanner sc = new Scanner(System.in);

    public Staff login() {
//        if (isloggedin()) {
//            System.out.println(Staff.getUserName()+" is currently logged in.");
//        }
        System.out.println("Please enter your username and password to login.");
        System.out.println("Enter your username");
        String userName = sc.next();
        System.out.println("Enter your password");
        String password = sc.next();

        try {
            Connection conn = connect();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM staff WHERE userName=? AND password=?");
            ps.setString(1, userName);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            if (rs.next()){
                return extractStaffFromResultSet(rs);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

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

    public Customer viewCustomerDetails() {
        System.out.println("Enter the email of the customer: ");
        String email = sc.next();
        try{
            Connection conn = connect();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM customer WHERE email=?");
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();

            if (rs.next()){
                return extractCustomerFromResultSet(rs);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public Customer extractCustomerFromResultSet(ResultSet rs) {
        Customer customer = new Customer();
        try {
            customer.setCustomerId(rs.getInt("customerId"));
            customer.setFirstName(rs.getString("firstName"));
            customer.setLastName(rs.getString("lastName"));
            customer.setEmail(rs.getString("email"));
            customer.setActive(rs.getBoolean("active"));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return customer;
    }

    public Inventory viewInventoryDetails() {
        System.out.println("Enter the inventory id of the film");
        int inventoryId = sc.nextInt();
        try{
            Connection conn = connect();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM inventory WHERE inventoryId=?");
            ps.setInt(1, inventoryId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return extractInventoryFromResultSet(rs);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public Inventory extractInventoryFromResultSet(ResultSet rs) {
        Inventory inventory = new Inventory();
        try {
            inventory.setInventoryId(rs.getInt("inventoryId"));
            inventory.setFilm_Id(rs.getInt("film_Id"));
            inventory.setLastUpdate(rs.getTimestamp("lastUpdate"));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return inventory;
    }

    public Film viewFilmDetails() {
        System.out.println("Enter the filmId of the film: ");
        int filmId = sc.nextInt();
        try{
            Connection conn = connect();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM film WHERE filmId=?");
            ps.setInt(1, filmId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return extractFilmFromResultSet(rs);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public Film extractFilmFromResultSet(ResultSet rs) {
        Film film = new Film();
        try {
            film.setTitle(rs.getString("title"));
            film.setReleaseYear(rs.getInt("releaseYear"));
            film.setRentalDuration(rs.getInt("rentalDuration"));
            film.setRentalRate(rs.getInt("rentalRate"));
            film.setLength(rs.getInt("length"));
            film.setReplacementCost(rs.getInt("replacementCost"));
            film.setRating(rs.getInt("rating"));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return film;
    }

    public Rental viewRentalDetails() {
        System.out.println("Enter the inventoryId: ");
        int inventory_Id = sc.nextInt();
        try{
            Connection conn = connect();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM rental WHERE inventory_Id=?");
            ps.setInt(1, inventory_Id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return extractRentalFromResultSet(rs);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public Rental extractRentalFromResultSet(ResultSet rs) {
        Rental rental = new Rental();
        try {
            rental.setStaff_Id(rs.getInt("staff_Id"));
            rental.setCustomer_Id(rs.getInt("customer_Id"));
            rental.setInventory_Id(rs.getInt("inventory_Id"));
            rental.setRentalDate(rs.getTimestamp("rentalDate"));
            rental.setReturnDate(rs.getTimestamp("returnDate"));
            rental.setLastUpdate(rs.getTimestamp("lastUpdate"));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return rental;
    }

    public Payment viewPaymentDetails() {
        System.out.println("Enter the amount paid by the customer: ");
        double amount = sc.nextDouble();
        try{
            Connection conn = connect();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM payment WHERE amount=?");
            ps.setDouble(1, amount);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return extractPaymentFromResultSet(rs);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public Payment extractPaymentFromResultSet(ResultSet rs) {
        Payment payment = new Payment();
        try {
            payment.setRental_Id(rs.getInt("rental_Id"));
            payment.setCustomer_Id(rs.getInt("customer_Id"));
            payment.setStaff_Id(rs.getInt("staff_Id"));
            payment.setAmount(rs.getInt("amount"));
            payment.setPaymentDate(rs.getTimestamp("paymentDate"));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return payment;
    }

//    public boolean isloggedin() {
//        return session != null;
//    }
}

