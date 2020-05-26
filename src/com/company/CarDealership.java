package com.company;

import java.util.ArrayList;

public class CarDealership {
    private ArrayList<Car> carsList;
    public CarDealership(){
        this.carsList = new ArrayList<Car>();
    }

    public void addCar(Car car){
        if(!queryCar(car)){
            this.carsList.add(car);
            System.out.println("Successfully added car");

        }else {
            System.out.println("Car could not be added");
        }
    }

    public boolean removeCar(int idNumber){
        int position = findCar(idNumber);
        if(findCar(idNumber) >= 0){
            this.carsList.remove(position);
            System.out.println("Car successfully removed");
            return true;
        }

        System.out.println("Error in removing car");
        return false;
    }

    public boolean modifyCar(Car oldCar, Car newCar){
        int position = findCar(oldCar);
        if(!queryCar(oldCar)){
            System.out.println("Car with id #" + oldCar.getIdNumber() + " is not found");
            return false;
        }else if(findCar(newCar) >= 0){
            System.out.println("Car with id #" + newCar.getIdNumber() + " is already in system");
            return false;
        }

        this.carsList.set(position, newCar);
        System.out.println( "Car with id #" + oldCar.getIdNumber() + " has been successfully modified");
        return true;
    }

    public boolean queryCar(Car car){
        if(findCar(car) < 0){
            System.out.println("Car not in Inventory");
            return false;
        }

        System.out.println("Car is found");
        return true;
    }

    public Car queryCar(int idNumber){
        int position = findCar(idNumber);
        if(position >= 0){
            return this.carsList.get(position);
        }

      return null;
    }


    public int findCar(int idNumber){
        for(int i = 0; i < this.carsList.size();i++){
            if(this.carsList.get(i).getIdNumber() == idNumber){
                return i;
            }
        }

        return -1;
    }

    private int findCar(Car car){
        return this.carsList.indexOf(car);
    }

    public void printList(){
        for(int i = 0; i < carsList.size(); i++){
            System.out.println("Car's ID number: " + carsList.get(i).getIdNumber() + " -> " + " Cars Year: " + carsList.get(i).getYear() + " Car's Make: " + carsList.get(i).getMake() + " Car's Model: " + carsList.get(i).getModel());
        }
    }
}
