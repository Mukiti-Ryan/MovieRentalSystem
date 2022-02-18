package Model;

import java.sql.Timestamp;

public class FilmActor {
    private int film_Id;
    private int actor_id;
    private Timestamp lastUpdate;

    public FilmActor(int film_id, int actor_id, Timestamp lastUpdate) {
        this.film_Id = Film.getFilmId();
        this.actor_id = actor_id;
        this.lastUpdate = lastUpdate;
    }
}
