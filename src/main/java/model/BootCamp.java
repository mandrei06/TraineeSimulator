package model;

public class BootCamp extends TrainingCentre {
    private int months;

    public int getMonths() {
        return months;
    }

    public void setMonths(int months) {
        this.months = months;
    }

    public BootCamp(int capacity, boolean closed, String course, int months) {
        super(capacity, closed, course);
        this.months = months;
    }
}
