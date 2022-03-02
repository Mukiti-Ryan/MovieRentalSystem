package Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.sql.*;

@Getter
@Setter
@NoArgsConstructor
public class Inventory {
    private int film_Id;
    private int inventoryId;
    private Timestamp lastUpdate;
}
