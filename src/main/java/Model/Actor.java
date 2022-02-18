package Model;

import java.sql.Timestamp;

public class Actor {
    private static int actorId;
    private String firstName;
    private String lastName;
    private Timestamp lastUpdate;

    public Actor(String firstName, String lastName, Timestamp lastUpdate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.lastUpdate = lastUpdate;
    }

    public static int getActorId() {
        return actorId;
    }
}
