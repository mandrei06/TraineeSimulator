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
        trainingHub = new TrainingHub(100, false, "java", 8);
        trainee = new Trainee("java");
    }

    @Test
    void storeTrainees() {
        trainingHub.storeTrainees(trainee);
        boolean expected= trainingHub.getTrainee().equals(trainee);
        Assertions.assertTrue(expected);
    }

    @Test
    void removeTrainees() {
        trainingHub.storeTrainees(trainee);
        trainingHub.removeTrainees();
        boolean expected= trainingHub.getTrainingHubTrainees().isEmpty();

        Assertions.assertTrue(expected);
    }

    @Test
    void getTrainee() {
        trainingHub.storeTrainees(trainee);
        Trainee result=new Trainee("java");
        result=trainingHub.getTrainee();
        Assert.assertEquals(trainee,result);
    }
}