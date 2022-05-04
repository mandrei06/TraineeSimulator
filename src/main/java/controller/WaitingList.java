package controller;

import model.Trainee;

import java.util.ArrayList;
import java.util.List;

public class WaitingList {
    private List<Trainee> javaWaitingList = new ArrayList();

    public List<Trainee> storeJavaWaitingList(Trainee trainee) {
        try {
            this.javaWaitingList.add(trainee);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this.javaWaitingList;
    }

    public List<Trainee> deleteJavaWaitingList(List<Trainee> javaWaitingList)
    {
        try {
                javaWaitingList.remove(0);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return javaWaitingList;
    }
}
