package display;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TraineeDisplay {


    public static void tranieeDisplay(int month, int openCenters, int bootCamp, int techCenter, int trainingHub, /*int fullCenters, int numberOfTrainees,*/ int list, int bench) {

        System.out.println("\n\nAt the end of month " + month +
                "\n\nThe total centres opened: " + openCenters +
                "\nNumber of Boot Camps: " + bootCamp +
                "\nNumber of Tech Centers: " + techCenter +
                "\nNumber of Training Hub: " + trainingHub +
                //"\nNumber of full centres: " + fullCenters +
             //   "\nNumber of trainees currently training: " + numberOfTrainees +
                "\nNumber of trainees on the waiting list: " + list +
                "\nNumber of trainees on the bench: " + bench);
    }

    public static boolean monthlyReport() {
        boolean monthlyReport = false;
        int response = 0;
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Would you like a monthly report or do you want to see the end result: " +
                    "\n1:Monthly Report" +
                    "\n2:End Result " +
                    "\nPlease enter a number");
            response = scanner.nextInt();
            boolean rightInput = false;

            while (!rightInput) {
                if (response == 1) {
                    monthlyReport = true;

                } else if (response == 2) {
                    monthlyReport = false;
                } else {
                    monthlyReport();
                }
                return monthlyReport;

            }
        } catch (InputMismatchException e) {
            e.printStackTrace();
        }
        return monthlyReport;
    }
}



