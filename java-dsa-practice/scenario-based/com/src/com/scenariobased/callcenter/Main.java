package com.scenariobased.callcenter;

public class Main {
    public static void main(String[] args) {

        CallCenter center = new CallCenter();

        center.receiveCall(new Customer(1,"Harsh",false));
        center.receiveCall(new Customer(2,"Amit",true));
        center.receiveCall(new Customer(3,"Neha",false));
        center.receiveCall(new Customer(4,"Rahul",true));
        center.receiveCall(new Customer(1,"Harsh",false)); // repeat caller

        center.attendCall();
        center.attendCall();
        center.attendCall();

        center.showCallFrequency();
    }
}
