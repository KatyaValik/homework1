package com.company;

public class Passenger extends Car{
    double cost = 47.50;
    double fuel = 11.5;
    Passenger(String data) {
        super(data);
    }
    public double GSM(){
        return this.getDistance() / 100 * fuel * cost;
    }
}
