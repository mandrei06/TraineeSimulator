package model;

import java.util.ArrayList;
import java.util.List;

public class TrainingHub extends TrainingCentre implements TrainingCentersInterface {
    private static List<Trainee> trainingHubTrainees = new ArrayList<>();

    public static List<Trainee> getTrainingHubTrainees() {
        return trainingHubTrainees;
    }

    public void storeTrainees(Trainee trainee) {
        this.trainingHubTrainees.add(trainee);
    }

    public TrainingHub(int capacity, boolean closed, String course, int months,
                       int lowAttendance) {
        super(capacity, closed, course, months, lowAttendance);
    }

    public List<Trainee> getTraineesFromCenter() {
        List<Trainee> trainees = this.trainingHubTrainees;
        return trainees;
    }
}
