package model;

import java.util.ArrayList;
import java.util.List;

public class BootCamp extends TrainingCentre implements TrainingCentersInterface {
    private static List<Trainee> bootcampTrainees = new ArrayList<>();

    public BootCamp(int capacity, boolean closed, String course,
                    int months) {
        super(capacity, closed, course, months);
    }

    public void storeTrainees(Trainee trainee) {
        this.bootcampTrainees.add(trainee);
        // System.out.println("b sto " + this.bootcampTrainees.size());
    }

    public void removeTrainees() {
        this.bootcampTrainees.remove(0);
        // System.out.println("b rem " + this.bootcampTrainees.size());
    }

    public Trainee getTrainee() {
        Trainee trainee = this.bootcampTrainees.get(0);
        // System.out.println("b get " + this.bootcampTrainees.size());
        return trainee;
    }
}
