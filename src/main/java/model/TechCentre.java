package model;

import java.util.ArrayList;
import java.util.List;

public class TechCentre extends TrainingCentre implements TrainingCentersInterface {
    private static List<Trainee> techCentreTrainees = new ArrayList<>();

    public List<Trainee> getTechCentreTrainees() {
        return techCentreTrainees;
    }

    public void storeTrainees(Trainee trainee) {
        this.techCentreTrainees.add(trainee);
        // System.out.println("tech sto " + this.techCentreTrainees.size());
    }

    public void removeTrainees() {
        this.techCentreTrainees.remove(0);
        // System.out.println("tech rem " + this.techCentreTrainees.size());
    }

    public TechCentre(int capacity, boolean closed, String course, int months) {
        super(capacity, closed, course, months);
    }

    public List<Trainee> getTraineesFromCenter() {
        List<Trainee> trainees = this.techCentreTrainees;
        // System.out.println("tech get " + this.techCentreTrainees.size());
        return trainees;
    }
}
