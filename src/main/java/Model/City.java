package Model;

import java.sql.Timestamp;

public class City {
    private int country_Id;
    private static int cityId;
    private String nameOfCity;
    private Timestamp lastUpdate;

    public City(int country_Id, String nameOfCity, Timestamp lastUpdate) {
        this.country_Id = Country.getCountryId();
        this.nameOfCity = nameOfCity;
        this.lastUpdate = lastUpdate;
    }

    public static int getCityId() {
        return cityId;
    }

    public String getNameOfCity() {
        return nameOfCity;
    }

    public void setNameOfCity(String nameOfCity) {
        this.nameOfCity = nameOfCity;
    }

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
