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
        System.out.println("boot store size" + bootcampTrainees.size());
    }

    public void removeTrainees() {
        this.bootcampTrainees.remove(0);
        System.out.println("boot remove size" + bootcampTrainees.size());
    }

    public Trainee getTrainee() {
        System.out.println("boot get size" + bootcampTrainees.size());
        Trainee trainee = this.bootcampTrainees.get(0);
        return trainee;
    }
}
