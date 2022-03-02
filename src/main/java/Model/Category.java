package Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor

public class Category {
    private static int categoryId;
    private String nameOfCategory;
    private Timestamp lastUpdate;

    public Category(String nameOfCategory, Timestamp lastUpdate) {
        this.nameOfCategory = nameOfCategory;
        this.lastUpdate = lastUpdate;
    }
}
