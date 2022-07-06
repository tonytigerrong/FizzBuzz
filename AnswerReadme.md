FizzBuzz Spring Boot Challenge:

As we live in a world full of fizziness and buzziness, we invite you to implement the classic children’s game “Fizz buzz”.

1. Develop a small Spring Boot microservice that clearly demonstrates the Fizz Buzz algorithm by echoing the results on to the screen based on the following:
   
2. Iterate through a sequence of numbers (1..100)
   
   ==Answer: [FizzBuzzCalculation.printDefaultHundredSeeds](./src/main/java/com/rbc/interview/fizzbuzz/service/FizzBuzzCalculation.java)==
3. For multiples of three, print ‘Fizz’ instead of the number.
4. For multiples of five, print ‘Buzz’ instead of the number.
5. For numbers that are multiples of both three and five, print ‘FizzBuzz’ instead of the number.
6. For every other number, simply print the number.
   
   ==Answer: [FizzBuzzCalculation.calculateFizzBuzz](./src/main/java/com/rbc/interview/fizzbuzz/service/FizzBuzzCalculation.java)==
7. Convert this to a maven project.
   
   ==Answer: [pom.xml](./pom.xml)==
8. For extra merit, retro-fit your implementation with unit tests to prove out the algorithm.
   
   ==Answer: [FizzBuzzCalculationTest](./src/test/java/com/rbc/interview/fizzbuzz/sevice/FizzBuzzCalculationTest.groovy)
9. For extra extra merit, convert to fully-fledged RESTFUL implementation implementing a next() endpoint to advance the sequence from 1..100 (thereby removing your previous iteration construct).
   a. Note: the next() call should return the current result (as well as continuing to print to screen).
   b. Note: as the sequence is now being enhanced via a REST call, this implies that this is now a stateful microservice. This is perfectly OK in this instance.
   
   ==Answer: [FizzbuzzController.next](./src/main/java/com/rbc/interview/fizzbuzz/controller/FizzbuzzController.java)==
10. For super extra extra merit, wrap the whole thing with some form of integration test to assert that all the high-level REST calls are returning the correct values.
    a. Note: You need go no further than asserting against a single “Fizz”, a single “Buzz” and a single “FizzBuzz”.
    
    ==Answer: [ControllerIntegrationTest](./src/test/java/com/rbc/interview/fizzbuzz/controller/ControllerIntegrationTest.java)==
    

The only requirements are that you use Java 8 (or above) with the latest rendition of Spring Boot. Any lower-level implementation decisions are your own.

==Answer: ==

package command: mvn clean package

test command: mvn clean test

run command: java -jar fizzbuzz-0.0.1-SNAPSHOT.jar

test by browser: http://localhost:8080/fizzbuzz/next

test by postman: [import this file to postman](./test.postman.collection)

Please note that using 3rd party tooling for code generation that is coupled to a particular IDE or requires plugin installation against the IDE is somewhat frowned upon. The solution should be completely de-coupled and able to be imported directly into any modern Java IDE. It is also important that one can simply package this up to a single FAT jar to be executed from the command line.

To submit, please check your solution in to a new git repository on github.com (if you don’t have an account, could you please create a temporary one for the purposes of this test and submit the link to the repository)