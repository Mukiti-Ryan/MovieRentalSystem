package Model;

import java.sql.*;

import static Connection.ConnectionDb.connect;

public class Inventory {
    public static int film_Id;
    private static int inventoryId;
    private Timestamp lastUpdate;

    public static int getFilm_Id() {
        return film_Id;
    }

    public void setFilm_Id(int film_Id) {
        this.film_Id = film_Id;
    }

    public static int getInventoryId() {
        return inventoryId;
    }

    public static void setInventoryId(int inventoryId) {
        Inventory.inventoryId = inventoryId;
    }

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public static Inventory extractInventoryFromResultSet(ResultSet rs) {
        Inventory inventory = new Inventory();
        try {
            inventory.setInventoryId(rs.getInt("inventoryId"));
            inventory.setFilm_Id(rs.getInt("customerId"));
            inventory.setLastUpdate(rs.getTimestamp("lastUpdate"));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return inventory;
    }

    public static Inventory viewInventoryDetails() {
        Inventory inventory = new Inventory();
        try{
            Connection conn = connect();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM inventory WHERE film_Id=?");
            ps.setInt(1, Inventory.film_Id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return extractInventoryFromResultSet(rs);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return inventory;
    }
}
