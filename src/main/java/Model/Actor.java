package Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.sql.Timestamp;

@Setter
@Getter
@NoArgsConstructor
public class Actor {
    private static int actorId;
    private String firstName;
    private String lastName;
    private Timestamp lastUpdate;
}
