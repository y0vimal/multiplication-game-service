package com.demo.microservice.multiplicationgameservice.repositories;

import com.demo.microservice.multiplicationgameservice.models.Users;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<Users, String> {

}
