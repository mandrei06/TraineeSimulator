package model;

public class TrainingCentre {
    private int capacity = 100;
    private boolean closed = false;
    private String course;

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
}
