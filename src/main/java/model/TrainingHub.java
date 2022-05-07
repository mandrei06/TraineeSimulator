package model;

import java.util.ArrayList;
import java.util.List;

public class TrainingHub extends TrainingCentre implements TrainingCentersInterface {
    private static List<Trainee> trainingHubTrainees = new ArrayList<>();

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

    public void increaseMonth() {
        for(int i = 0; i < trainingHubTrainees.size(); i++) {
            Trainee trainee = trainingHubTrainees.get(i);
            trainee.setMonths(trainee.getMonths() + 1);
        }
    }
}
