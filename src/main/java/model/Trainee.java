package model;

import controller.GenerateRandomCourse;

public class Trainee {
    private String course;

    public Trainee(String course) {
        this.course = course;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public Trainee generateTrainee() {
        Trainee trainee = null;
        try {
            // generating random course for trainee
            GenerateRandomCourse gc = new GenerateRandomCourse();
            String course = gc.generateRandomCourse();
            trainee = new Trainee(course);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return trainee;
    }
}
