package View;

import Model.Customer;
import Model.Film;
import Model.Inventory;
import Model.Staff;
import Services.AccountImpl;
import Services.Payment;
import Services.Rental;
import java.util.Scanner;

public class MainApp {
    static int selectedOption;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("*** MOVIE RENTAL SYSTEM ***");

        Staff staff = new Staff();
        AccountImpl account = new AccountImpl();
        if (!account.isloggedin()){
            account.login();
        }
        do {
            if (!account.isloggedin()) {
                account.login();
            }

            displayMainMenu();

            switch (selectedOption) {
                case 1:
                    Customer.viewCustomerDetails();
                    break;
                case 2:
                    Inventory.viewInventoryDetails();
                    break;
                case 3:
                    Film.viewFilmDetails();
                    break;
                case 4:
                    Rental.viewRentalDetails();
                    break;
                case 5:
                    Payment.viewPaymentDetails();
                    break;
                case 6:
                    Rental.rentFilm();
                    break;
                case 7:
                    break;
                default:
                    break;
            }
        }while (true);
    }

    public static void displayMainMenu() {
        System.out.println("Please select an option below");
        System.out.println("Press 1 to view customer details");
        System.out.println("Press 2 to view inventory details");
        System.out.println("Press 3 to view film details");
        System.out.println("Press 4 to view rental details");
        System.out.println("Press 5 to view payment details");
        System.out.println("Press 6 to rent a film");
        System.out.println("Press 7 to logout");
        selectedOption = sc.nextInt();
    }

}