package model;

import controller.GenerateRandomCourse;

import java.util.*;

public class Client extends Person {
    private static List<Client> clients = new LinkedList<>();
    private boolean happy;

    public static List<Client> getClients() {
        return clients;
    }

    public boolean isHappy() {
        return happy;
    }

    public void setHappy(boolean happy) {
        this.happy = happy;
    }

    public Client(String course, int months, boolean happy) {
        super(course, months);
        this.happy = happy;
    }

    public Client generateClient() {
        try {
            // generating random course for the client
            GenerateRandomCourse gc = new GenerateRandomCourse();
            String courseChosen = gc.generateRandomCourse();

            Client client = new Client(courseChosen, 0, true);
            System.out.println("client generated: " + courseChosen);
            this.clients.add(client);
            return client;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
