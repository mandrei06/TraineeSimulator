package model;
import java.util.LinkedList;
import java.util.List;

public class WaitingList {
    private LinkedList<Trainee> waitingList = new LinkedList<>();

    public List<Trainee> getWaitingList() {
        return waitingList;
    }

    public void storeWaitingList(Trainee trainee) {
        try {
            this.waitingList.add(trainee);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteWaitingList(Trainee trainee)
    {
        try {
            this.waitingList.remove(trainee);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
