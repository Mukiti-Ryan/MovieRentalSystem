package Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
public class Language {
    private static int languageId;
    private String languageName;
    private Timestamp lastUpdate;

    public Language(String languageName, Timestamp lastUpdate) {
        this.languageName = languageName;
        this.lastUpdate = lastUpdate;
    }
}
