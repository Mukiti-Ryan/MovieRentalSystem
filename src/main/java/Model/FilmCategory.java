package Model;

import java.sql.Timestamp;

public class FilmCategory {
    private int film_Id;
    private int category_Id;
    private Timestamp lastUpdate;

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public int getFilm_Id() {
        return film_Id;
    }

    public void setFilm_Id(int film_Id) {
        this.film_Id = film_Id;
    }

    public int getCategory_Id() {
        return category_Id;
    }

    public void setCategory_Id(int category_Id) {
        this.category_Id = Category.getCategoryId();
    }
}
