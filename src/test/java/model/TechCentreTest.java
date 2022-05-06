/*package model;

import junit.framework.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TechCentreTest {
    private TechCentre techCentre;
    private Trainee trainee;

    @BeforeEach
    public void setUp() {
        techCentre=new TechCentre(100,false,"java",12);
        trainee=new Trainee("java");
    }


    @Test
    void storeTrainees() {
        techCentre.storeTrainees(trainee);
        boolean expected= techCentre.getTrainee().equals(trainee);
        Assertions.assertTrue(expected);
    }

    @Test
    void removeTrainees() {
        techCentre.storeTrainees(trainee);
        techCentre.removeTrainees();
        boolean expected= techCentre.getTechCentreTrainees().isEmpty();

        Assertions.assertTrue(expected);
    }

    @Test
    void getTrainee() {
        techCentre.storeTrainees(trainee);
        Trainee result=new Trainee("java");
        result=techCentre.getTrainee();
        Assert.assertEquals(trainee,result);
    }
}

 */