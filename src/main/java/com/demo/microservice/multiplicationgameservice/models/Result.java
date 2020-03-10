package com.demo.microservice.multiplicationgameservice.models;

public class Result {
    private String userId;
    private Multiplication multiplication;
    private String result;

    public Result() {
    }

    public Result(String userId, Multiplication multiplication, String result) {
        this.userId = userId;
        this.multiplication = multiplication;
        this.result = result;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Multiplication getMultiplication() {
        return multiplication;
    }

    public void setMultiplication(Multiplication multiplication) {
        this.multiplication = multiplication;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
