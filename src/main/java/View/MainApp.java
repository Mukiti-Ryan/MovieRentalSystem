package View;

import Model.Customer;
import Model.Film;
import Model.Inventory;
import Model.Staff;
import Services.Account;
import Services.Payment;
import Services.Rental;
import java.util.Scanner;

public class MainApp {
    static int selectedOption;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("*** MOVIE RENTAL SYSTEM ***");

        Account account = new Account();
        Staff staff = account.login();
        if (staff.getUserName() == null) {
            System.out.println("No staff with provided username is found");
        } else if (staff.isActive()) {
            System.out.println("Staff account is inactive");
        }
        System.out.println(" ");
        System.out.println("The user "+staff.getUserName()+" is authenticated!!!");
        System.out.println(" ");
        displayMainMenu();

            switch (selectedOption) {
                case 1:
                    try {
                        Customer customer = account.viewCustomerDetails();
                        if (customer.getEmail() == null) {
                            throw new IllegalStateException("No customer with provided email is found!");
                        } else if (!customer.isActive()) {
                            throw new IllegalStateException("Customer account "+customer.getFirstName()+" "+customer.getLastName()+ " is inactive!");
                        } else
                        System.out.println("Would you like to reactivate it?? [1 for yes/2 for no]");
                        int reactivateOption = sc.nextInt();
                        if (reactivateOption == 1){
                            account.reactivateCustomer();
                        }

                        System.out.println("Customer account "+customer.getFirstName()+" "+customer.getLastName() + " is active");
                    } catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    Inventory inventory = account.viewInventoryDetails();
                    if (inventory.getInventoryId() >=501) {
                        System.out.println("Inventory id does not exist");
                    }
                    System.out.println("Inventory number "+inventory.getInventoryId()+" is available" );
                    break;
                case 3:
                    Film film = account.viewFilmDetails();
                    if (Account.filmOption == 1 || Account.filmOption == 2) {
                        System.out.println("The film details are as follows");
                        System.out.println("Film Title: "+film.getTitle());
                        System.out.println("Film Release Year: "+film.getReleaseYear());
                        System.out.println("Film Rental Duration: "+film.getRentalDuration());
                        System.out.println("Film Rental Rate: "+film.getRentalRate());
                        System.out.println("Film Length: "+film.getLength());
                        System.out.println("Film Replacement Cost: "+film.getReplacementCost());
                        System.out.println("Film Rating: "+film.getRating());
                    }
                    break;
                case 4:
                    Rental rental = account.viewRentalDetails();
                    System.out.println("The rental details are as follows: ");
                    System.out.println("Rental Id: "+rental.getRentalId());
                    System.out.println("Rental Date: "+rental.getRentalDate());
                    System.out.println("Return Date: "+rental.getReturnDate());
                    break;
                case 5:
                    Payment payment = account.viewPaymentDetails();
                    System.out.println("The payment details are as follows: ");
                    System.out.println("Payment Amount: "+payment.getAmount());
                    System.out.println("Payment Date: "+payment.getPaymentDate());
                    break;
                case 6:
                    Film filmRental = account.viewFilmDetails();
                    System.out.println("The film to be rented is: "+filmRental.getTitle());
                    System.out.println("The total amount is: "+filmRental.FilmPayment());
                    break;
                default:
                    System.out.println("Transaction has ended");
                    System.out.println("Thank you for using Visual Movie Rental System");
                    System.exit(0);
                    break;
            }
        }

    public static void displayMainMenu() {
        System.out.println("Please select an option below");
        System.out.println("Press 1 to view customer details");
        System.out.println("Press 2 to view inventory details");
        System.out.println("Press 3 to view film details");
        System.out.println("Press 4 to view rental details");
        System.out.println("Press 5 to view payment details");
        System.out.println("Press 6 to rent a film");
        System.out.println(" ");
        selectedOption = sc.nextInt();
    }
}