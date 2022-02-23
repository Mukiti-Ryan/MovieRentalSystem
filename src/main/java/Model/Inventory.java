package Model;

import java.sql.*;

public class Inventory {
    private int film_Id;
    private int inventoryId;
    private Timestamp lastUpdate;

    public int getFilm_Id() {
        return film_Id;
    }

    public void setFilm_Id(int film_Id) {
        this.film_Id = film_Id;
    }

    public int getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(int inventoryId) {
        this.inventoryId = inventoryId;
    }

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

}
