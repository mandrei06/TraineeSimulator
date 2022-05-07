package model;

import java.util.ArrayList;
import java.util.List;

public class TechCentre extends TrainingCentre implements TrainingCentersInterface {
    private static List<Trainee> techCentreTrainees = new ArrayList<>();

    public static List<Trainee> getTechCentreTrainees() {
        return techCentreTrainees;
    }

    public void storeTrainees(Trainee trainee) {
        this.techCentreTrainees.add(trainee);
    }

    public TechCentre(int capacity, boolean closed, String course, int months,
                      int lowAttendance) {
        super(capacity, closed, course, months, lowAttendance);
    }

    public List<Trainee> getTraineesFromCenter() {
        List<Trainee> trainees = this.techCentreTrainees;
        return trainees;
    }
}
