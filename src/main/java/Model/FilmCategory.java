package Model;

import java.sql.Timestamp;

public class FilmCategory {
    private int film_Id;
    private int category_Id;
    private Timestamp lastUpdate;

    public FilmCategory(int film_id, int actor_id, Timestamp lastUpdate) {
        this.film_Id = Film.getFilmId();
        this.category_Id = Category.getCategoryId();
        this.lastUpdate = lastUpdate;
    }

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
