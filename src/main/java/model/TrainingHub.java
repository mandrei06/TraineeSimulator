package model;

import java.util.ArrayList;
import java.util.List;

public class TrainingHub extends TrainingCentre implements TrainingCentersInterface {
    private static List<Trainee> trainingHubTrainees = new ArrayList<>();

    public void storeTrainees(Trainee trainee) {
        this.trainingHubTrainees.add(trainee);
        // System.out.println("hub sto " + this.trainingHubTrainees.size());
    }

    public void removeTrainees() {
        this.trainingHubTrainees.remove(0);
        // System.out.println("hub rem " + this.trainingHubTrainees.size());
    }

    public TrainingHub(int capacity, boolean closed, String course, int months) {
        super(capacity, closed, course, months);
    }

    public Trainee getTrainee() {
        Trainee trainee = this.trainingHubTrainees.get(0);
        // System.out.println("hub get " + this.trainingHubTrainees.size());
        return trainee;
    }
}
