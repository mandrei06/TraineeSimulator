package controller;

import model.Trainee;

import java.util.ArrayList;
import java.util.List;

public class WaitingList {
    private List<Trainee> javaWaitingList = new ArrayList();
    private List<Trainee> priorityJavaWaitingList = new ArrayList<>();
    private List<Trainee> cWaitingList = new ArrayList();
    private List<Trainee> priorityCWaitingList = new ArrayList<>();
    private List<Trainee> dataWaitingList = new ArrayList();
    private List<Trainee> priorityDataWaitingList = new ArrayList<>();
    private List<Trainee> devOpsWaitingList = new ArrayList();
    private List<Trainee> priorityDevOpsWaitingList = new ArrayList<>();
    private List<Trainee> businessWaitingList = new ArrayList();
    private List<Trainee> priorityBusinessWaitingList = new ArrayList<>();

    public List<Trainee> getPriorityJavaWaitingList() {
        return priorityJavaWaitingList;
    }

    public List<Trainee> getcWaitingList() {
        return cWaitingList;
    }

    public List<Trainee> getPriorityCWaitingList() {
        return priorityCWaitingList;
    }

    public List<Trainee> getDataWaitingList() {
        return dataWaitingList;
    }

    public List<Trainee> getPriorityDataWaitingList() {
        return priorityDataWaitingList;
    }

    public List<Trainee> getDevOpsWaitingList() {
        return devOpsWaitingList;
    }

    public List<Trainee> getPriorityDevOpsWaitingList() {
        return priorityDevOpsWaitingList;
    }

    public List<Trainee> getBusinessWaitingList() {
        return businessWaitingList;
    }

    public List<Trainee> getPrioritybusinessWaitingList() {
        return priorityBusinessWaitingList;
    }

    public List<Trainee> getJavaWaitingList() {
        return javaWaitingList;
    }

    public List<Trainee> storeWaitingList(Trainee trainee, String list) {
        try {
            switch (list) {
                case "java" -> {
                    this.javaWaitingList.add(trainee);
                    return javaWaitingList;
                }
                case "java priority" -> {
                    this.priorityJavaWaitingList.add(trainee);
                    return priorityJavaWaitingList;
                }
                case "c#" -> {
                    this.cWaitingList.add(trainee);
                    return cWaitingList;
                }
                case "c# priority" -> {
                    this.priorityCWaitingList.add(trainee);
                    return priorityCWaitingList;
                }
                case "data" -> {
                    this.dataWaitingList.add(trainee);
                    return dataWaitingList;
                }
                case "data priority" -> {
                    this.priorityDataWaitingList.add(trainee);
                    return priorityDataWaitingList;
                }
                case "devops" -> {
                    this.devOpsWaitingList.add(trainee);
                    return devOpsWaitingList;
                }
                case "devops priority" -> {
                    this.priorityDevOpsWaitingList.add(trainee);
                    return priorityDevOpsWaitingList;
                }
                case "business" -> {
                    this.businessWaitingList.add(trainee);
                    return businessWaitingList;
                }
                case "business priority" -> {
                    this.priorityBusinessWaitingList.add(trainee);
                    return priorityBusinessWaitingList;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Trainee> deleteWaitingList(String list)
    {
        try {
            switch (list) {
                case "java" -> {
                    this.javaWaitingList.remove(0);
                    return javaWaitingList;
                }
                case "java priority" -> {
                    this.priorityJavaWaitingList.remove(0);
                    return priorityJavaWaitingList;
                }
                case "c#" -> {
                    this.cWaitingList.remove(0);
                    return cWaitingList;
                }
                case "c# priority" -> {
                    this.priorityCWaitingList.remove(0);
                    return priorityCWaitingList;
                }
                case "data" -> {
                    this.dataWaitingList.remove(0);
                    return dataWaitingList;
                }
                case "data priority" -> {
                    this.priorityDataWaitingList.remove(0);
                    return priorityDataWaitingList;
                }
                case "devops" -> {
                    this.devOpsWaitingList.remove(0);
                    return devOpsWaitingList;
                }
                case "devops priority" -> {
                    this.priorityDevOpsWaitingList.remove(0);
                    return priorityDevOpsWaitingList;
                }
                case "business" -> {
                    this.businessWaitingList.remove(0);
                    return businessWaitingList;
                }
                case "business priority" -> {
                    this.priorityBusinessWaitingList.remove(0);
                    return priorityBusinessWaitingList;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
