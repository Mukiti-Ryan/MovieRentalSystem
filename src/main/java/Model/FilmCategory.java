package Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
public class FilmCategory {
    private int film_Id;
    private int category_Id;
    private Timestamp lastUpdate;
}
