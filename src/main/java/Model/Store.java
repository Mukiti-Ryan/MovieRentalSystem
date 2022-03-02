package Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Setter
@Getter
@NoArgsConstructor
public class Store {
    private int address_Id;
    private static int storeId;
    private Timestamp lastUpdate;
}
