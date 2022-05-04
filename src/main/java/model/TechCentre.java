package model;

import controller.GenerateRandomCourse;

public class TechCentre extends TrainingCentre {
    public TechCentre(int capacity, boolean closed, String course) {
        super(capacity, closed, course);
    }

    public TechCentre generateTechCentre() {
        TechCentre techCentre = null;
        try {
            // generating random course which will be assigned to the TechCentre
            GenerateRandomCourse gc = new GenerateRandomCourse();
            String course = gc.generateRandomCourse();
            techCentre = new TechCentre(200, false, course);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return techCentre;
    }
}
