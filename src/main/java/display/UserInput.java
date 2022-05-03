package display;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInput {
    public Scanner scanner = new Scanner(System.in);

    public int askInput(String input) {
        int number = 0;
        // based on the arguments we will choose what to tell the user
        boolean chooseInput = input.equals("months");
        try {
            System.out.println("choose how many " + (chooseInput ?
                "months you want to simulate": "centres you want to open every 2 months"));
            number = scanner.nextInt();
            boolean rightInput = false;

            while(!rightInput) {
                // months needs to be > 0 centres > 0 && <= 2
                if((input.equals("months") ? number > 0: number > 0 && number <= 2)) {
                    return number;
                } else {
                    System.out.println("you need to enter a number > 0 " +
                            (input.equals("months") ? "": "and <= 2"));
                }
                System.out.println("choose how many " + (input.equals("months") ?
                        "months you want to simulate": "centres you want to open every 2 months"));
                number = scanner.nextInt();
            }
        } catch (InputMismatchException e) {
            e.printStackTrace();
        }
        return number;
    }
}
