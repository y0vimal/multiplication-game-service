package com.demo.microservice.multiplicationgameservice.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MultiplicationResultAttempt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String userId;
    private int attemptId;
    private String multiplication;
    private String userEnteredValue;
    private String isCorrect;

    public MultiplicationResultAttempt() {
    }

    public MultiplicationResultAttempt(String userId, int attemptId, String multiplication, String userEnteredValue, String isCorrect) {
        this.userId = userId;
        this.attemptId = attemptId;
        this.multiplication = multiplication;
        this.userEnteredValue = userEnteredValue;
        this.isCorrect = isCorrect;
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

    public String getMultiplication() {
        return multiplication;
    }

    public void setMultiplication(String multiplication) {
        this.multiplication = multiplication;
    }

    public String getUserEnteredValue() {
        return userEnteredValue;
    }

    public void setUserEnteredValue(String userEnteredValue) {
        this.userEnteredValue = userEnteredValue;
    }

    public String getIsCorrect() {
        return isCorrect;
    }

    public void setIsCorrect(String isCorrect) {
        this.isCorrect = isCorrect;
    }
}
