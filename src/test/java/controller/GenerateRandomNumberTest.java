package controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GenerateRandomNumberTest {
    private GenerateRandomNumber generate;

    @BeforeEach
    public void setUp() {
        generate = new GenerateRandomNumber();
    }

    @Test
    public void testGenerate50() {
        int number = generate.generateRandomNumber(0, 51);
        boolean expected = false;
        if(number >= 0 && number <= 50) {
            expected = true;
        }
        Assertions.assertEquals(expected, true);
    }

    @Test
    public void testGenerate100() {
        int number = generate.generateRandomNumber(50, 101);
        boolean expected = false;
        if(number >= 50 && number <= 100) {
            expected = true;
        }
        System.out.println("number " + number);
        Assertions.assertEquals(expected, true);
    }
}
