package model;

import java.util.ArrayList;
import java.util.List;

public class TrainingHub extends TrainingCentre {
    private List<Trainee> trainingHubTrainees = new ArrayList<>();

    public List<Trainee> getTrainingHubTrainees() {
        return trainingHubTrainees;
    }

    public void storeTrainees(Trainee trainee) {
        this.trainingHubTrainees.add(trainee);
    }

    public TrainingHub(int capacity, boolean closed, String course, int months) {
        super(capacity, closed, course, months);
    }

    public Trainee getTrainee() {
        Trainee trainee = this.trainingHubTrainees.get(0);
        return trainee;
    }
}
