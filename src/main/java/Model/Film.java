package Model;

import java.sql.*;

import static Connection.ConnectionDb.connect;

public class Film {
    private int language_Id;
    public static int filmId;
    private static String title;
    private static int rentalDuration;
    private static int rentalRate;
    private String description;
    private int releaseYear;
    private int length;
    private static int replacementCost;
    private int rating;
    private Timestamp lastUpdate;
    private String specialFeatures;
    private String fullText;

    public static int getFilmId() {
        return filmId;
    }

    public void setFilmId() {this.filmId = filmId;}

    public static String getTitle() {
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

    public static int getRentalDuration() {
        return rentalDuration;
    }

    public void setRentalDuration(int rentalDuration) {
        this.rentalDuration = rentalDuration;
    }

    public static int getRentalRate() {
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

    public static int getReplacementCost() {
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

    public static Film viewFilmDetails() {
        Film film = new Film();
        try{
            Connection conn = connect();
            PreparedStatement ps = conn.prepareStatement("SELECT FROM film WHERE filmId=?");
            ps.setInt(1, Film.filmId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return extractFilmFromResultSet(rs);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return film;
    }

    public static Film extractFilmFromResultSet(ResultSet rs) {
        Film film = new Film();
        try {
            film.setTitle(rs.getString("title"));
            film.setDescription(rs.getString("description"));
            film.setReleaseYear(rs.getInt("releaseYear"));
            film.setRentalDuration(rs.getInt("rentalDuration"));
            film.setRentalRate(rs.getInt("rentalRate"));
            film.setLength(rs.getInt("length"));
            film.setReplacementCost(rs.getInt("replacementCost"));
            film.setRating(rs.getInt("rating"));
            film.setSpecialFeatures(rs.getString("specialFeatures"));
            film.setFullText(rs.getString("fullTxt"));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return film;
    }
}
