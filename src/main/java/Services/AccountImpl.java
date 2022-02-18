package Services;

import java.util.Scanner;

public class AccountImpl implements Account{
    Scanner sc = new Scanner(System.in);

    @Override
    public boolean login() {
        System.out.println("Please enter your username and password to login.");
        System.out.println("Enter your username: ");
        String username = sc.next();
        if (username == username){

        }
        int counter = 0;
        while (counter < 4){
            if (counter == 3) throw new IllegalStateException("Maximum tries exceeded!");
            System.out.println("Enter your password: ");
            String password = sc.next();
        }
        return true;
    }

    @Override
    public boolean isloggedin() {
        return false;
    }
}
