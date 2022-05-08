package model;

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
        techCentre=new TechCentre(100,false,"java",12,0);
        trainee=new Trainee("java",0);
    }


    @Test
    void storeTrainees() {
        techCentre.storeTrainees(trainee);
        boolean expected= techCentre.getTraineesFromCenter().get(0).equals(trainee);
        Assertions.assertTrue(expected);
    }


    @Test
    void getTrainee() {
        techCentre.storeTrainees(trainee);
        boolean expected = techCentre.getTraineesFromCenter().size() > 0;
        Assertions.assertTrue(expected);
    }
}

