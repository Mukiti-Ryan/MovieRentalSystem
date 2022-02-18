package Model;

import java.sql.Timestamp;

public class Film {
    private int language_Id;
    public static int filmId;
    private String title;
    private String description;
    private int releaseYear;
    private int rentalDuration;
    private int rentalRate;
    private int length;
    private int replacementCost;
    private int rating;
    private Timestamp lastUpdate;
    private String specialFeatures;
    private String fullText;

    public Film(int language_Id, String title, String description, int releaseYear, int rentalDuration, int rentalRate, int length, int replacementCost, int rating, Timestamp lastUpdate, String specialFeatures, String fullText) {
        this.language_Id = Language.getLanguageId();
        this.title = title;
        this.description = description;
        this.releaseYear = releaseYear;
        this.rentalDuration = rentalDuration;
        this.rentalRate = rentalRate;
        this.length = length;
        this.replacementCost = replacementCost;
        this.rating = rating;
        this.lastUpdate = lastUpdate;
        this.specialFeatures = specialFeatures;
        this.fullText = fullText;
    }

    public static int getFilmId() {
        return filmId;
    }
}
