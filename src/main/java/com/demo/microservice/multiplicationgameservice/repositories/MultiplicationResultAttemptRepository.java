package com.demo.microservice.multiplicationgameservice.repositories;

import com.demo.microservice.multiplicationgameservice.models.MultiplicationResultAttempt;
import org.springframework.data.repository.CrudRepository;

public interface MultiplicationResultAttemptRepository extends CrudRepository<MultiplicationResultAttempt, Integer> {

}
