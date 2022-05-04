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

    public BootCamp generateBootCamp() {
        BootCamp bootCamp = null;

        try {
            bootCamp = new BootCamp(500, false, "any", 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bootCamp;
    }
}
