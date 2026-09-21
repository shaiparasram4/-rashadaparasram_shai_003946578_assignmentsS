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
 * Person.Java: The Person class stores a person's profile information, including their name, age, and marital status. It also connects the person to their addresses and bank account. 
 */

public class Person {

    private String firstName;
    private String lastName;
    private int age;
    private boolean married;

    private Address homeAddress;
    private Address localAddress;
    private BankAccount bankAccount;

    // No-argument constructor
    public Person() {
    }

    // Parameterized constructor
    public Person(String firstName, String lastName,
                  int age, boolean married) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.married = married;
    }

    // Getter and setter methods
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isMarried() {
        return married;
    }

    public void setMarried(boolean married) {
        this.married = married;
    }

    public Address getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(Address homeAddress) {
        this.homeAddress = homeAddress;
    }

    public Address getLocalAddress() {
        return localAddress;
    }

    public void setLocalAddress(Address localAddress) {
        this.localAddress = localAddress;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }
}












































































































































