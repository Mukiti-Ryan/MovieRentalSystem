package Services;

import java.sql.*;

public class Rental {
    private int staff_Id;
    private int customer_Id;
    private int inventory_Id;
    public int rentalId;
    private Timestamp rentalDate;
    private Timestamp returnDate;
    private Timestamp lastUpdate;

    public int getStaff_Id() {
        return staff_Id;
    }

    public void setStaff_Id(int staff_Id) {
        this.staff_Id = staff_Id;
    }

    public int getCustomer_Id() {
        return customer_Id;
    }

    public void setCustomer_Id(int customer_Id) {
        this.customer_Id = customer_Id;
    }

    public int getInventory_Id() {
        return inventory_Id;
    }

    public void setInventory_Id(int inventory_Id) {
        this.inventory_Id = inventory_Id;
    }

    public int getRentalId() {
        return rentalId;
    }

    public void setRentalId(int rentalId) {
        this.rentalId = rentalId;
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
}
