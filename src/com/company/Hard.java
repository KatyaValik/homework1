package com.company;

public class Hard extends Car{
    double cost = 48.90;
    double fuel = 12;
    Hard(String data) {
        super(data);
    }

    public double GSM(){
        return this.getDistance() / 100 * fuel * cost;
    }
}
