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
 * File: ServiceCatalog.java
 *
 * This class manages the collection of services offered by the
 * vehicle service center. It allows services to be added, searched,
 * updated, and deleted.
 * 
 * 
 * @author shai8
 */
public class ServiceCatalog {

    private ArrayList<Service> serviceList;

    // Constructor
    public ServiceCatalog() {
        serviceList = new ArrayList<>();
    }

    // Returns the complete list of services
    public ArrayList<Service> getServiceList() {
        return serviceList;
    }

    // Adds a new service to the catalog
    public Service addService() {
        Service newService = new Service();
        serviceList.add(newService);
        return newService;
    }

    // Adds an existing service object to the catalog
    public void addService(Service service) {
        serviceList.add(service);
    }

    // Deletes a service from the catalog
    public void deleteService(Service service) {
        serviceList.remove(service);
    }

    // Searches for a service by service ID
    public Service searchServiceById(int serviceId) {

        for (Service service : serviceList) {
            if (service.getServiceId() == serviceId) {
                return service;
            }
        }

        return null;
    }

    // Searches for services by service type
    public ArrayList<Service> searchServiceByType(String serviceType) {

        ArrayList<Service> matchingServices = new ArrayList<>();

        for (Service service : serviceList) {
            if (service.getServiceType() != null
                    && service.getServiceType().equalsIgnoreCase(serviceType)) {

                matchingServices.add(service);
            }
        }

        return matchingServices;
    }
}
