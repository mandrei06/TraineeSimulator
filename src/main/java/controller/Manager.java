package controller;

import display.UserInput;

public class Manager {
    public void start() {
        try {
            UserInput input = new UserInput();
            input.askMonths();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
