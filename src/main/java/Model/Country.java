package Model;

import java.sql.Timestamp;

public class Country {
    private static int countryId;
    private String nameOfCountry;
    private Timestamp lastUpdate;

    public Country(String nameOfCountry, Timestamp lastUpdate) {
        this.nameOfCountry = nameOfCountry;
        this.lastUpdate = lastUpdate;
    }

    public static int getCountryId() {
        return countryId;
    }
}
