package com.demo.microservice.multiplicationgameservice.resources;

import antlr.StringUtils;
import com.demo.microservice.multiplicationgameservice.models.MultiplicationResultAttempt;
import com.demo.microservice.multiplicationgameservice.models.Result;
import com.demo.microservice.multiplicationgameservice.models.Users;
import com.demo.microservice.multiplicationgameservice.repositories.MultiplicationResultAttemptRepository;
import com.demo.microservice.multiplicationgameservice.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/results")
public class ResultResourceController {

    @Autowired
    private MultiplicationResultAttemptRepository multiplicationResultAttemptRepository;
    @Autowired
    private UserRepository userRepository;

    @RequestMapping(method = RequestMethod.POST, value = "/")
    public void postResults(@RequestBody Result result){

        /*
        *
        * handle attempt number for the user recieved from request body
        * for  result.userId find the attemp number from datastore
        * if user does not exist then create a entry in the data store with initial attempt no = 1
        * if user exist then find the attempt number use it to populate the MultiplicationResultAttempt Datastore
        * and increment the attempt number and update the User entity with the updated value of the attemptNumber.
        *
        * **/


        String actualValue = Integer.toString(result.getMultiplication().getNum1()*result.getMultiplication().getNum2());

        String isCorrect = result.getResult().equals(actualValue) ? "YES" : "NO";

        int attemptNumber;

        //System.out.println("user databse entries are : " + userRepository.existsById(result.getUserId()));
        if(!userRepository.existsById(result.getUserId())){
            System.out.println("hello");
            Users user = new Users();
            user.setUserId(result.getUserId());
            user.setAttemptId(1);
            attemptNumber = user.getAttemptId();
            userRepository.save(user);

        }else{
            System.out.println("world");
            Users user = userRepository.findById(result.getUserId()).get();
            attemptNumber = user.getAttemptId()+1;
            userRepository.deleteById(result.getUserId());
            user = new Users();
            user.setUserId(result.getUserId());
            user.setAttemptId(attemptNumber);
            userRepository.save(user);
        }
        System.out.println("attemptNumer  : " + attemptNumber);

        multiplicationResultAttemptRepository.save(new MultiplicationResultAttempt(
                result.getUserId(),
                attemptNumber,
                new StringBuilder(Integer.toString(result.getMultiplication().getNum1()) + "*" + Integer.toString(result.getMultiplication().getNum2())).toString(),
                result.getResult(),
                isCorrect));

    }

    @RequestMapping("/user/{userId}")
    public List<MultiplicationResultAttempt> getUserAttemptResults(@PathVariable String userId){
        List <MultiplicationResultAttempt> multiplicationResultAttemptList = new ArrayList<>();
        multiplicationResultAttemptRepository.findAll().forEach(multiplicationResultAttempt -> {
            if(multiplicationResultAttempt.getUserId().equals(userId)){
                multiplicationResultAttemptList.add(multiplicationResultAttempt);
            }
        });
        return multiplicationResultAttemptList;
    }

}
