package Services;

import Model.*;

import java.sql.*;
import java.util.Scanner;
import static Connection.ConnectionDb.connect;

public class Account{
    static Scanner sc = new Scanner(System.in);
    public static int filmOption;

    public Staff login() {
        System.out.println("Please enter your username and password to login.");
        System.out.println("Enter your username");
        String userName = sc.next();
        System.out.println("Enter your password");
        String password = sc.next();

        try {
            Connection conn = connect();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM staff WHERE userName=? AND password=?");
            ps.setString(1, userName);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            if (rs.next()){
                return extractStaffFromResultSet(rs);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public Staff extractStaffFromResultSet(ResultSet rs) {
        Staff staff = new Staff();
        try {
            staff.setStaffId(rs.getInt("staffId"));
            staff.setFirstName(rs.getString("firstName"));
            staff.setLastName(rs.getString("lastName"));
            staff.setEmail(rs.getString("email"));
            staff.setUserName(rs.getString("userName"));
            staff.setPassword(rs.getString("password"));
            staff.setLastUpdate(rs.getTimestamp("lastUpdate"));
            staff.setPictureUrl(rs.getString("pictureUrl"));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return staff;
    }

    public Customer reactivateCustomer() {
        System.out.println("Enter the email of the customer: ");
        System.out.println(" ");
        String email = sc.next();
        try{
            Connection conn = connect();
            PreparedStatement ps = conn.prepareStatement("UPDATE customer SET ACTIVE = 1 WHERE email=?");
            ps.setString(1, email);
            ps.executeUpdate();

            return extractCustomerFromResultSet();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public Customer deactivateCustomer() {
        System.out.println("Enter the email of the customer: ");
        System.out.println(" ");
        String email = sc.next();
        try{
            Connection conn = connect();
            PreparedStatement ps = conn.prepareStatement("UPDATE customer SET ACTIVE = 0 WHERE email=?");
            ps.setString(1, email);
            ps.executeUpdate();

            return extractCustomerFromResultSet();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    private Customer extractCustomerFromResultSet() {
        System.out.println("Enter the email of the customer: ");
        System.out.println(" ");
        String email = sc.next();
        try{
            Connection conn = connect();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM customer WHERE email=?");
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();

            if (rs.next()){
                return extractCustomerFromResultSet(rs);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public Customer viewCustomerDetails() {
        System.out.println("Enter the email of the customer: ");
        System.out.println(" ");
        String email = sc.next();
        try{
            Connection conn = connect();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM customer WHERE email=?");
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();

            if (rs.next()){
                return extractCustomerFromResultSet(rs);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public Customer extractCustomerFromResultSet(ResultSet rs) {
        Customer customer = new Customer();
        try {
            customer.setCustomerId(rs.getInt("customerId"));
            customer.setFirstName(rs.getString("firstName"));
            customer.setLastName(rs.getString("lastName"));
            customer.setEmail(rs.getString("email"));
            customer.setActive(rs.getBoolean("active"));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return customer;
    }

    public Inventory viewInventoryDetails() {
        System.out.println("Enter the inventory id of the film");
        System.out.println(" ");
        int inventoryId = sc.nextInt();
        try{
            Connection conn = connect();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM inventory WHERE inventoryId=?");
            ps.setInt(1, inventoryId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return extractInventoryFromResultSet(rs);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public Inventory extractInventoryFromResultSet(ResultSet rs) {
        Inventory inventory = new Inventory();
        try {
            inventory.setInventoryId(rs.getInt("inventoryId"));
            inventory.setFilm_Id(rs.getInt("film_Id"));
            inventory.setLastUpdate(rs.getTimestamp("lastUpdate"));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return inventory;
    }

    public Film viewFilmDetails() {
        Film film = new Film();
        displayFilmMenu();

        switch (filmOption) {
            case 1:
                System.out.println("Enter the film id: ");
                System.out.println(" ");
                int filmId = sc.nextInt();
                try {
                    Connection conn = connect();
                    PreparedStatement ps = conn.prepareStatement("SELECT * FROM film WHERE filmId=?");
                    ps.setInt(1, filmId);
                    ResultSet rs = ps.executeQuery();

                    if (rs.next()){
                        return extractFilmFromResultSet(rs);
                    }
                } catch (SQLException ex){
                    ex.printStackTrace();
                }
                break;
            case 2:
                System.out.println("Enter the title of the film: ");
                System.out.println(" ");
                String title = sc.next();
                try {
                    Connection conn = connect();
                    PreparedStatement ps = conn.prepareStatement("SELECT * FROM film WHERE title=?");
                    ps.setString(1, title);
                    ResultSet rs = ps.executeQuery();

                    if (rs.next()){
                        return extractFilmFromResultSet(rs);
                    }
                } catch (SQLException ex){
                    ex.printStackTrace();
                }
                break;
            case 3:
                System.out.println("Enter the year of release of the film: ");
                System.out.println(" ");
                int releaseYear = sc.nextInt();
                try {
                    Connection conn = connect();
                    PreparedStatement ps = conn.prepareStatement("SELECT * FROM film WHERE releaseYear=?");
                    ps.setInt(1, releaseYear);
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()){
                        film.setTitle(rs.getString("title"));
                        film.setReleaseYear(rs.getInt("releaseYear"));
                        film.setRentalDuration(rs.getInt("rentalDuration"));
                        film.setRentalRate(rs.getInt("rentalRate"));
                        film.setLength(rs.getInt("length"));
                        film.setReplacementCost(rs.getInt("replacementCost"));
                        film.setRating(rs.getInt("rating"));

                        System.out.println("The film details are as follows");
                        System.out.println("Film Title: "+film.getTitle());
                        System.out.println("Film Release Year: "+film.getReleaseYear());
                        System.out.println("Film Rental Duration: "+film.getRentalDuration());
                        System.out.println("Film Rental Rate: "+film.getRentalRate());
                        System.out.println("Film Length: "+film.getLength());
                        System.out.println("Film Replacement Cost: "+film.getReplacementCost());
                        System.out.println("Film Rating: "+film.getRating());
                    }
                } catch (SQLException ex){
                    ex.printStackTrace();
                }
                break;
            case 4:
                System.out.println("Enter the rating of the film: ");
                System.out.println(" ");
                int rating = sc.nextInt();
                try {
                    Connection conn = connect();
                    PreparedStatement ps = conn.prepareStatement("SELECT * FROM film WHERE rating=?");
                    ps.setInt(1, rating);
                    ResultSet rs = ps.executeQuery();

                    while (rs.next()){
                        film.setTitle(rs.getString("title"));
                        film.setReleaseYear(rs.getInt("releaseYear"));
                        film.setRentalDuration(rs.getInt("rentalDuration"));
                        film.setRentalRate(rs.getInt("rentalRate"));
                        film.setLength(rs.getInt("length"));
                        film.setReplacementCost(rs.getInt("replacementCost"));
                        film.setRating(rs.getInt("rating"));

                        System.out.println("The film details are as follows");
                        System.out.println("Film Title: "+film.getTitle());
                        System.out.println("Film Release Year: "+film.getReleaseYear());
                        System.out.println("Film Rental Duration: "+film.getRentalDuration());
                        System.out.println("Film Rental Rate: "+film.getRentalRate());
                        System.out.println("Film Length: "+film.getLength());
                        System.out.println("Film Replacement Cost: "+film.getReplacementCost());
                        System.out.println("Film Rating: "+film.getRating());;
                    }
                } catch (SQLException ex){
                    ex.printStackTrace();
                }
                break;
            case 5:
                System.out.println("Enter the length of the film: ");
                System.out.println(" ");
                int length = sc.nextInt();
                try {
                    Connection conn = connect();
                    PreparedStatement ps = conn.prepareStatement("SELECT * FROM film WHERE length=?");
                    ps.setInt(1, length);
                    ResultSet rs = ps.executeQuery();

                    while (rs.next()){
                        film.setTitle(rs.getString("title"));
                        film.setReleaseYear(rs.getInt("releaseYear"));
                        film.setRentalDuration(rs.getInt("rentalDuration"));
                        film.setRentalRate(rs.getInt("rentalRate"));
                        film.setLength(rs.getInt("length"));
                        film.setReplacementCost(rs.getInt("replacementCost"));
                        film.setRating(rs.getInt("rating"));

                        System.out.println("The film details are as follows");
                        System.out.println("Film Title: "+film.getTitle());
                        System.out.println("Film Release Year: "+film.getReleaseYear());
                        System.out.println("Film Rental Duration: "+film.getRentalDuration());
                        System.out.println("Film Rental Rate: "+film.getRentalRate());
                        System.out.println("Film Length: "+film.getLength());
                        System.out.println("Film Replacement Cost: "+film.getReplacementCost());
                        System.out.println("Film Rating: "+film.getRating());;
                    }
                } catch (SQLException ex){
                    ex.printStackTrace();
                }
                break;
            case 6:
                Category category = new Category();
                System.out.println("Enter the category of the film: ");
                System.out.println(" ");
                String nameOfCategory = sc.next();
                try {
                    Connection conn = connect();
                    PreparedStatement ps = conn.prepareStatement("SELECT film.title, film.rating, film.rentalDuration, film.rentalRate ,category.nameofCategory\n" +
                            "FROM ((film_category\n" +
                            "INNER JOIN film ON film_category.film_Id = film.filmId)\n" +
                            "INNER JOIN category ON film_category.category_Id = categoryId)\n" +
                            "where nameOfCategory=?");
                    ps.setString(1, nameOfCategory);
                    ResultSet rs = ps.executeQuery();

                    while (rs.next()) {
                        film.setTitle(rs.getString("title"));
                        film.setRentalDuration(rs.getInt("rentalDuration"));
                        film.setRentalRate(rs.getInt("rentalRate"));
                        film.setRating(rs.getInt("rating"));
                        category.setNameOfCategory(rs.getString("nameOfCategory"));

                        System.out.println("The film details are as follows");
                        System.out.println("Film Title: "+film.getTitle());
                        System.out.println("Film Rental Duration: " +film.getRentalDuration());
                        System.out.println("Film Rental Rate: "+film.getRentalRate());
                        System.out.println("Film Rating: "+film.getRating());
                        System.out.println("Film Category: "+category.getNameOfCategory());
                    }
                } catch (SQLException ex){
                    ex.printStackTrace();
                }
                break;
            case 7:
                Actor actor = new Actor();
                System.out.println("Enter the first name of the actor/actress: ");
                String firstName = sc.next();
                System.out.println("Enter the last name of the actor/actress: ");
                String lastName = sc.next();
                System.out.println(" ");
                try {
                    Connection conn = connect();
                    PreparedStatement ps = conn.prepareStatement("SELECT film.title, film.rating, film.rentalDuration, film.rentalRate, actor.firstName, actor.lastName\n" +
                            "FROM ((film_actor\n" +
                            "INNER JOIN film ON film_actor.film_Id = film.filmId)\n" +
                            "INNER JOIN actor ON film_actor.actor_Id = actorId)\n" +
                            "where actor.firstName=? and actor.lastName=?");
                    ps.setString(1, firstName);
                    ps.setString(2, lastName);
                    ResultSet rs = ps.executeQuery();

                    while (rs.next()) {
                        film.setTitle(rs.getString("title"));
                        film.setRentalDuration(rs.getInt("rentalDuration"));
                        film.setRentalRate(rs.getInt("rentalRate"));
                        film.setRating(rs.getInt("rating"));
                        actor.setFirstName(rs.getString("firstName"));
                        actor.setLastName(rs.getString("lastName"));

                        System.out.println("The film details are as follows");
                        System.out.println("Film Title: "+film.getTitle());
                        System.out.println("Film Rental Duration: " +film.getRentalDuration());
                        System.out.println("Film Rental Rate: "+film.getRentalRate());
                        System.out.println("Film Rating: "+film.getRating());
                        System.out.println("Film Actor/Actress First Name: "+actor.getFirstName());
                        System.out.println("Film Actor/Actress Last Name: "+actor.getLastName());
                    }
                } catch (SQLException ex){
                    ex.printStackTrace();
                }
                break;
            default:
                System.out.println("Film could not be found!!! Try again.");
                break;
        }
        return null;
    }

    public Film extractFilmFromResultSet(ResultSet rs) {
        Film film = new Film();
        try {
            film.setTitle(rs.getString("title"));
            film.setReleaseYear(rs.getInt("releaseYear"));
            film.setRentalDuration(rs.getInt("rentalDuration"));
            film.setRentalRate(rs.getInt("rentalRate"));
            film.setLength(rs.getInt("length"));
            film.setReplacementCost(rs.getInt("replacementCost"));
            film.setRating(rs.getInt("rating"));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return film;
    }

    public Rental viewRentalDetails() {
        System.out.println("Enter the inventoryId: ");
        System.out.println(" ");
        int inventory_Id = sc.nextInt();
        try{
            Connection conn = connect();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM rental WHERE inventory_Id=?");
            ps.setInt(1, inventory_Id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return extractRentalFromResultSet(rs);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public Rental extractRentalFromResultSet(ResultSet rs) {
        Rental rental = new Rental();
        try {
            rental.setStaff_Id(rs.getInt("staff_Id"));
            rental.setCustomer_Id(rs.getInt("customer_Id"));
            rental.setInventory_Id(rs.getInt("inventory_Id"));
            rental.setRentalDate(rs.getTimestamp("rentalDate"));
            rental.setReturnDate(rs.getTimestamp("returnDate"));
            rental.setLastUpdate(rs.getTimestamp("lastUpdate"));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return rental;
    }

    public Payment viewPaymentDetails() {
        System.out.println("Enter the amount paid by the customer: ");
        System.out.println(" ");
        double amount = sc.nextDouble();
        try{
            Connection conn = connect();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM payment WHERE amount=?");
            ps.setDouble(1, amount);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return extractPaymentFromResultSet(rs);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public Payment extractPaymentFromResultSet(ResultSet rs) {
        Payment payment = new Payment();
        try {
            payment.setRental_Id(rs.getInt("rental_Id"));
            payment.setCustomer_Id(rs.getInt("customer_Id"));
            payment.setStaff_Id(rs.getInt("staff_Id"));
            payment.setAmount(rs.getInt("amount"));
            payment.setPaymentDate(rs.getTimestamp("paymentDate"));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return payment;
    }

    public static void displayFilmMenu() {
        System.out.println("Choose an option below: ");
        System.out.println("Press 1 to search for film by filmId: ");
        System.out.println("Press 2 to search for film by title: ");
        System.out.println("Press 3 to search for film by year of release: ");
        System.out.println("Press 4 to search for film by rating: ");
        System.out.println("Press 5 to search for film by length: ");
        System.out.println("Press 6 to search film by category");
        System.out.println("Press 7 to search film by actor/actress name");
        System.out.println(" ");
        filmOption = sc.nextInt();
    }
}

