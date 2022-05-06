package controller;

import model.*;

import java.util.Iterator;
import java.util.List;

public class ManageTrainees {
    // function that will be used when looping the training centres
    public void manageCentres(TrainingCentre trainingCentre, WaitingList wl,
                              int traineesGoingIntoEachCentre, Trainee t) {
        if(!trainingCentre.isClosed()) {
            System.out.println("old capacity: " + trainingCentre.getCapacity());
            // if there are any trainees in the waiting list we give them priority
            if(wl.getWaitingList().size() > 0 && trainingCentre.getCapacity() > 0) {
                List<Trainee> traineeWaitingList = wl.getWaitingList();
                Iterator<Trainee> iterator1 = traineeWaitingList.iterator();

                // going through the waiting list
                while(iterator1.hasNext()) {
                    Trainee traineeWaiting = iterator1.next();

                    if(trainingCentre.getCourse().contains(traineeWaiting.getCourse())) {
                        // storing trainees inside the training center list
                        trainingCentre.storeTrainees(traineeWaiting);
                        // removing trainees from waiting list
                        iterator1.remove();
                        // reducing the generated random number (50-100)
                        traineesGoingIntoEachCentre--;
                        // reducing capacity of training center
                        trainingCentre.setCapacity(trainingCentre.getCapacity() - 1);
                    }

                    // stopping the loops if we can't place more trainees or if the training center
                    // is full
                    if(traineesGoingIntoEachCentre == 0 || trainingCentre.getCapacity() == 0) {
                        break;
                    }
                }

                // once we finish we the waiting list if there are other trainees to place
                // we continue fill the training center if we have more trainees to place
                if(traineesGoingIntoEachCentre > 0 && trainingCentre.getCapacity() > 0 &&
                t.getTrainees().size() > 0) {
                    List<Trainee> traineeList = t.getTrainees();
                    Iterator<Trainee> iterator2 = traineeList.iterator();

                    // going thourgh the list of trainees (when we generate a new trainee we put
                    // them inside this list)
                    while(iterator2.hasNext()) {
                        Trainee trainee = iterator2.next();

                        if(trainingCentre.getCourse().contains(trainee.getCourse())) {
                            // storing trainees inside the training center list
                            trainingCentre.storeTrainees(trainee);
                            // removing trainees from trainees list
                            iterator2.remove();
                            // reducing the generated random number (50-100)
                            traineesGoingIntoEachCentre--;
                            // reducing capacity of training center
                            trainingCentre.setCapacity(trainingCentre.getCapacity() - 1);
                        }

                        // stopping the loops if we can't place more trainees or if the training
                        // center is full
                        if(traineesGoingIntoEachCentre == 0 || trainingCentre.getCapacity() == 0) {
                            break;
                        }
                    }
                }
            } else {
                // if there is nobody in waiting list we fill the trainees from trainees list
                // (when we generate a new trainee we put them inside this list)
                if(traineesGoingIntoEachCentre > 0 && trainingCentre.getCapacity() > 0 &&
                        t.getTrainees().size() > 0) {
                    List<Trainee> traineeList = t.getTrainees();
                    Iterator<Trainee> iterator3 = traineeList.iterator();

                    // going thourgh trainees list
                    while(iterator3.hasNext()) {
                        Trainee trainee = iterator3.next();

                        if(trainingCentre.getCourse().contains(trainee.getCourse())) {
                            // storing trainees inside the training center list
                            trainingCentre.storeTrainees(trainee);
                            // removing trainees from trainees list
                            iterator3.remove();
                            // reducing the generated random number (50-100)
                            traineesGoingIntoEachCentre--;
                            // reducing capacity of training center
                            trainingCentre.setCapacity(trainingCentre.getCapacity() - 1);
                        }

                        // stopping the loops if we can't place more trainees or if the training
                        // center is full
                        if(traineesGoingIntoEachCentre == 0 || trainingCentre.getCapacity() == 0) {
                            break;
                        }
                    }
                }
            }

            System.out.println("t.getTrainees().size()" + t.getTrainees().size());
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

            System.out.println("trainees " + t.getTrainees().size());
            System.out.println("waiting " + wl.getWaitingList().size());
            System.out.println("new capacity: " + trainingCentre.getCapacity());
        }
    }

    public void manageTrainees(int months) {
        WaitingList wl = new WaitingList();
        GenerateRandomNumber gn = new GenerateRandomNumber();
        Trainee t = new Trainee("any");
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
            System.out.println("trainees " + t.getTrainees().size());
            // generating random training centres and putting them into a list
            // first month we can't have a TrainingHub
            int countBootcamps = 0;
            for(int k = 0; k < tc.getTrainingCentres().size(); k++) {
                TrainingCentre trainingCentre = tc.getTrainingCentres().get(k);
                if(trainingCentre instanceof BootCamp) {
                    countBootcamps++;

                    if(trainingCentre.isClosed()) {
                        countBootcamps--;
                    }
                }
            }

            // first month we don't generate training hubs
            if(i == 1) {
                tc.generateTrainingCentre(0, 2);
            } else {
                // if we have 2 bootcamps open we don't generate another one
                if(countBootcamps == 2) {
                    tc.generateTrainingCentre(1, 3);
                } else {
                    // generating randomly any training centers
                    tc.generateTrainingCentre(0, 3);
                }
            }

            int traineesGoingIntoEachCentre = gn.generateRandomNumber(0, 51);
            System.out.println("traineesGoingIntoEachCentre " + traineesGoingIntoEachCentre);

            // looping through every training centres
            for(int j = 0; j < tc.getTrainingCentres().size(); j++) {
                TrainingCentre trainingCentre = tc.getTrainingCentres().get(j);

                System.out.println("start centre");
                manageCentres(trainingCentre, wl, traineesGoingIntoEachCentre,
                        trainee);

                // calculating how many trainees we need to put in waiting list
                int priorityWaitingList = trainingCentre instanceof TrainingHub ?
                        100 - trainingCentre.getCapacity() : 200 -
                        trainingCentre.getCapacity();

                // bootcamps can remain open up to 3 months without closing
                // if training center has less than 25 trainees in one month it will be closed
                int minimumCapacity = trainingCentre instanceof TrainingHub ? 75 : 175;
                if(trainingCentre.getMonths() > 1 &&
                        trainingCentre.getCapacity() > minimumCapacity &&
                        !(trainingCentre instanceof BootCamp)) {
                    // adding trainees to waiting list with index 0 so we give priority
                    // and removing them from the list of the centre
                    trainingClosed(priorityWaitingList, trainingCentre, wl);
                } else {
                    // if training center has less than 25 trainees in one month it will be closed
                    // bootcamps can remain open up to 3 months without closing
                    int minimumCapacityBootcamp = 475;

                    if(trainingCentre.getCapacity() > minimumCapacityBootcamp) {
                        trainingCentre.setLowAttendance(trainingCentre.getLowAttendance() + 1);
                    }
                }
                trainingCentre.setMonths(trainingCentre.getMonths() + 1);

                // calculating how many trainees we need to put in waiting list
                int priorityWaitingListBootcamp = 500 - trainingCentre.getCapacity();


                if(trainingCentre instanceof BootCamp && !trainingCentre.isClosed()) {
                    if(trainingCentre.getLowAttendance() > 2) {
                        trainingClosed(priorityWaitingListBootcamp, trainingCentre, wl);
                    }
                }

                System.out.println("end centre");
            }
            System.out.println("month " + i + " ended");
            System.out.println("size training centres " + tc.getTrainingCentres().size());
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