package Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.sql.*;

@Setter
@Getter
@NoArgsConstructor
public class Film {
    private int language_Id;
    public int filmId;
    private String title;
    private int rentalDuration;
    private int rentalRate;
    private String description;
    private int releaseYear;
    private int length;
    private int replacementCost;
    private int rating;
    private Timestamp lastUpdate;
    private String specialFeatures;
    private String fullText;
    private int amount;

    public int FilmPayment() {
        amount = getRentalDuration() * getRentalRate();
        return amount;
    }

    public Film(String title, int rentalDuration, int rentalRate, int releaseYear, int length, int replacementCost, int rating) {
        this.title = title;
        this.rentalDuration = rentalDuration;
        this.rentalRate = rentalRate;
        this.releaseYear = releaseYear;
        this.length = length;
        this.replacementCost = replacementCost;
        this.rating = rating;
    }
}
