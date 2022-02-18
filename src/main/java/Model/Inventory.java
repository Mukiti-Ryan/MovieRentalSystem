package Model;

import java.sql.Timestamp;

public class Inventory {
    private int film_Id;
    private static int inventory_id;
    private Timestamp lastUpdate;

    public Inventory(int film_Id, Timestamp lastUpdate) {
        this.film_Id = Film.getFilmId();
        this.lastUpdate = lastUpdate;
    }

    public static int getInventory_id() {
        return inventory_id;
    }
}
