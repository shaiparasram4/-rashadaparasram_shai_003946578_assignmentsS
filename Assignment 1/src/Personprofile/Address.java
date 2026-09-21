/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Personprofile;

/**
 * Shai Rashada-Parasram
 * INFO 5100
 * 9/17/2026
 * @author shai8
 * Address.Java: The Address Class will store a individuals home or local address information. This class uses constructors, getters, and setters to create and update the address details
 */


public class Address {
    
    // Instances variables
    private String personName;
    private String street;
    private String city;
    private String state;
    private String zipCode;
    private String addressType;

    // No-argument constructor
    public Address() {
    }
   
    // Parameterized constructor
    public Address(String personName, String street,
                   String city, String state,
                   String zipCode, String addressType) {

        this.personName = personName;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.addressType = addressType;
    }
    
   // Getter and setter methods
    public String getPersonName(){
        return personName;
    }
    
    public void setPersonName(String personName){
      this.personName = personName;   
    }
    
    public String getStreet(){
        return street;
    }
    
    public String getCity(){
        return city; 
    }

    public void setCity(String city){
     this.city = city;
    }
    
    public String getState(){
     return state;
    } 
    
    public void setState(String state){
         this.state = state;
    }
     
    public String getZipCode() {
          return zipCode;
    }
    
    public void setZipCode(String zipCode){
        this.zipCode = zipCode;   
    }
    
    public String getAddressType(){
        return addressType;
    } 
    
    public void setAddressType(String addressType) {
        this.addressType = addressType;
    }
   

// Returns the complete address 
public String getFullAddress() {
    return street + ", " + city + ", "
        + state + " " + zipCode;
    } 
      
}



