/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 * Shai Rashada-Parasram
 * INFO5100
 * Assignment: The Class Relationship Model
 * Date: 10/02/2026
 * File: Owner.java
 *
 * This class represents an owner registered in the vehicle
 * service center system. It stores the owner's ID, first name,
 * and last name.
 * 
 * @author shai8
 */
public class Owner {

    private long ownerId;
    private String firstName;
    private String lastName;

    // Default constructor
    public Owner() {
    }

    // Constructor with all owner details
    public Owner(long ownerId, String firstName, String lastName) {
        this.ownerId = ownerId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // Getter for owner ID
    public long getOwnerId() {
        return ownerId;
    }

    // Setter for owner ID
    public void setOwnerId(long ownerId) {
        this.ownerId = ownerId;
    }

    // Getter for first name
    public String getFirstName() {
        return firstName;
    }

    // Setter for first name
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    // Getter for last name
    public String getLastName() {
        return lastName;
    }

    // Setter for last name
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // Returns the owner's full name
    public String getFullName() {
        return firstName + " " + lastName;
    }

   

// Displays the owner's full name when needed in the UI
    @Override
    public String toString() {
    return getFullName();
    }
}


