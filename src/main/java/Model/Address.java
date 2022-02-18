package Model;

import java.sql.Timestamp;

public class Address {
    private static int addressId;
    private int city_Id;
    private String address;
    private int district;
    private String postalCode;
    private String phoneNumber;
    private Timestamp lastUpdate;

    public Address(int city_Id, String address, int district, String postalCode, String phoneNumber, Timestamp lastUpdate) {
        this.city_Id = City.getCityId();
        this.address = address;
        this.district = district;
        this.postalCode = postalCode;
        this.phoneNumber = phoneNumber;
        this.lastUpdate = lastUpdate;
    }
    public static int getAddressId() {
        return addressId;
    }
}
