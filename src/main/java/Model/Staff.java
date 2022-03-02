package Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor

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
}
