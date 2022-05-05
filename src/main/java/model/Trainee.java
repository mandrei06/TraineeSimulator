package model;

import controller.GenerateRandomCourse;

import java.util.ArrayList;
import java.util.List;

public class Trainee {
    private String course;
    private List<Trainee> trainees = new ArrayList();

    public Trainee(String course) {
        this.course = course;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
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
            trainee = new Trainee(course);
            this.trainees.add(trainee);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return trainee;
    }
}
