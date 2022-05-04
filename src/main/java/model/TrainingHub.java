package model;

public class TrainingHub extends TrainingCentre {
    public TrainingHub(int capacity, boolean closed, String course) {
        super(capacity, closed, course);
    }

    public TrainingHub generateTrainingHub() {
        TrainingHub trainingHub = null;

        try {
            trainingHub = new TrainingHub(100, false, "any");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return trainingHub;
    }
}
