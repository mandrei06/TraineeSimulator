package model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TraineeTest {
    private Trainee trainee;

    @BeforeEach
    public void setTrainee() {
        trainee = new Trainee("java",0);
    }

    @Test
    void getCourse() {
        Assertions.assertEquals(Person.getCourse(), "java");
    }

    @Test
    void setCourse() {
        Person.setCourse("java");
        Assertions.assertEquals(Person.getCourse(), "java");
    }

    @Test
    void getTrainees() {
        trainee.generateTrainee();
        System.out.println(Person.getCourse());
    }

    @Test
    void generateTrainee() {
        trainee.generateTrainee();
        boolean expected = trainee != null;
        Assertions.assertTrue(expected);

    }
}

