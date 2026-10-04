/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 * Shai Rashada-Parasram
 * INFO5100
 * Assignment: The Class Relationship Model 
 * 10/02/2026
 * File: Service.java
 * 
 * This class represents the service offered by the vehicle service center.
 * The class will store the service ID, Service type, cost, mechanic name,
 * and the duration of the service
 * 
 * @author shai8
 */
public class Service {

    private int serviceId;
    private String serviceType;
    private double cost;
    private String mechanicName;
    private short serviceDuration;

    // Default constructor
    public Service() {
    }

    // Constructor with all service details
    public Service(int serviceId, String serviceType, double cost,
                   String mechanicName, short serviceDuration) {

        this.serviceId = serviceId;
        this.serviceType = serviceType;
        this.cost = cost;
        this.mechanicName = mechanicName;
        this.serviceDuration = serviceDuration;
    }

    // Getter for service ID
    public int getServiceId() {
        return serviceId;
    }

    // Setter for service ID
    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    // Getter for service type
    public String getServiceType() {
        return serviceType;
    }

    // Setter for service type
    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    // Getter for service cost
    public double getCost() {
        return cost;
    }

    // Setter for service cost
    public void setCost(double cost) {
        this.cost = cost;
    }

    // Getter for mechanic name
    public String getMechanicName() {
        return mechanicName;
    }

    // Setter for mechanic name
    public void setMechanicName(String mechanicName) {
        this.mechanicName = mechanicName;
    }

    // Getter for service duration
    public short getServiceDuration() {
        return serviceDuration;
    }

    // Setter for service duration
    public void setServiceDuration(short serviceDuration) {
        this.serviceDuration = serviceDuration;
    }

    // Helps display the service name inside a JComboBox
    @Override
    public String toString() {
        return serviceType;
    }
}
