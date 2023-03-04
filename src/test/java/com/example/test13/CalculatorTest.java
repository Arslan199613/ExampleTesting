package com.example.test13;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

   private static int x;
   private static int y;

    static Calculator calculator;

    @BeforeAll
    public static void initFields() {
        x = 10;
        y = 5;
        calculator = new Calculator();
    }
    @AfterAll
    private static void afterAll() {
        System.out.println("Testing is finish!");
    }

    @Test
    void shouldGetSum() {
        Assertions.assertEquals(15,calculator.getSum(x,y)); //Ожидания-реальность
    }

    @Test
    void getDivide() {
        Assertions.assertEquals(2,calculator.getDivide(x,y));
    }

    @Test
    void getMultiple() {
        Assertions.assertEquals(50,calculator.getMultiple(x,y));
    }
}