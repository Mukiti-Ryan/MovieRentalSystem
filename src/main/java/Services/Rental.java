package Services;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.sql.*;

@Getter
@Setter
@NoArgsConstructor
public class Rental {

    private int staff_Id;
    private int customer_Id;
    private int inventory_Id;
    public int rentalId;
    private Timestamp rentalDate;
    private Timestamp returnDate;
    private Timestamp lastUpdate;

}
