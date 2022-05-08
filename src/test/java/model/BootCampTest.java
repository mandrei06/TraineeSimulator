package model;

import junit.framework.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BootCampTest {
    private BootCamp bootCamp;
    private Trainee trainee;


    @BeforeEach
    public void setUp() {
        bootCamp=new BootCamp(100,false,"java",3,0);
        trainee=new Trainee("java",0);
    }


    @Test
    void storeTrainees() {
        bootCamp.storeTrainees(trainee);
        boolean expected= bootCamp.getTraineesFromCenter().get(0).equals(trainee);
        Assertions.assertTrue(expected);
    }



    @Test
    void getTrainee() {
        bootCamp.storeTrainees(trainee);

        boolean expected = bootCamp.getTraineesFromCenter().size() > 0;
        Assertions.assertTrue(expected);

    }
}


