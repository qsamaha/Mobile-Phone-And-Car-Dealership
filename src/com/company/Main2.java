package com.company;

import javax.sound.midi.Soundbank;
import java.util.Scanner;

public class Main2 {

    private static Scanner scan = new Scanner(System.in);
    private static CarDealership carDealership = new CarDealership();
    public static void main(String[] args) {
        appStartUp();
        printInstructions();
        boolean flag = true;
        while(flag){
            System.out.println("Enter Action: ");
            int action = scan.nextInt();
            switch(action){
                case 0:
                    printInstructions();
                    break;
                case 1:
                    displayVehicles();
                    break;
                case 2:
                    addVehicles();
                    break;
                case 3:
                    modifyVehicles();
                    break;
                case 4:
                    removeVehicles();
                    break;
                case 5:
                    searchVehicles();
                    break;
                case 6:
                    flag = false;
                    break;
            }
        }

    }

    private static void appStartUp(){
        System.out.println("Application is starting up....");
    }

    private static void printInstructions(){
        System.out.println("Instructions for using application (0 - print instructions)");
        System.out.println("1 - Display Vehicles in Inventory");
        System.out.println("2 - Add Vehicle to Inventory");
        System.out.println("3 - Modify Vehicle in Inventory");
        System.out.println("4 - Remove Vehicle from Inventory");
        System.out.println("5 - Search For a Vehicle By ID number");
        System.out.println("6 - Quit Application");
    }

    private static void displayVehicles(){
        carDealership.printList();
    }

    private static void addVehicles(){
        int idNumber;
        int year;
        String make;
        String model;
        System.out.println("Enter ID Number: ");
        idNumber = scan.nextInt();
        scan.nextLine();
        if(carDealership.findCar(idNumber) >= 0){
            System.out.println("Car ID is used in system. Try Another.");
            return;
        }else {
            System.out.println("Enter Car Year: ");
            year = scan.nextInt();
            scan.nextLine();
            System.out.println("Enter Car Make: ");
            make = scan.nextLine();
            System.out.println("Enter Car Model: ");
            model = scan.nextLine();
        }

        Car newCar = Car.createCar(idNumber, year, make, model);
        carDealership.addCar(newCar);
    }

    public static void modifyVehicles(){
        System.out.println("Enter Car ID Number You Would Like To Modify: ");
        int userNum = scan.nextInt();
        scan.nextLine();
        Car oldCar = carDealership.queryCar(userNum);
        if(oldCar == null){
            System.out.println("Car was not found");
        }

        System.out.println("Enter new car ID number: ");
        int userId = scan.nextInt();
        scan.nextLine();
        System.out.println("Enter Car Year: ");
        int year = scan.nextInt();
        scan.nextLine();
        System.out.println("Enter Car Make: ");
        String make = scan.nextLine();
        System.out.println("Enter Car Model: ");
        String model = scan.nextLine();


        Car newCar = Car.createCar(userId, year, make, model);
        if(carDealership.modifyCar(oldCar, newCar)){
            System.out.println("Car successfully updated!");
        }else{
            System.out.println("Was not able to update vehicle :(");
        }
    }

    public static void removeVehicles(){
        System.out.println("Enter id number for vehicle you would like to remove: ");
        int removeId = scan.nextInt();
        scan.nextLine();

        if(carDealership.removeCar(removeId)){
            System.out.println(":)");
        }else{
            System.out.println(":(");
        }
    }

    public static void searchVehicles(){
        System.out.println("Enter Id number for vehicle you are searching for: ");
        int userID = scan.nextInt();
        Car userCar = carDealership.queryCar(userID);

        if(carDealership.queryCar(userCar)){
            System.out.println(":)");
        }else{
            System.out.println(":(");
        }
    }
}
