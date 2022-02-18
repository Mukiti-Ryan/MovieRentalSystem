package Model;

import java.sql.Timestamp;

public class Language {
    private static int languageId;
    private String languageName;
    private Timestamp lastUpdate;

    public Language(String languageName, Timestamp lastUpdate) {
        this.languageName = languageName;
        this.lastUpdate = lastUpdate;
    }

    public static int getLanguageId() {
        return languageId;
    }
}
