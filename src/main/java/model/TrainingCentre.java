package model;

import controller.GenerateRandomCourse;
import controller.GenerateRandomNumber;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TrainingCentre {
    private List<TrainingCentre> trainingCentres = new ArrayList();
    private int capacity;
    private boolean closed;
    private String course;
    private int months;

    public int getMonths() {
        return months;
    }

    public void setMonths(int months) {
        this.months = months;
    }

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

    public TrainingCentre(int capacity, boolean closed, String course, int months) {
        this.capacity = capacity;
        this.closed = closed;
        this.course = course;
        this.months = months;
    }

    public void storeTrainingCentres(TrainingCentre trainingCentre) {
        try {
            this.trainingCentres.add(trainingCentre);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public TrainingCentre generateTrainingCentre() {
        TrainingCentre trainingCentre = null;
        try {
            // generating a random number so that we can generate a random training centre
            GenerateRandomNumber gn = new GenerateRandomNumber();
            int randomNumber = gn.generateRandomNumber(0, 2);

            switch (randomNumber) {
                case 0 -> {
                    trainingCentre = new BootCamp(500, false,
                            "any", 1);
                    this.storeTrainingCentres(trainingCentre);
                }
                case 1 -> {
                    // generating a random number between 1 and 3 in order to generate
                    // between 1 and 3 training hub
                    int randomNumberHub = gn.generateRandomNumber(1, 4);
                    for(int i = 1; i <= randomNumberHub; i++) {
                     trainingCentre = new TrainingHub(100,
                             false, "any", 1);
                     this.storeTrainingCentres(trainingCentre);
                    }
                }
                case 2 -> {
                    // generating random course which will be assigned to the TechCentre
                    GenerateRandomCourse gc = new GenerateRandomCourse();
                    String course = gc.generateRandomCourse();
                    trainingCentre = new TechCentre(200, false, course, 1);
                    this.storeTrainingCentres(trainingCentre);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return trainingCentre;
    }
}
