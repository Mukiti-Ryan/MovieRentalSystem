package Model;

import Services.Payment;

import java.sql.Timestamp;

public class Staff {
    private int store_Id;
    private int payment_Id;
    private int address_Id;
    private static int staffId;
    public static String userName;
    public static String password;
    private String firstName;
    private String lastName;
    private String email;
    private String active;
    private Timestamp lastUpdate;
    private String pictureUrl;

    public Staff(int store_Id, int payment_Id, int address_Id, String firstName, String lastName, String email, String active, String userName, String password, Timestamp lastUpdate, String pictureUrl) {
        this.store_Id = Store.getStoreId();
        this.payment_Id = Payment.getPaymentId();
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

    public Staff() {

    }

    public static int getStaffId() {
        return staffId;
    }

    public static void setStaffId(int staffId) {
        Staff.staffId = staffId;
    }

    public static String getUserName() {
        return userName;
    }

    public static void setUserName(String userName) {
        Staff.userName = userName;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        Staff.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }
}
