package controller;

import display.TraineeDisplay;
import display.UserInput;

public class Manager {
    public void start() {
        try {
            UserInput input = new UserInput();
            int months = input.askMonths();
            TraineeDisplay display = new TraineeDisplay();
          //  boolean report = display.monthlyReport();
            ManageTrainees mt = new ManageTrainees();
            mt.manageTrainees(months);
           // display.tranieeDisplay(months, );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
