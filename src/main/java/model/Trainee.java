package model;

import controller.GenerateRandomCourse;

import java.util.LinkedList;
import java.util.List;

public class Trainee extends Person {
    public static List<Trainee> trainees = new LinkedList<>();
    public static List<Trainee> bench = new LinkedList<>();

    public static List<Trainee> getBench() {
        return bench;
    }

    public Trainee(String course, int months) {
        super(course, months);
    }

    public List<Trainee> getTrainees() {
        return trainees;
    }

    public Trainee generateTrainee() {
        Trainee trainee = null;
        try {
            // generating random course for trainee
            GenerateRandomCourse gc = new GenerateRandomCourse();
            String course = gc.generateRandomCourse();
            trainee = new Trainee(course, 0);
            this.trainees.add(trainee);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return trainee;
    }
}
