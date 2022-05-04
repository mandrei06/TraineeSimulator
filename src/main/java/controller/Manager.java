package controller;

import display.UserInput;

public class Manager {
    public void start() {
        try {
            UserInput input = new UserInput();
            int months = input.askMonths();
            //ManageTrainees mt = new ManageTrainees();
            //mt.manageTrainees(months);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
