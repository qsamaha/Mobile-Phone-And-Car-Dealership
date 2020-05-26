package com.company;

import java.util.ArrayList;

public class MobilePhone {
    private String myNumber;
    private ArrayList <Contact> contacts;

    public MobilePhone(String myNumber){
        this.myNumber = myNumber;
        this.contacts = new ArrayList<Contact>();
    }

    public boolean addContact(Contact contact){
        if(findContact(contact) >= 0){
            System.out.println("Contact is already on file");
            return false;
        }

        contacts.add(contact);
        return true;
    }

    public boolean updateContact(Contact oldContact, Contact newContact){
        int foundPosition = findContact(oldContact);
        if(foundPosition < 0){
            System.out.println(oldContact.getName() + " was not found");
            return false;
        }else if(findContact(newContact.getName()) >= 0){
            System.out.println("Contact with name " + newContact.getName() + " already exists. Update was not successful");
            return false;
        }

        this.contacts.set(foundPosition, newContact);
        System.out.println(oldContact.getName() + " was replaced with " + newContact.getName());
        return true;
    }

    public boolean removeContact(Contact contact){
        int foundPosition = findContact(contact);
        if(foundPosition < 0){
            System.out.println("Sorry contact was not found");
            return false;
        }else{
            this.contacts.remove(foundPosition);
            System.out.println("Contact was deleted");
            return true;
        }
    }

    private int findContact(Contact contact){
        return this.contacts.indexOf(contact);
    }

    private int findContact(String contactName){
        for(int i = 0; i < this.contacts.size(); i++){
            Contact contact = this.contacts.get(i);
            if(contact.getName().equalsIgnoreCase(contactName)){
                return i;
            }
        }
        return -1;
    }

    public String queryContact(Contact contact){
        if(findContact(contact) >= 0){
            return contact.getName();
        }

        return null;
    }

    public Contact queryContact(String name){
        int position = findContact(name);
        if(position >= 0){
            return this.contacts.get(position);
        }

        return null;
    }

    public void printContact(){
        System.out.println("Contact List: ");
        for(int i = 0; i < contacts.size(); i++){
            System.out.println((i + 1) + ". " +
                    this.contacts.get(i).getName() + " -> " +
                    this.contacts.get(i).getPhoneNumber());
        }
    }
}

