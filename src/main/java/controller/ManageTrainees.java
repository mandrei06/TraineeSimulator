package controller;

import model.*;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ManageTrainees {
    // this function will be used when we need to manage the trainees that are not in
    // waiting list
    public void manageNewHires(Trainee t, TrainingCentre trainingCentre,
                               int traineesGoingIntoEachCentre) {
        List<Trainee> traineeList = t.getTrainees();
        Iterator<Trainee> iterator = traineeList.iterator();
        // this variable will be used to count actually how many trainees went
        // to the training centre from trainee list (new hires)
        int counter = 0;
        // going thourgh the list of trainees (when we generate a new trainee we put
        // them inside this list)
        while(iterator.hasNext()) {
            Trainee trainee = iterator.next();

            if(trainingCentre.getCourse().contains(trainee.getCourse())) {
                // storing trainees inside the training center list
                trainingCentre.storeTrainees(trainee);
                // removing trainees from trainees list
                iterator.remove();
                // reducing the generated random number (50-100)
                traineesGoingIntoEachCentre--;
                // reducing capacity of training center
                trainingCentre.setCapacity(trainingCentre.getCapacity() - 1);
                counter++;
            }

            // stopping the loops if we can't place more trainees or if the training
            // center is full
            if(traineesGoingIntoEachCentre == 0 || trainingCentre.getCapacity() == 0) {
                break;
            }
        }
        System.out.println("new hires went to training center " + counter);
    }

    // function that will be used when looping the training centres
    public void manageCentres(TrainingCentre trainingCentre, WaitingList wl,
                              int traineesGoingIntoEachCentre, Trainee t) {
        if(!trainingCentre.isClosed()) {
            System.out.println("old capacity: " + trainingCentre.getCapacity());
            // if there are any trainees in the waiting list we give them priority
            if(wl.getWaitingList().size() > 0 && trainingCentre.getCapacity() > 0) {
                List<Trainee> traineeWaitingList = wl.getWaitingList();
                Iterator<Trainee> iterator = traineeWaitingList.iterator();
                // this variable will be used to count actually how many trainees went
                // to the training centre from waiting list
                int counter = 0;
                // going through the waiting list
                while(iterator.hasNext()) {
                    Trainee traineeWaiting = iterator.next();

                    if(trainingCentre.getCourse().contains(traineeWaiting.getCourse())) {
                        // storing trainees inside the training center list
                        trainingCentre.storeTrainees(traineeWaiting);
                        // removing trainees from waiting list
                        iterator.remove();
                        // reducing the generated random number (50-100)
                        traineesGoingIntoEachCentre--;
                        // reducing capacity of training center
                        trainingCentre.setCapacity(trainingCentre.getCapacity() - 1);
                        counter++;
                    }

                    // stopping the loops if we can't place more trainees or if the training center
                    // is full
                    if(traineesGoingIntoEachCentre == 0 || trainingCentre.getCapacity() == 0) {
                        break;
                    }
                }

                System.out.println("trainees went to training centre from waiting " + counter);
            }
            // once we finish we the waiting list if there are other trainees to place
            // we continue fill the training center if we have more trainees to place
            if(traineesGoingIntoEachCentre > 0 && trainingCentre.getCapacity() > 0 &&
            t.getTrainees().size() > 0) {
                manageNewHires(t, trainingCentre, traineesGoingIntoEachCentre);
            }

            List<Trainee> traineesListGoingToWaiting = t.getTrainees();
            Iterator<Trainee> iterator = traineesListGoingToWaiting.iterator();

            // once we placed all the trainees that we can place we put in the waiting list
            // the remaining trainees
            while(iterator.hasNext()) {
                Trainee trainee = iterator.next();
                // storing trainees inside the waiting list
                wl.storeWaitingList(trainee);
                // removing trainees from trainees list
                // (when we generate a new trainee we put them inside this list)
                iterator.remove();
            }

            System.out.println("new hires list " + t.getTrainees().size());
            System.out.println("waiting list " + wl.getWaitingList().size());
            System.out.println("new capacity: " + trainingCentre.getCapacity());
        }
    }

    public void manageTrainees(int months) {
        WaitingList wl = new WaitingList();
        GenerateRandomNumber gn = new GenerateRandomNumber();
        Trainee t = new Trainee("any", 0);
        TrainingCentre tc = new TrainingCentre(0,true,
                "any", 0, 0);

        // starting from 1st month
        for(int i = 1; i <= months; i++) {
            System.out.println("month " + i + " started");
            // generating new hires (between 50-100)
            int newHires = gn.generateRandomNumber(50, 101);
            System.out.println("new hires " + newHires);

            // generating random employees based on the newHires number generated
            // and putting them into a list
            Trainee trainee = null;
            for(int j = 0; j < newHires; j++) {
                trainee = t.generateTrainee();
            }
            // generating random training centres and putting them into a list
            // first month we can't have a TrainingHub
            int countBootcamps = 0;

            for(TrainingCentre trainingCentre: tc.getTrainingCentres()) {
                if(trainingCentre instanceof BootCamp && !trainingCentre.isClosed()) {
                    countBootcamps++;
                }
            }
            System.out.println("countBootcamps" + countBootcamps);

            // first month we don't generate training hubs
            if(i == 1) {
                tc.generateTrainingCentre(0, 1);
                // if we have 2 bootcamps open we don't generate another one
            }
            if(countBootcamps == 2) {
                    tc.generateTrainingCentre(1, 3);
            } else {
                // generating randomly any training centers
                tc.generateTrainingCentre(0, 3);
            }
            // generating random number (0-50) of trainees going into each center
            int traineesGoingIntoEachCentre = gn.generateRandomNumber(0, 51);
            System.out.println("traineesGoingIntoEachCentre " + traineesGoingIntoEachCentre);

            // looping through every training centres
            for(int j = 0; j < tc.getTrainingCentres().size(); j++) {
                TrainingCentre trainingCentre = tc.getTrainingCentres().get(j);

                // handling centres and trainees
                manageCentres(trainingCentre, wl, traineesGoingIntoEachCentre,
                        trainee);

                // calculating how many trainees we need to put in waiting list
                int priorityWaitingList = trainingCentre instanceof TrainingHub ?
                        100 - trainingCentre.getCapacity() : 200 -
                        trainingCentre.getCapacity();

                // bootcamps can remain open up to 3 months without closing
                // if training center has less than 25 trainees in one month it will be closed
                int minimumCapacity = trainingCentre instanceof TrainingHub ? 75 : 175;

                // if training centre has low attendance we increase the low attendance by 1
                // later based on this element we will close the training centre
                if(trainingCentre.getCapacity() > minimumCapacity &&
                        !(trainingCentre instanceof BootCamp) && !trainingCentre.isClosed()) {
                    trainingCentre.setLowAttendance(trainingCentre.getLowAttendance() + 1);
                } else {
                    // if training center has less than 25 trainees in one month it will be closed
                    // bootcamps can remain open up to 3 months without closing
                    int minimumCapacityBootcamp = 475;

                    // if training centre has low attendance we increase the low attendance by 1
                    // later based on this element we will close the training centre
                    if(trainingCentre.getCapacity() > minimumCapacityBootcamp &&
                            !trainingCentre.isClosed()) {
                        trainingCentre.setLowAttendance(trainingCentre.getLowAttendance() + 1);
                        // bootcamps can be open for 3 consecutive months with low attendance
                        // if for 1 month we don't have low attendance we set it back to 0
                    } else if(trainingCentre.getCapacity() < minimumCapacityBootcamp &&
                    !trainingCentre.isClosed()) {
                        trainingCentre.setLowAttendance(0);
                    }
                }

                // calculating how many trainees we need to put in waiting list
                int priorityWaitingListBootcamp = 500 - trainingCentre.getCapacity();

                // closing bootcamp after 3 consecutive months of low attendance
                if(trainingCentre instanceof BootCamp && !trainingCentre.isClosed()
                && trainingCentre.getLowAttendance() > 3) {
                    trainingClosed(priorityWaitingListBootcamp, trainingCentre, wl);
                    System.out.println("bootcamp closed");
                }
                // closing any other training centres after 1 month of low attendance
                if(!trainingCentre.isClosed() && trainingCentre.getLowAttendance() > 1) {
                    trainingClosed(priorityWaitingList, trainingCentre, wl);

                    if(trainingCentre instanceof TechCentre) {
                        System.out.println("tech centre closed");
                    } else {
                        System.out.println("training hub closed");
                    }
                }
                // we let a month pass and then increase the months
                trainingCentre.setMonths(trainingCentre.getMonths() + 1);
                // we will use this variable in order to rpint how many we put in the bench
                int countTraineesToBench = 0;
                List<Trainee> traineesFromCenter = trainingCentre.getTraineesFromCenter();
                Iterator<Trainee> iterator = traineesFromCenter.iterator();

                // going through the list of trainees inside a training center
                while(iterator.hasNext()) {
                    Trainee tr = iterator.next();
                    // after one month we increase the months of the trainee
                    tr.setMonths(tr.getMonths() + 1);

                    // at 3 months trainee goes to the bench and it gets removed from
                    // training center list
                    if(tr.getMonths() == 3) {
                        iterator.remove();
                        tr.getBench().add(tr);
                        countTraineesToBench++;
                    }
                }
                System.out.println("trainee" + (countTraineesToBench == 0 || countTraineesToBench >
                        1 ? "s: " : " ") + countTraineesToBench + " went to bench");
                System.out.println("bench " + t.getBench().size());
            }
            System.out.println("month " + i + " ended");

            int bootcamp = 0;
            int techCenter = 0;
            int trainingHub = 0;
            int bootcampClosed = 0;
            int techCenterClosed = 0;
            int trainingHubClosed = 0;

            // calculating how many training centres are open and not per each type
            for(TrainingCentre trainingCentre: tc.getTrainingCentres()) {
                if(trainingCentre instanceof BootCamp && trainingCentre.isClosed()) {
                    bootcampClosed++;
                } else if (trainingCentre instanceof BootCamp && !trainingCentre.isClosed()) {
                    bootcamp++;
                } else if (trainingCentre instanceof TrainingHub && trainingCentre.isClosed()) {
                    trainingHubClosed++;
                } else if (trainingCentre instanceof TrainingHub && !trainingCentre.isClosed()) {
                    trainingHub++;
                } else if (trainingCentre instanceof TechCentre && !trainingCentre.isClosed()) {
                    techCenter++;
                } else if (trainingCentre instanceof TechCentre && trainingCentre.isClosed()) {
                    techCenterClosed++;
                }
            }
            Client clientGenerated = null;
            // generating client every 12 months
            if(i % 12 == 0) {
                Client c = new Client("any", 0, true);
                // this is the actual client
                clientGenerated = c.generateClient();
            }

            // every months a client takes a random number of trainees from 15-30
            int randomTraineesFromBench = gn.generateRandomNumber(15, 31);

            int countUnhappyClients = 0;
            int countHappyClients = 0;
            int newClients = 0;

            // going through list of clients
            for(Client client: clientGenerated.getClients()) {
                int counter = 0;
                List<Trainee> traineesFromBench = t.getBench();
                Iterator<Trainee> iterator = traineesFromBench.iterator();

                if(client.isHappy()) {
                    // going through the bench
                    while(iterator.hasNext()) {
                        Trainee trainee1 = iterator.next();

                        // if trainee matches the course of the client we remove the trainee
                        // from the bench and increase the counter
                        if(client.getCourse().equals(trainee1.getCourse())) {
                            iterator.remove();
                            counter++;
                        }

                        // if counter reaches the number of trainees that the client wants
                        // we break the loop
                        if(counter == randomTraineesFromBench) {
                            break;
                        }
                    }
                }

                // if client doesn't get enough trainees from bench we will set happy to false
                if(counter < randomTraineesFromBench) {
                    client.setHappy(false);
                }

                // counting new, happy and unhappy clients
                if(client.isHappy() && client.getMonths() > 11) {
                    countHappyClients++;
                }
                if(!client.isHappy() && client.getMonths() > 11) {
                    countUnhappyClients++;
                }
                if (client.getMonths() < 12) {
                    newClients++;
                }

                if(client.isHappy() && client.getMonths() > 12) {
                    // resetting months client to 0 so that we can have a track for a whole year
                    // if they collect enough trainees
                    client.setMonths(1);
                }

                // every month we increase the months of client by 1
                client.setMonths(client.getMonths() + 1);
            }

            // end of simulation
            if(i == months) {
                System.out.println("new client" + ((newClients == 0 || newClients
                        > 1) ? "s: " : ": ") + newClients);
                System.out.println("happy client" + ((countHappyClients == 0 || countHappyClients
                        > 1) ? "s: " : ": ") + countHappyClients);
                System.out.println("unhappy client" + ((countUnhappyClients == 0 ||
                        countHappyClients > 1) ? "s: " : ": ") + countUnhappyClients);
                System.out.println("we have bootcamp" +
                        (bootcamp == 0 || bootcamp > 1 ? "s: ": ": ") + bootcamp + " open");
                System.out.println("we have bootcamp" +
                        (bootcampClosed == 0 || bootcampClosed > 1 ? "s: ": ": ")
                        + bootcampClosed + " closed");
                System.out.println("we have tech centre" +
                        (techCenter == 0 || techCenter > 1 ? "s: ": ": ") + techCenter + " open");
                System.out.println("we have tech centre" +
                        (techCenterClosed == 0 || techCenterClosed > 1 ? "s: ": ": ")
                        + techCenterClosed + " closed");
                System.out.println("we have training hub" +
                        (trainingHub == 0 || trainingHub > 1 ? "s: ": ": ") + trainingHub + " open");
                System.out.println("we have training hub" +
                        (trainingHubClosed == 0 || trainingHubClosed > 1 ? "s: ": ": ")
                        + trainingHubClosed + " closed");
            }
        }
    }
    // adding trainees to waiting list with index 0 so we give priority
    // and removing them from the list of the centre
    public void trainingClosed(int priorityWaitingList, TrainingCentre trainingCentre,
                               WaitingList wl) {
        trainingCentre.setClosed(true);
        // getting the list of trainees of training center
        List<Trainee> traineesListGoingIntoWaiting = trainingCentre.getTraineesFromCenter();
        Iterator<Trainee> iterator = traineesListGoingIntoWaiting.iterator();

        if(priorityWaitingList > 0) {
            while(iterator.hasNext()) {
                Trainee priorityTrainee = iterator.next();
                // adding to the beginning of waiting list priority trainees
                wl.getWaitingList().add(0, priorityTrainee);
                // removing trainees from training center list
                iterator.remove();
                priorityWaitingList--;

                if(priorityWaitingList == 0) {
                    break;
                }
            }
        }
    }
}