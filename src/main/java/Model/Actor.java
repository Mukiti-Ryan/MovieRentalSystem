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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
