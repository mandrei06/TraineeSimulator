package model;

public class Person {
    private static String course;
    private int months;

    public int getMonths() {
        return months;
    }

    public void setMonths(int months) {
        this.months = months;
    }

    public Person(String course, int months) {
        this.course = course;
        this.months = months;
    }

    public static String getCourse() {
        return course;
    }

    public static void setCourse(String course) {
        Person.course = course;
    }
}
