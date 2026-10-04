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
 * File: Vehicle.java
 *
 * This class represents a vehicle registered in the service center.
 * It stores vehicle information and connects the vehicle to an Owner
 * and one selected Service.
 *
 * @author shai8
 */
public class Vehicle {

    private int vehicleId;
    private String make;
    private String model;
    private int year;
    private String registrationNumber;
    private String serviceDate;

    private Owner owner;
    private Service service;

    // Default constructor
    public Vehicle() {
    }

    // Constructor with all vehicle details
    public Vehicle(int vehicleId, String make, String model, int year,
                   String registrationNumber, String serviceDate,
                   Owner owner, Service service) {

        this.vehicleId = vehicleId;
        this.make = make;
        this.model = model;
        this.year = year;
        this.registrationNumber = registrationNumber;
        this.serviceDate = serviceDate;
        this.owner = owner;
        this.service = service;
    }

    // Getter for vehicle ID
    public int getVehicleId() {
        return vehicleId;
    }

    // Setter for vehicle ID
    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    // Getter for make
    public String getMake() {
        return make;
    }

    // Setter for make
    public void setMake(String make) {
        this.make = make;
    }

    // Getter for model
    public String getModel() {
        return model;
    }

    // Setter for model
    public void setModel(String model) {
        this.model = model;
    }

    // Getter for year
    public int getYear() {
        return year;
    }

    // Setter for year
    public void setYear(int year) {
        this.year = year;
    }

    // Getter for registration number
    public String getRegistrationNumber() {
        return registrationNumber;
    }

    // Setter for registration number
    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    // Getter for service date
    public String getServiceDate() {
        return serviceDate;
    }

    // Setter for service date
    public void setServiceDate(String serviceDate) {
        this.serviceDate = serviceDate;
    }

    // Getter for owner
    public Owner getOwner() {
        return owner;
    }

    // Setter for owner
    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    // Getter for service
    public Service getService() {
        return service;
    }

    // Setter for service
    public void setService(Service service) {
        this.service = service;
    }

    // Displays basic vehicle information when needed in the UI
    @Override
    public String toString() {
        return make + " " + model;
    }
}
