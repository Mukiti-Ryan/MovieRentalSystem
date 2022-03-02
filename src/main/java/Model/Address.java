package Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
public class Address {
    private static int addressId;
    private int city_Id;
    private String address;
    private int district;
    private String postalCode;
    private String phoneNumber;
    private Timestamp lastUpdate;
}
