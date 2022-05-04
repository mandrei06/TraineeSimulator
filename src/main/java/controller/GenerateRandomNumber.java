package controller;

import java.util.Random;

public class GenerateRandomNumber {
    public int generateRandomNumber(int value1, int value2) {
        int number = 0;
        try {
            Random rand = new Random();
            number = rand.nextInt(value1, value2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return number;
    }
}
//test