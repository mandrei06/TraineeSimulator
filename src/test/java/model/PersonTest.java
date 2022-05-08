package model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {
    private Person person;

    @BeforeEach
    public void setUp() {
        person=new Person("java",1);
    }

    @Test
    void getMonths() {
        boolean expected= person.getMonths()==1;
        Assertions.assertTrue(expected);
    }

    @Test
    void setMonths() {
        person.setMonths(12);
        boolean expected= person.getMonths()==12;
        Assertions.assertTrue(expected);
    }

    @Test
    void getCourse() {
        boolean expected= Objects.equals(Person.getCourse(), "java");
        Assertions.assertTrue(expected);
    }

    @Test
    void setCourse() {
        Person.setCourse("dev");
        boolean expected= Objects.equals(Person.getCourse(), "dev");
        Assertions.assertTrue(expected);
    }
}