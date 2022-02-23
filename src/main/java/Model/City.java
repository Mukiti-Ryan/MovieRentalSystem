package Model;

import java.sql.Timestamp;

public class City {
    private int country_Id;
    private static int cityId;
    private String nameOfCity;
    private Timestamp lastUpdate;

    public static int getCityId() {
        return cityId;
    }

    public static void setCityId(int cityId) {
        City.cityId = cityId;
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

    public int getCountry_Id() {
        return country_Id;
    }

    public void setCountry_Id(int country_Id) {
        this.country_Id = Country.getCountryId();
    }
}
