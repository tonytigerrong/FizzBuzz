package com.rbc.interview.fizzbuzz.sevice;

import com.rbc.interview.fizzbuzz.service.FizzBuzzCalculation;
import org.junit.Test;
import static org.junit.Assert.*;
public class FizzBuzzCalculationTest {
    FizzBuzzCalculation fizzBuzzCal = new FizzBuzzCalculation();

    @Test
    public void calculateFizzBuzzTest() throws Exception {
        String r1 = fizzBuzzCal.calculateFizzBuzz(3);
        String r2 = fizzBuzzCal.calculateFizzBuzz(5);
        String r3 = fizzBuzzCal.calculateFizzBuzz(15);
        String r4 = fizzBuzzCal.calculateFizzBuzz(1);

        assertEquals(r1, "Fizz");
        assertEquals(r2, "Buzz");
        assertEquals(r3, "FizzBuzz");
        assertEquals(r4, "1");

    }

    @Test
    public void findNextTest() throws Exception {
        String session = "fakesession";
        String r1 = fizzBuzzCal.findNext(session);
        String r2 = fizzBuzzCal.findNext(session);
        assertEquals(r1, "101");
        assertEquals(r2, "Fizz");
    }

    @Test(expected = Exception.class)
    public void errorTest() throws Exception {
        String r1 = fizzBuzzCal.calculateFizzBuzz(111);

    }
}
