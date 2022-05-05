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
        bootCamp=new BootCamp(100,false,"java",3);
        trainee=new Trainee("java");
    }


    @Test
    void storeTrainees() {
        bootCamp.storeTrainees(trainee);
        boolean expected= bootCamp.getTrainee().equals(trainee);
        Assertions.assertTrue(expected);
    }

    @Test
    void removeTrainees() {
        bootCamp.storeTrainees(trainee);
        bootCamp.removeTrainees();
        boolean expected= bootCamp.getBootcampTrainees().isEmpty();

        Assertions.assertTrue(expected);
    }

    @Test
    void getTrainee() {
        bootCamp.storeTrainees(trainee);
        Trainee result=new Trainee("java");
        result=bootCamp.getTrainee();
        Assert.assertEquals(trainee,result);
    }
}
