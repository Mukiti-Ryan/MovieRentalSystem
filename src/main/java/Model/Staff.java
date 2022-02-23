package Model;

import Services.Payment;
import java.sql.Timestamp;

public class Staff {
    private int store_Id;
    private int payment_Id;
    private int address_Id;
    private int staffId;
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private boolean active;
    private Timestamp lastUpdate;
    private String pictureUrl;

    public Staff() {
    }

    public Staff(int store_Id, int payment_Id, int address_Id, int staffId, String userName, String password, String firstName, String lastName, String email, boolean active, Timestamp lastUpdate, String pictureUrl) {
        this.store_Id = store_Id;
        this.payment_Id = payment_Id;
        this.address_Id = address_Id;
        this.staffId = staffId;
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.active = active;
        this.lastUpdate = lastUpdate;
        this.pictureUrl = pictureUrl;
    }

    public Staff(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public int getStore_Id() {
        return store_Id;
    }

    public void setStore_Id(int store_Id) {
        this.store_Id = Store.getStoreId();
    }

    public int getPayment_Id() {
        return payment_Id;
    }

    public void setPayment_Id(int payment_Id) {
        this.payment_Id = payment_Id;
    }

    public int getAddress_Id() {
        return address_Id;
    }

    public void setAddress_Id(int address_Id) {
        this.address_Id = Address.getAddressId();
    }
}
