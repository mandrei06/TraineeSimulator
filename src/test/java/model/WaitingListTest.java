package model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WaitingListTest {
    private WaitingList waitingList;
    private Trainee trainee;

    @BeforeEach
    public void setWaitingList() {
        waitingList = new WaitingList();
        trainee = new Trainee("java",0);
    }

    @Test
    void getWaitingList() {
        waitingList.storeWaitingList(trainee);
        boolean expected = waitingList.getWaitingList().contains(trainee);
        Assertions.assertTrue(expected);
    }

    @Test
    void storeWaitingList() {
        waitingList.storeWaitingList(trainee);
        boolean expected = waitingList != null;
        Assertions.assertTrue(expected);
    }


}

