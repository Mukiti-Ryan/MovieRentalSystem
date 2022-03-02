package Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
public class City {
    private int country_Id;
    private static int cityId;
    private String nameOfCity;
    private Timestamp lastUpdate;
}
