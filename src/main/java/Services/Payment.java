package Services;

import Model.Customer;
import Model.Film;
import Model.Staff;

import java.sql.*;

import static Connection.ConnectionDb.connect;

public class Payment {
    private int customer_Id;
    private int staff_Id;
    private int rental_Id;
    private static int paymentId;
    private int amount;
    private Timestamp paymentDate;
    private String filmTitle;

    public String getFilmTitle() {
        return filmTitle;
    }

    public void setFilmTitle(String filmTitle) {
        this.filmTitle = filmTitle;
    }

    public int getRental_Id() {
        return rental_Id;
    }

    public void setRental_Id(int rental_Id) {
        this.rental_Id = Rental.getRentalId();
    }

    public int getCustomer_Id() {
        return customer_Id;
    }

    public void setCustomer_Id(int customer_Id) {
        this.customer_Id = Customer.getCustomerId();
    }

    public int getStaff_Id() {
        return staff_Id;
    }

    public void setStaff_Id(int staff_Id) {
        this.staff_Id = Staff.getStaffId();
    }

    public static int getPaymentId() {
        return paymentId;
    }

    public static void setPaymentId(int paymentId) {
        Payment.paymentId = paymentId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Timestamp getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Timestamp paymentDate) {
        this.paymentDate = paymentDate;
    }

    public static Payment extractPaymentFromResultSet(ResultSet rs) {
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

    public static Payment viewPaymentDetails() {
        Payment payment = new Payment();
        try{
            Connection conn = connect();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM payment WHERE paymentId=?");
            ps.setInt(1, Payment.paymentId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return extractPaymentFromResultSet(rs);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return payment;
    }

    public int payFilm(int amount) {
        if (!(filmTitle == Film.getTitle())) {
            System.out.println("Oops... Film is not currently available.");
            System.out.println("Kindly select a different film.");
        } else {
            amount = ((Film.getRentalRate()) * (Film.getRentalDuration()));
            System.out.println("Total amount is: "+amount);
        }
        return amount;
    }

    public int payReplacement(int amount) {
        System.out.println("Total amount is: "+Film.getReplacementCost());
        amount = Film.getReplacementCost();
        return amount;
    }
}
