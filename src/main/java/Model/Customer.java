package Model;

import java.sql.*;
import java.util.Scanner;

public class Customer {
    static Scanner sc = new Scanner(System.in);
    private int address_Id;
    private int customerId;
    private String firstName;
    private String lastName;
    private String email;
    private boolean active;
    private Timestamp dateCreated;
    private Timestamp lastUpdate;

    public Customer(int address_Id, int customerId, String firstName, String lastName, String email, Timestamp dateCreated, Timestamp lastUpdate) {
        this.address_Id = address_Id;
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dateCreated = dateCreated;
        this.lastUpdate = lastUpdate;
    }

    public Customer() {
    }

    public Customer(String email) {
        this.email = email;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public Timestamp getDateCreated() {
        return dateCreated;
    }

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setCustomerId(int customerId){
        this.customerId = customerId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDateCreated(Timestamp dateCreated) {
        this.dateCreated = dateCreated;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public int getAddress_Id() {
        return address_Id;
    }

    public void setAddress_Id(int address_Id) {
        this.address_Id = Address.getAddressId();
    }
}
