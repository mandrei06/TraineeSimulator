package model;

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

    public Trainee getTrainee() {
        Trainee trainee = this.techCentreTrainees.get(0);
        return trainee;
    }
}
