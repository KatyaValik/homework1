package com.company;

public class Light extends Car{
    double cost = 46.10;
    double fuel = 12.5;
    Light(String data) {
        super(data);
    }
    public double GSM(){
        return this.getDistance() / 100 * fuel * cost;
        
    }
}
