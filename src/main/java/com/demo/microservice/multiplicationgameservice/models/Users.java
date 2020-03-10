package com.demo.microservice.multiplicationgameservice.models;

import javax.persistence.*;

@Entity
public class Users {

    @Id
    private String userId;
    private int attemptId;

    public Users() {
    }

    public Users(String userId, int attemptId) {
        this.userId = userId;
        this.attemptId = attemptId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getAttemptId() {
        return attemptId;
    }

    public void setAttemptId(int attemptId) {
        this.attemptId = attemptId;
    }
}
