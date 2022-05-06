package model;

import java.util.List;

public interface TrainingCentersInterface {
    List<Trainee> getTraineesFromCenter();
    void storeTrainees(Trainee trainee);
    void removeTrainees();
}
