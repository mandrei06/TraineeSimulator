package controller;

import model.Trainee;
import model.TrainingCentre;

public class ManageTrainees {
    public void manageTrainees(int months) {
        // List<Trainee> javaTraineesWaiting = null;
        // List<TrainingCentre> trainingCentres = null;
        WaitingList wl = new WaitingList();
        GenerateRandomNumber gn = new GenerateRandomNumber();
        Trainee trainee = new Trainee("any");
        // generating between 50-100 trainees for first month
        int trainees = gn.generateRandomNumber(50, 101);
        System.out.println("trainees " + trainees);
        // creating trainees based on the random generator and adding them into a
        // priority waiting list (first month we don't have any training centre)
        for(int j = 1; j <= trainees; j++) {
            trainee.generateTrainee();
            String traineeCourse = trainee.getCourse();

            switch (traineeCourse) {
                case "java" -> {
                    wl.storeWaitingList(trainee, "java priority");
                }
                case "c#" -> {
                    wl.storeWaitingList(trainee, "c# priority");
                }
                case "data" -> {
                    wl.storeWaitingList(trainee, "data priority");
                }
                case "devops" -> {
                    wl.storeWaitingList(trainee, "devops priority");
                }
                case "business" -> {
                    wl.storeWaitingList(trainee, "business priority");
                }
            }
        }
        System.out.println("java trainee in priority waiting list "
                + wl.getPriorityJavaWaitingList().size());
        System.out.println("c# trainee in priority waiting list "
                + wl.getPriorityCWaitingList().size());
        System.out.println("data trainee in priority waiting list "
                + wl.getPriorityDataWaitingList().size());
        System.out.println("devops trainee in priority waiting list "
                + wl.getPriorityDevOpsWaitingList().size());
        System.out.println("business trainee in priority waiting list "
                + wl.getPriorityBusinessWaitingList().size());

        // starting from 2nd month
        for(int i = 2; i <= months; i++) {
            // generating new java hires (between 50-100)
            int newHires = gn.generateRandomNumber(50, 101);
            System.out.println("new hires: " + newHires);
            // every 2 months
            if(i % 2 == 0) {

            }
            // generating number between 0-50 to see how many go into training centre
            int traineesGoingIntoEachCentre = gn.generateRandomNumber(0, 51);
            System.out.println("traineesGoingIntoEachCentre " + traineesGoingIntoEachCentre);
            // maximum number of java dev that can be placed
            // this variable will be used later so that we can update the new hires
            // and put them into a waiting list
            int maximumNumberJavaDevPlaced = traineesGoingIntoEachCentre * trainingCentres.size();
            System.out.println(maximumNumberJavaDevPlaced + " can go into centres");

            // if there are java devs in waiting list we put them first in centre
            for(TrainingCentre trainingCentre: trainingCentres) {
                // getting capacity
                int trainingCentreCapacity = trainingCentre.getCapacity();

                if(javaTraineesWaiting.size() > 0 &&
                        traineesGoingIntoEachCentre <= javaTraineesWaiting.size()) {
                    System.out.println("old capacity: " + trainingCentre.getCapacity());

                    // if the centre is about to get full we full it
                    // and put the remaining into a waiting list
                    if(trainingCentreCapacity < traineesGoingIntoEachCentre) {
                        int javaToAdd = traineesGoingIntoEachCentre - trainingCentreCapacity;
                        traineesGoingIntoEachCentre = trainingCentreCapacity;

                        for(int k = 0; k < javaToAdd; k++) {
                            Trainee javaTrainee = new Trainee("java");
                            wl.storeJavaWaitingList(javaTrainee);
                        }
                    }

                    trainingCentre.setCapacity(trainingCentreCapacity -
                            traineesGoingIntoEachCentre);

                    System.out.println("new capacity: " + trainingCentre.getCapacity());
                    // deleting java devs from waiting list
                    if(traineesGoingIntoEachCentre > 0) {
                        System.out.println("if size " + javaTraineesWaiting.size());
                        System.out.println("if train " + traineesGoingIntoEachCentre);

                        for(int j = 0; j < traineesGoingIntoEachCentre; j++) {
                            wl.deleteJavaWaitingList(javaTraineesWaiting);
                        }
                        System.out.println("if size2 " + javaTraineesWaiting.size());
                    }
                    System.out.println("javaTraineesWaiting.size() " + javaTraineesWaiting.size());
                } else if (traineesGoingIntoEachCentre > javaTraineesWaiting.size()) {
                    System.out.println("old capacity: " + trainingCentre.getCapacity());

                    // if the centre is about to get full we full it
                    // and put the remaining into a waiting list
                    if(trainingCentreCapacity < traineesGoingIntoEachCentre) {
                        int javaToAdd = traineesGoingIntoEachCentre - trainingCentreCapacity;
                        traineesGoingIntoEachCentre = trainingCentreCapacity;

                        for(int j = 0; j < javaToAdd; j++) {
                            Trainee javaTrainee = new Trainee("java");
                            wl.storeJavaWaitingList(javaTrainee);
                        }
                    }

                    trainingCentre.setCapacity(trainingCentreCapacity -
                            traineesGoingIntoEachCentre);
                    int numberJavaToDeleteFromWaiting = traineesGoingIntoEachCentre -
                            javaTraineesWaiting.size();

                    // deleting from waiting list
                    if(numberJavaToDeleteFromWaiting > 0) {
                        System.out.println("if size " + javaTraineesWaiting.size());
                        System.out.println("if train " + traineesGoingIntoEachCentre);

                        for(int j = 0; j < numberJavaToDeleteFromWaiting; j++) {
                            wl.deleteJavaWaitingList(javaTraineesWaiting);
                        }
                        System.out.println("if size2 " + javaTraineesWaiting.size());
                    }

                    System.out.println("new capacity: " + trainingCentre.getCapacity());

                    // updating new java hires so that we can put them into waiting list
                    newJavaHires -= maximumNumberJavaDevPlaced - numberJavaToDeleteFromWaiting;
                }
            }

            System.out.println("newJavaHires after " + newJavaHires);
            // adding to waiting list java devs that cannot be placed
            for(int j = 0; j < newJavaHires; j++) {
                Trainee javaTrainee = new Trainee("java");
                javaTraineesWaiting = wl.storeJavaWaitingList(javaTrainee);
            }
            System.out.println("storeJavaWaitingList " + javaTraineesWaiting.size());
        }
    }
}