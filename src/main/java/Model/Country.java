package Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
public class Country {
    private static int countryId;
    private String nameOfCountry;
    private Timestamp lastUpdate;

    public Country(String nameOfCountry, Timestamp lastUpdate) {
        this.nameOfCountry = nameOfCountry;
        this.lastUpdate = lastUpdate;
    }
}
