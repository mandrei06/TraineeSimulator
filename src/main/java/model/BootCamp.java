package model;

import java.util.ArrayList;
import java.util.List;

public class BootCamp extends TrainingCentre {
    private List<Trainee> bootcampTrainees = new ArrayList<>();

    public BootCamp(int capacity, boolean closed, String course, int months) {
        super(capacity, closed, course, months);
    }

    public void storeTrainees(Trainee trainee) {
        this.bootcampTrainees.add(trainee);
    }

    public Trainee getTrainee() {
        Trainee trainee = this.bootcampTrainees.get(0);
        return trainee;
    }
}
