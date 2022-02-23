package Model;

import java.sql.Timestamp;

public class Actor {
    private static int actorId;
    private String firstName;
    private String lastName;
    private Timestamp lastUpdate;

    public static int getActorId() {
        return actorId;
    }

    public static void setActorId(int actorId) {
        Actor.actorId = actorId;
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
