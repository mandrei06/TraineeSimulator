package controller;

import display.UserInput;

public class Manager {
    public void start() {
        try {
            UserInput input = new UserInput();
            int months = input.askInput("months");
            int centres = input.askInput("centres");
            ManageTrainees mt = new ManageTrainees();
            mt.manageTrainees(months, centres);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
