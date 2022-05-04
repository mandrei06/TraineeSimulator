package model;

import java.util.ArrayList;
import java.util.List;

public class BootCamp extends TrainingCentre {
    private List<Trainee> bootcampTrainees = new ArrayList<>();

    public List<Trainee> getBootcampTrainees() {
        return bootcampTrainees;
    }

    public void storeTrainees(Trainee trainee) {
        this.bootcampTrainees.add(trainee);
    }

    public BootCamp(int capacity, boolean closed, String course, int months) {
        super(capacity, closed, course, months);
    }
}
