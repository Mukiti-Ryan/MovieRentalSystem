package Model;

import java.sql.Timestamp;

public class FilmActor {
    private int film_Id;
    private int actor_id;
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

    public int getActor_id() {
        return actor_id;
    }

    public void setActor_id(int actor_id) {
        this.actor_id = Actor.getActorId();
    }
}
