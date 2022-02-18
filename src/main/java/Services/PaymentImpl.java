package Services;

import Model.Customer;
import Model.Staff;
import java.sql.Date;

public class PaymentImpl implements Payment{
    private int customer_Id;
    private int staff_Id;
    private static int paymentId;
    private int amount;
    private Date paymentDate;

    public PaymentImpl(int customer_Id, int staff_Id, int amount, Date paymentDate) {
        this.customer_Id = Customer.getCustomerId();
        this.staff_Id = Staff.getStaffId();
        this.amount = amount;
        this.paymentDate = paymentDate;
    }

    public static int getPaymentId() {
        return paymentId;
    }

    @Override
    public int payFilm(int amount) {
        return 0;
    }
}
