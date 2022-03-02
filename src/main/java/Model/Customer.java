package Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.sql.*;
import java.util.Scanner;

@Getter
@Setter
@NoArgsConstructor

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
}
