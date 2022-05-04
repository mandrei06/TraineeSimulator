package model;

import controller.GenerateRandomCourse;

import java.util.ArrayList;
import java.util.List;

public class TechCentre extends TrainingCentre {
    private List<Trainee> techCentreTrainees = new ArrayList<>();

    public List<Trainee> getTechCentreTrainees() {
        return techCentreTrainees;
    }

    public void storeTrainees(Trainee trainee) {
        this.techCentreTrainees.add(trainee);
    }

    public TechCentre(int capacity, boolean closed, String course, int months) {
        super(capacity, closed, course, months);
    }
}
