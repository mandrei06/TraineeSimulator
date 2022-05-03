package controller;

import display.UserInput;

public class Manager {
    public void start() {
        try {
            UserInput input = new UserInput();
            input.askInput("months");
            input.askInput("centres");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
