package controller;

public class GenerateRandomCourse {
    public String generateRandomCourse() {
        String str = "";
        try {
            String[] courses = new String[5];
            courses[0] = "java";
            courses[1] = "c#";
            courses[2] = "data";
            courses[3] = "devops";
            courses[4] = "business";

            // generating a random number so that we can assign a random course from array
            GenerateRandomNumber gn = new GenerateRandomNumber();
            int randomNumber = gn.generateRandomNumber(0, 5);
            str = courses[randomNumber];
            System.out.println("str " + str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }
}
