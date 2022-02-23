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

    public static int getAddressId() {
        return addressId;
    }

    public static void setAddressId(int addressId) {
        Address.addressId = addressId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getDistrict() {
        return district;
    }

    public void setDistrict(int district) {
        this.district = district;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public int getCity_Id() {
        return city_Id;
    }

    public void setCity_Id(int city_Id) {
        this.city_Id = City.getCityId();
    }
}
