package com.company;

public class Ride {
    String source;
    String destination;
    Double price;

    public Ride(String source, String destination) {
        this.source = source;
        this.destination = destination;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
