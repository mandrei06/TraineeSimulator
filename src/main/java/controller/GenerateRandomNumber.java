package controller;

import java.util.Random;

public class GenerateRandomNumber {
    public int generateRandom50() {
        int number = 0;
        try {
            Random rand = new Random();
            number = rand.nextInt(51);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return number;
    }

    public int generateRandom100() {
        int number = 0;
        try {
            Random rand = new Random();
            number = rand.nextInt(101);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return number;
    }
}
//test