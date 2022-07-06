package com.rbc.interview.fizzbuzz.controller;

import com.rbc.interview.fizzbuzz.model.FizzBuzzReps;
import com.rbc.interview.fizzbuzz.service.FizzBuzzCalculation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class FizzbuzzController {

    @Autowired
    private FizzBuzzCalculation fizzBuzzCalculation;

    @RequestMapping(value = "/fizzbuzz/next", method= RequestMethod.GET)
    public FizzBuzzReps next(HttpSession session) {
        FizzBuzzReps fizzBuzzReps = new FizzBuzzReps();
        String nextValue = fizzBuzzCalculation.findNext(session.getId());
        fizzBuzzReps.setNextValue(nextValue);
        fizzBuzzReps.setSessionId(session.getId());
        return fizzBuzzReps;
    }
}
