package display;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TraineeDisplay {


    public static void tranieeDisplay(int month, int openCenters, int bootCamp, int techCenter,
                                      int trainingHub, /*int fullCenters, int numberOfTrainees,*/ int list, int bench,
                                      int countHappyClients, int countUnHappyClients) {

        System.out.println("\n\nAt the end of month " + month +
                "\nThe total centres opened: " + openCenters +
                "\nNumber of Boot Camps: " + bootCamp +
                "\nNumber of Tech Centers: " + techCenter +
                "\nNumber of Training Hub: " + trainingHub +
                //"\nNumber of full centres: " + fullCenters +
                //   "\nNumber of trainees currently training: " + numberOfTrainees +
                "\nNumber of trainees on the waiting list: " + list +
                "\nNumber of trainees on the bench: " + bench +
                "\nNumber of Happy Clients: " + countHappyClients +
                "\nNumber of Unhappy Clients" + countUnHappyClients);
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

    public static void NewClinets(int newClients) {
        System.out.println("\nNew client" + ((newClients == 0 || newClients
                > 1) ? "s: " : ": ") + newClients);
    }

    public static void HappyClinets(int countHappyClients) {
        System.out.println("Happy client" + ((countHappyClients == 0 || countHappyClients
                > 1) ? "s: " : ": ") + countHappyClients);
    }

    public static void UnhappyClinets(int countUnhappyClients) {
        System.out.println("Unhappy client" + ((countUnhappyClients == 0 ||
                countUnhappyClients > 1) ? "s: " : ": ") + countUnhappyClients);
    }

    public static void bootcamp(int bootcamp) {
        System.out.println("Bootcamp" +
                (bootcamp == 0 || bootcamp > 1 ? "s: " : ": ") + bootcamp + " open");
    }

    public static void bootcampClosed(int bootcampClosed) {
        System.out.println("we have bootcamp" +
                (bootcampClosed == 0 || bootcampClosed > 1 ? "s: " : ": ")
                + bootcampClosed + " closed");
    }

    public static void techCenter(int techCenter) {
        System.out.println("we have tech centre" +
                (techCenter == 0 || techCenter > 1 ? "s: " : ": ") + techCenter + " open");
    }

    public static void techCenterClosed(int techCenterClosed) {
        System.out.println("we have tech centre" +
                (techCenterClosed == 0 || techCenterClosed > 1 ? "s: " : ": ")
                + techCenterClosed + " closed");
    }

    public static void trainingHub(int trainingHub) {
        System.out.println("Training Hub open: " +
                (trainingHub == 0 || trainingHub > 1 ? "s: " : ": ") + trainingHub);
    }

    public static void trainingHubClosed(int trainingHubClosed) {
        System.out.println("Training Hub closed" +
                (trainingHubClosed == 0 || trainingHubClosed > 1 ? "s: " : ": ")
                + trainingHubClosed);
    }


}



