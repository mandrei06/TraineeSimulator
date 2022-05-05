package model;

import java.util.ArrayList;
import java.util.List;

public class TrainingHub extends TrainingCentre implements TrainingCentersInterface {
    private static List<Trainee> trainingHubTrainees = new ArrayList<>();

    public List<Trainee> getTrainingHubTrainees() {
        return trainingHubTrainees;
    }

    public void storeTrainees(Trainee trainee) {
        System.out.println("trHub store size" + trainingHubTrainees.size());
        this.trainingHubTrainees.add(trainee);
    }

    public void removeTrainees() {
        System.out.println("trHub remove size" + trainingHubTrainees.size());
        this.trainingHubTrainees.remove(0);
    }

    public TrainingHub(int capacity, boolean closed, String course,
                       int months) {
        super(capacity, closed, course, months);
    }

    public Trainee getTrainee() {
        System.out.println("trHub get size" + trainingHubTrainees.size());
        Trainee trainee = this.trainingHubTrainees.get(0);
        return trainee;
    }
}
