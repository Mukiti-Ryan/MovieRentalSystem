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

    public Category() {
    }

    public static int getCategoryId() {
        return categoryId;
    }

    public static void setCategoryId(int categoryId) {
        Category.categoryId = categoryId;
    }

    public String getNameOfCategory() {
        return nameOfCategory;
    }

    public void setNameOfCategory(String nameOfCategory) {
        this.nameOfCategory = nameOfCategory;
    }

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
