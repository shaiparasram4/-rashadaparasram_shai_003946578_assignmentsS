/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.util.ArrayList;
/**
 * Shai Rashada-Parasram
 * INFO5100
 * Assignment: The Class Relationship Model
 * Date: 10/02/2026
 * File: VehicleDirectory.java
 *
 * This class manages the collection of vehicles registered in the
 * vehicle service center system. It allows vehicles to be added,
 * searched, viewed, and deleted.
 * 
 * @author shai8
 */
public class VehicleDirectory {

    private ArrayList<Vehicle> vehicleList;

    // Constructor
    public VehicleDirectory() {
        vehicleList = new ArrayList<>();
    }

    // Returns the complete list of vehicles
    public ArrayList<Vehicle> getVehicleList() {
        return vehicleList;
    }

    // Adds a new blank vehicle to the directory
    public Vehicle addVehicle() {
        Vehicle newVehicle = new Vehicle();
        vehicleList.add(newVehicle);
        return newVehicle;
    }

    // Adds an existing vehicle object to the directory
    public void addVehicle(Vehicle vehicle) {
        vehicleList.add(vehicle);
    }

    // Deletes a vehicle from the directory
    public void deleteVehicle(Vehicle vehicle) {
        vehicleList.remove(vehicle);
    }

    // Searches for a vehicle by vehicle ID
    public Vehicle searchVehicleById(int vehicleId) {

        for (Vehicle vehicle : vehicleList) {
            if (vehicle.getVehicleId() == vehicleId) {
                return vehicle;
            }
        }

        return null;
    }

    // Searches for all vehicles with the same model name
    public ArrayList<Vehicle> searchVehicleByName(String vehicleName) {

        ArrayList<Vehicle> matchingVehicles = new ArrayList<>();

        for (Vehicle vehicle : vehicleList) {

            if (vehicle.getModel() != null
                    && vehicle.getModel().equalsIgnoreCase(vehicleName)) {

                matchingVehicles.add(vehicle);
            }
        }

        return matchingVehicles;
    }

    // Searches for a vehicle by registration number
    public Vehicle searchVehicleByRegistrationNumber(String registrationNumber) {

        for (Vehicle vehicle : vehicleList) {

            if (vehicle.getRegistrationNumber() != null
                    && vehicle.getRegistrationNumber()
                              .equalsIgnoreCase(registrationNumber)) {

                return vehicle;
            }
        }

        return null;
    }
}
