package Services;

import Model.Customer;
import Model.Inventory;
import Model.Staff;
import java.sql.Timestamp;

public class RentalImpl implements Rental{
    private int staff_Id;
    private int customer_Id;
    private int inventory_Id;
    private static int rentalId;
    private Timestamp rentalDate;
    private Timestamp returnDate;
    private Timestamp lastUpdate;

    public RentalImpl(int staff_Id, int customer_Id, int inventory_Id, Timestamp rentalDate, Timestamp returnDate, Timestamp lastUpdate) {
        this.staff_Id = Staff.getStaffId();
        this.customer_Id = Customer.getCustomerId();
        this.inventory_Id = Inventory.getInventory_id();
        this.rentalDate = rentalDate;
        this.returnDate = returnDate;
        this.lastUpdate = lastUpdate;
    }

    public static int getRentalId() {
        return rentalId;
    }

    @Override
    public java.util.Date returnDate(java.util.Date currentDate) {
        return null;
    }
}
