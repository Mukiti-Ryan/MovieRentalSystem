package Model;

import java.sql.Timestamp;

public class Category {
    private static int categoryId;
    private String nameOfCategory;
    private Timestamp lastUpdate;

    public Category(String nameOfCategory, Timestamp lastUpdate) {
        this.nameOfCategory = nameOfCategory;
        this.lastUpdate = lastUpdate;
    }

    public static int getCategoryId() {
        return categoryId;
    }
}
