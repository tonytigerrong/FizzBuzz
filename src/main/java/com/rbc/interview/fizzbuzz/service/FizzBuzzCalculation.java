package com.rbc.interview.fizzbuzz.service;

import com.rbc.interview.fizzbuzz.utils.CalculateSession;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.stream.IntStream;

@Service
@Slf4j
public class FizzBuzzCalculation {

    private static Logger logger = LoggerFactory.getLogger(FizzBuzzCalculation.class);

    public void printDefaultHundredSeeds(){
        IntStream hundredSeeds = IntStream.range(1, 101);
        hundredSeeds.forEach( i -> {
            try {
                calculateFizzBuzz(i);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public String calculateFizzBuzz(Integer seed) throws Exception {
        String result = "";
        // here is just custom create an exception to show the exception handler works
        if( seed == 111 ) {
            throw new Exception();
        }
        if( seed % 3 == 0 && seed % 5 == 0 ) {
            result = "FizzBuzz";
        } else if( seed % 3 == 0 ) {
            result = "Fizz";
        } else if ( seed % 5 == 0 ) {
            result = "Buzz";
        } else {
            result = String.valueOf(seed);
        }
        logger.info("{}",result);
        return result;
    }

    /**
     * session: key=sessionId, value=seed
     * 1. get session seed value via sessionId
     * 2. if find, session seed value + 1, then calculate
     * 3. if not find, print 1-100 result, then calculate 101
     * 4. put sessionId, value
     */
    public String findNext(String sessionId) throws Exception {
        Integer val = (Integer) CalculateSession.sessions.get(sessionId);
        if(val != null) {
            CalculateSession.sessions.put(sessionId, val+1);
            return calculateFizzBuzz(val+1);
        } else {
            printDefaultHundredSeeds(); //print 1-100 result
            String result = calculateFizzBuzz(101);
            CalculateSession.sessions.put(sessionId, 101);
            return result;
        }
    }
}
