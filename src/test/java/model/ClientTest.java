package model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClientTest {
    private Client client;


    @BeforeEach
    public void setUp() {
        client=new Client("java",1,true);
    }

    @Test
    void isHappy() {
        boolean expected= client.isHappy();
        Assertions.assertTrue(expected);
    }

    @Test
    void setHappyFalse() {
        client.setHappy(false);
        boolean expected= client.isHappy();
        Assertions.assertFalse(expected);
    }
    @Test
    void setHappyTrue() {
        client.setHappy(true);
        boolean expected= client.isHappy();
        Assertions.assertTrue(expected);
    }

    @Test
    void generateClient() {
        client.generateClient();
    }
}