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
}
