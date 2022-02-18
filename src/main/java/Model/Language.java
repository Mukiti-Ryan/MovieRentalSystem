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

    public String getLanguageName() {
        return languageName;
    }

    public void setLanguageName(String languageName) {
        this.languageName = languageName;
    }

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
