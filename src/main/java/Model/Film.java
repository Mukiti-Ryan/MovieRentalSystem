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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public int getRentalDuration() {
        return rentalDuration;
    }

    public void setRentalDuration(int rentalDuration) {
        this.rentalDuration = rentalDuration;
    }

    public int getRentalRate() {
        return rentalRate;
    }

    public void setRentalRate(int rentalRate) {
        this.rentalRate = rentalRate;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getReplacementCost() {
        return replacementCost;
    }

    public void setReplacementCost(int replacementCost) {
        this.replacementCost = replacementCost;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public String getSpecialFeatures() {
        return specialFeatures;
    }

    public void setSpecialFeatures(String specialFeatures) {
        this.specialFeatures = specialFeatures;
    }

    public String getFullText() {
        return fullText;
    }

    public void setFullText(String fullText) {
        this.fullText = fullText;
    }
}
