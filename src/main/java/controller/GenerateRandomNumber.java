package controller;

import java.util.Random;

public class GenerateRandomNumber {
    public int generateRandomNumber(int numberArg) {
        int number = 0;
        try {
            Random rand = new Random();
            number = rand.nextInt(numberArg);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return number;
    }
}
//test