package Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
public class FilmActor {
    private int film_Id;
    private int actor_id;
    private Timestamp lastUpdate;
}
