package com.demo.microservice.multiplicationgameservice.resources;

import com.demo.microservice.multiplicationgameservice.models.Multiplication;
import com.demo.microservice.multiplicationgameservice.models.MultiplicationResultAttempt;
import com.demo.microservice.multiplicationgameservice.repositories.MultiplicationResultAttemptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/multiplications")
public class MultiplicationResourceController {

    @Autowired
    private MultiplicationResultAttemptRepository multiplicationResultAttemptRepository;

    @RequestMapping("/random")
    public Multiplication getMutliplicationFactors(){
        Random random = new Random();

        return new Multiplication(random.nextInt(100), random.nextInt(100));
    }

    @RequestMapping("/attempts")
    public List<MultiplicationResultAttempt> getAllAttempts(){
        List<MultiplicationResultAttempt> multiplicationResultAttempts = new ArrayList<>();
        multiplicationResultAttemptRepository.findAll().forEach(MultiplicationResultAttempt -> {
            multiplicationResultAttempts.add(MultiplicationResultAttempt);
        });
        return multiplicationResultAttempts;
    }

}
