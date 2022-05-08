package display;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInput {
    public Scanner scanner = new Scanner(System.in);

    public int askMonths() {
        int months = 0;
        try {
            System.out.println("Welcome to the sparta simulator" +
                    "\nHow many months would you like to simulate");
            months = scanner.nextInt();
            boolean rightInput = false;

            while(!rightInput) {
                // months needs to be > 0 centres > 0 && <= 2
                if(months > 0) {
                    return months;
                } else {
                    System.out.println("You need to enter a number of months > 0");
                }
                System.out.println("Choose how many months you want to simulate");
                months = scanner.nextInt();
            }
        } catch (InputMismatchException e) {
            e.printStackTrace();
        }
        return months;
    }
}
