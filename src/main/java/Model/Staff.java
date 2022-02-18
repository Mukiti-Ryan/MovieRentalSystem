package Model;

import Services.PaymentImpl;

import java.sql.Timestamp;

public class Staff {
    private int store_Id;
    private int payment_Id;
    private int address_Id;
    private static int staffId;
    private String firstName;
    private String lastName;
    private String email;
    private String active;
    private String userName;
    private String password;
    private Timestamp lastUpdate;
    private String pictureUrl;

    public Staff(int store_Id, int payment_Id, int address_Id, String firstName, String lastName, String email, String active, String userName, String password, Timestamp lastUpdate, String pictureUrl) {
        this.store_Id = Store.getStoreId();
        this.payment_Id = PaymentImpl.getPaymentId();
        this.address_Id = Address.getAddressId();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.active = active;
        this.userName = userName;
        this.password = password;
        this.lastUpdate = lastUpdate;
        this.pictureUrl = pictureUrl;
    }

    public static int getStaffId() {
        return staffId;
    }
}
