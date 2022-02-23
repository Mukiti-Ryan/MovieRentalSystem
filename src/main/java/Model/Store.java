package Model;

import java.sql.Timestamp;

public class Store {
    private int address_Id;
    private static int storeId;
    private Timestamp lastUpdate;

    public static int getStoreId() {
        return storeId;
    }

    public static void setStoreId(int storeId) {
        Store.storeId = storeId;
    }

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public int getAddress_Id() {
        return address_Id;
    }

    public void setAddress_Id(int address_Id) {
        this.address_Id = Address.getAddressId();
    }
}
