package Model;

import java.sql.Timestamp;

public class Store {
    private int address_Id;
    private static int storeId;
    private String address;
    private Timestamp lastUpdate;

    public Store(int address_Id, String address, Timestamp lastUpdate) {
        this.address_Id = Address.getAddressId();
        this.address = address;
        this.lastUpdate = lastUpdate;
    }

    public static int getStoreId() {
        return storeId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
