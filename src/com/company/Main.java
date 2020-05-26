package com.company;

import java.util.Scanner;

public class Main {

    private static Scanner scan = new Scanner(System.in);
    public static MobilePhone mobilePhone = new MobilePhone("734 353 5566");
    public static void main(String[] args) {

        boolean quit = false;
        startPhone();
        printActions();
        while(!quit){
            System.out.println("Enter Action: (0 to show available actions)");
            int action = scan.nextInt();
            scan.nextLine();
            switch (action){
                case 0:
                    printActions();
                    break;
                case 1:
                    printContacts();
                    break;
                case 2:
                    addNewContact();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    queryContact();
                    break;
                case 6:
                    quit = true;
                    break;
                default:
                    System.out.println("Incorrect Try again");
            }
        }
    }

    private static void addNewContact(){
        System.out.println("Enter new contact name: ");
        String name = scan.nextLine();
        System.out.println("Enter new contact phone number: ");
        String phoneNumber = scan.nextLine();
        Contact newContact = Contact.createContact(name, phoneNumber);
        if(mobilePhone.addContact(newContact)){
            System.out.println("New contact added: " + name + " , " + phoneNumber );
        }else{
            System.out.println("Cannot add, " + name + " already on file");
        }
    }

    private static void printContacts(){
        mobilePhone.printContact();
    }

    private static void updateContact(){
        System.out.println("Enter existing contact name: ");
        String name = scan.nextLine();
        Contact existingContactRecord = mobilePhone.queryContact(name);
        if(existingContactRecord == null){
            System.out.println("Contact not found");
            return;
        }

        System.out.println("Enter new contact name: ");
        String newName = scan.nextLine();
        System.out.println("Enter new contact phone number");
        String newNumber = scan.nextLine();
        Contact newContact = Contact.createContact(newName, newNumber);
        if(mobilePhone.updateContact(existingContactRecord, newContact)){
            System.out.println("Successfully updated record");
        }else{
            System.out.println("Error updating record");
        }
    }

    private static void removeContact() {
        System.out.println("Enter existing contact name: ");
        String name = scan.nextLine();
        Contact existingContactRecord = mobilePhone.queryContact(name);
        if (existingContactRecord == null) {
            System.out.println("Contact not found");
            return;
        }

        if(mobilePhone.removeContact(existingContactRecord)){
            System.out.println("Successfully Deleted");
        }else{
            System.out.println("Error Deleting");
        }
    }

    private static void queryContact() {
        System.out.println("Enter existing contact name: ");
        String name = scan.nextLine();
        Contact existingContactRecord = mobilePhone.queryContact(name);
        if (existingContactRecord == null) {
            System.out.println("Contact not found");
            return;
        }

        System.out.println("Name: " + existingContactRecord.getName() + " phone number " + existingContactRecord.getPhoneNumber());
    }


    private static void startPhone(){
        System.out.println("Starting Phone...");
    }

    private static void printActions(){
        System.out.println("Available Actions");
        System.out.println("0 - Print Actions");
        System.out.println("1 - to print out contacts");
        System.out.println("2 - to add a contact");
        System.out.println("3 - to update a contact");
        System.out.println("4 - to remove an existing contact");
        System.out.println("5 - to print a list of available actions");
        System.out.println("Choose your action: ");
    }
}
