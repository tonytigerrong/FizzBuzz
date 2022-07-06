package com.rbc.interview.fizzbuzz.sevice

import com.rbc.interview.fizzbuzz.service.FizzBuzzCalculation
import spock.lang.Specification

class FizzBuzzCalculationTest extends Specification{


    def 'calculateFizzBuzz positive test' () {
        given:
        def fizzBuzzCal = new FizzBuzzCalculation()
        when:
        def r1 = fizzBuzzCal.calculateFizzBuzz(3)
        def r2 = fizzBuzzCal.calculateFizzBuzz(5)
        def r3 = fizzBuzzCal.calculateFizzBuzz(15)
        def r4 = fizzBuzzCal.calculateFizzBuzz(1)
        then:
        assert r1.equals("Fizz") && r2.equals("Buzz") && r3.equals("FizzBuzz")
        assert r4.equals("1")
    }

    def 'calculateFizzBuzz negative test' () {
        given:
        def fizzBuzzCal = new FizzBuzzCalculation()
        when:
        def r1 = fizzBuzzCal.calculateFizzBuzz(3)
        then:
        assert r1.equals("Fizz") && r2.equals("Buzz") && r3.equals("FizzBuzz")
        assert r4.equals("1")
    }
}
