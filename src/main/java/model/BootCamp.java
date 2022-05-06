package model;

import java.util.ArrayList;
import java.util.List;

public class BootCamp extends TrainingCentre implements TrainingCentersInterface {


    private static List<Trainee> bootcampTrainees = new ArrayList<>();

    public BootCamp(int capacity, boolean closed, String course,
                    int months) {
        super(capacity, closed, course, months);
    }

    private int month1;
    private int month2;
    private int month3;

    public int getMonth1() {
        return month1;
    }

    public void setMonth1(int month1) {
        this.month1 = month1;
    }

    public int getMonth2() {
        return month2;
    }

    public void setMonth2(int month2) {
        this.month2 = month2;
    }

    public int getMonth3() {
        return month3;
    }

    public void setMonth3(int month3) {
        this.month3 = month3;
    }

    public static List<Trainee> getBootcampTrainees() {
        return bootcampTrainees;
    }

    public void storeTrainees(Trainee trainee) {
        this.bootcampTrainees.add(trainee);
        // System.out.println("b sto " + this.bootcampTrainees.size());
    }

    public void removeTrainees() {
        this.bootcampTrainees.remove(0);
        // System.out.println("b rem " + this.bootcampTrainees.size());
    }

    public List<Trainee> getTraineesFromCenter() {
        List<Trainee> trainees = this.bootcampTrainees;
        // System.out.println("b get " + this.bootcampTrainees.size());
        return trainees;
    }
}
