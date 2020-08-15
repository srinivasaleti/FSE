package com.fse;

public class Flight {
    private final String name;
    private final int noOfStops;
    private final  String airlines;
    private final double price;

    public Flight(String name, String airlines, double price, int noOfStops) {
        this.name = name.toUpperCase();
        this.noOfStops = noOfStops;
        this.airlines = airlines.toUpperCase();
        this.price = price;
    }


    public String getName() {
        return name;
    }

    public int getNoOfStops() {
        return noOfStops;
    }

    public double getPrice() {
        return price;
    }

    public String getAirlines() {
        return airlines;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "name='" + name + '\'' +
                ", noOfStops=" + noOfStops +
                ", airlines='" + airlines + '\'' +
                ", price=" + price +
                '}';
    }
}
