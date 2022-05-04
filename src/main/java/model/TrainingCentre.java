package model;

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
}
