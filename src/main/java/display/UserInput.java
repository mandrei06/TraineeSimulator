package display;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInput {
    public Scanner scanner = new Scanner(System.in);

    public int askMonths() {
        int months = 0;
        try {
            System.out.println("choose how many months you want to simulate");
            months = scanner.nextInt();
            boolean rightInput = false;

            while(!rightInput) {
                if(months > 0) {
                    return months;
                } else {
                    System.out.println("you need to enter a number of months > 0");
                }
                System.out.println("choose how many months you want to simulate");
                months = scanner.nextInt();
            }
        } catch (InputMismatchException e) {
            e.printStackTrace();
        }
        return months;
    }

    public int askHowManyCentre() {
        int centres = 0;
        try {
            System.out.println("choose how many months you want to simulate");
            centres = scanner.nextInt();
            boolean rightInput = false;

            while(!rightInput) {
                if(centres > 0 && centres <= 2) {
                    return centres;
                } else {
                    System.out.println("you need to enter a number of centres > 0");
                }
                System.out.println("choose how many centres you want to open every 2 months");
                centres = scanner.nextInt();
            }
        } catch (InputMismatchException e) {
            e.printStackTrace();
        }
        return centres;
    }
}
