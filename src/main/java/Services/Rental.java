package Services;

import Model.Customer;
import Model.Film;
import Model.Inventory;
import Model.Staff;

import java.sql.*;
import java.util.Scanner;

import static Connection.ConnectionDb.connect;

public class Rental {
    static Scanner sc = new Scanner(System.in);

    private int staff_Id;
    private int customer_Id;
    private int inventory_Id;
    public static int rentalId;
    private Timestamp rentalDate;
    private Timestamp returnDate;
    private Timestamp lastUpdate;
    private static String titleFilm;

    public static String getTitleFilm() {
        return titleFilm;
    }

    public static void setTitleFilm(String titleFilm) {
        Rental.titleFilm = Film.getTitle();
    }

    public int getStaff_Id() {
        return staff_Id;
    }

    public void setStaff_Id(int staff_Id) {
        this.staff_Id = Staff.getStaffId();
    }

    public int getCustomer_Id() {
        return customer_Id;
    }

    public void setCustomer_Id(int customer_Id) {
        this.customer_Id = Customer.getCustomerId();
    }

    public int getInventory_Id() {
        return inventory_Id;
    }

    public void setInventory_Id(int inventory_Id) {
        this.inventory_Id = Inventory.getInventoryId();
    }

    public static int getRentalId() {
        return rentalId;
    }

    public Timestamp getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(Timestamp rentalDate) {
        this.rentalDate = rentalDate;
    }

    public Timestamp getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Timestamp returnDate) {
        this.returnDate = returnDate;
    }

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public java.util.Date returnDate(java.util.Date currentDate) {
        return null;
    }

    public static Rental viewRentalDetails() {
        Rental rental = new Rental();
        try{
            Connection conn = connect();
            PreparedStatement ps = conn.prepareStatement("SELECT FROM rental WHERE rentalId=?");
            ps.setInt(1, Rental.rentalId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return extractRentalFromResultSet(rs);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return rental;
    }

    public static Rental extractRentalFromResultSet(ResultSet rs) {
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

    public static Rental rentFilm() {
        System.out.println("Enter the name of the film you would like to rent: ");
        titleFilm = sc.next();
        try {
            Connection conn = connect();
            PreparedStatement ps = conn.prepareStatement("SELECT FROM film WHERE title=?");
            ps.setString(1, Rental.getTitleFilm());
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
