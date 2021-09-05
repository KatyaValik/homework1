package com.company;

public class Crane extends Car{
    double cost = 48.90;
    double fuel = 20;
    Crane(String data) {
        super(data);
    }
    public double GSM(){
        return this.getDistance() / 100 * fuel * cost;
    }
}
