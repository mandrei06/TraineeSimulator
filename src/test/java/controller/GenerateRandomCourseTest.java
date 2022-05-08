package controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class GenerateRandomCourseTest {
    private GenerateRandomCourse generateRandomCourse;

    @BeforeEach
    public void setUp() {
        generateRandomCourse = new GenerateRandomCourse();
    }

    @Test
    public void testGenerateRandomCourse() {
        String course = generateRandomCourse.generateRandomCourse();
        boolean expected = false;
        List<String> coursesType = Arrays.asList("java", "c#", "data", "devops", "business");
        if (coursesType.contains(course)) {
            expected = true;
        }
        Assertions.assertTrue(expected);
    }

}


