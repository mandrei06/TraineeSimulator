package model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TraineeTest {
    private Trainee trainee;

    @BeforeEach
    public void setTrainee() {
        trainee = new Trainee("java");
    }

    @Test
    void getCourse() {
        Assertions.assertEquals(trainee.getCourse(), "java");
    }

    @Test
    void setCourse() {
        trainee.setCourse("java");
        Assertions.assertEquals(trainee.getCourse(), "java");
    }

    @Test
    void getTrainees() {
        trainee.generateTrainee();
        System.out.println(trainee.getTrainees().get(0).getCourse());
    }

    @Test
    void generateTrainee() {
        trainee.generateTrainee();
        boolean expected = trainee != null;
        Assertions.assertTrue(expected);

    }
}