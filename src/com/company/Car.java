package com.company;

public class Car {
    private int idNumber;
    private int year;
    private String make;
    private String model;

    public Car(int idNumber, int year, String make, String model){
        this.idNumber = idNumber;
        this.year = year;
        this.make = make;
        this.model = model;
    }

    public int getIdNumber(){
        return idNumber;
    }

    public int getYear(){
        return year;
    }

    public String getMake(){
        return make;
    }

    public String getModel(){
        return model;
    }

    public static Car createCar(int idNumber, int year, String make, String model){
        return new Car(idNumber, year, make, model);
    }


}
