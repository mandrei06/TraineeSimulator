package model;

import controller.GenerateRandomCourse;
import controller.GenerateRandomNumber;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TrainingCentre {
    private List<TrainingCentre> trainingCentres = new ArrayList();
    private int capacity;
    private boolean closed = false;
    private String course;

    public List<TrainingCentre> getTrainingCentres() {
        return trainingCentres;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean isClosed() {
        return closed;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }

    public TrainingCentre(int capacity, boolean closed, String course) {
        this.capacity = capacity;
        this.closed = closed;
        this.course = course;
    }

    public List<TrainingCentre> storeTrainingCentres(TrainingCentre trainingCentre) {
        try {
            this.trainingCentres.add(trainingCentre);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this.trainingCentres;
    }

    public TrainingCentre generateTrainingCentre() {
        TrainingCentre trainingCentre = null;
        try {
            // generating a random number so that we can generate a random training centre
            GenerateRandomNumber gn = new GenerateRandomNumber();
            int randomNumber = gn.generateRandomNumber(0, 3);

            switch (randomNumber) {
                case 0 -> {
                    trainingCentre = new BootCamp(500, false,
                            "any", 0);
                }
                case 1 -> {
                    trainingCentre = new TrainingHub(100, false, "any");
                }
                case 2 -> {
                    // generating random course which will be assigned to the TechCentre
                    GenerateRandomCourse gc = new GenerateRandomCourse();
                    String course = gc.generateRandomCourse();
                    trainingCentre = new TechCentre(200, false, course);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return trainingCentre;
    }
}
