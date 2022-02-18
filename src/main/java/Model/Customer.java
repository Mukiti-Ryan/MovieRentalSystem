package Model;

import java.sql.Timestamp;

public class Customer {
    private int address_Id;
    private static int customerId;
    private String firstName;
    private String lastName;
    private String email;
    private Timestamp dateCreated;
    private Timestamp lastUpdate;

    public Customer(int address_Id, String firstName, String lastName, String email, Timestamp dateCreated, Timestamp lastUpdate) {
        this.address_Id = Address.getAddressId();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dateCreated = dateCreated;
        this.lastUpdate = lastUpdate;
    }

    public static int getCustomerId() {
        return customerId;
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

    public Timestamp getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Timestamp dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
