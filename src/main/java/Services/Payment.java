package Services;

import java.sql.*;

public class Payment {
    private int customer_Id;
    private int staff_Id;
    private int rental_Id;
    private int paymentId;
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
        this.rental_Id = rental_Id;
    }

    public int getCustomer_Id() {
        return customer_Id;
    }

    public void setCustomer_Id(int customer_Id) {
        this.customer_Id = customer_Id;
    }

    public int getStaff_Id() {
        return staff_Id;
    }

    public void setStaff_Id(int staff_Id) {
        this.staff_Id = staff_Id;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
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
}