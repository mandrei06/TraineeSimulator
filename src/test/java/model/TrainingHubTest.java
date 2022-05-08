package model;

import junit.framework.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrainingHubTest {
    private TrainingHub trainingHub;
    private Trainee trainee;

    @BeforeEach
    public void setUp() {
        trainingHub = new TrainingHub(100, false, "java", 12,0);
        trainee = new Trainee("java",0);
    }

    @Test
    void storeTrainees() {
        trainingHub.storeTrainees(trainee);
        boolean expected= trainingHub.getTraineesFromCenter().get(0).equals(trainee);
        Assertions.assertTrue(expected);
    }



    @Test
    void getTrainee() {
        trainingHub.storeTrainees(trainee);
        boolean expected = trainingHub.getTraineesFromCenter().size() > 0;
        Assertions.assertTrue(expected);

    }
}

