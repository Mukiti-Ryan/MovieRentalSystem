package Services;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.sql.*;

@Getter
@Setter
@NoArgsConstructor
public class Payment {
    private int customer_Id;
    private int staff_Id;
    private int rental_Id;
    private int paymentId;
    private int amount;
    private Timestamp paymentDate;
    private String filmTitle;
}