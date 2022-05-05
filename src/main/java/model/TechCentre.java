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
        System.out.println("tech store size" + techCentreTrainees.size());
    }

    public void removeTrainees() {
        this.techCentreTrainees.remove(0);
        System.out.println("tech remove size" + techCentreTrainees.size());
    }

    public TechCentre(int capacity, boolean closed, String course,
                      int months) {
        super(capacity, closed, course, months);
    }

    public Trainee getTrainee() {
        System.out.println("tech get size" + techCentreTrainees.size());
        Trainee trainee = this.techCentreTrainees.get(0);
        return trainee;
    }
}
