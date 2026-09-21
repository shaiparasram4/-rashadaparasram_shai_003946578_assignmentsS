/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Personprofile;

/**
 *Shai Rashada-Parasram
 * INFO 5100
 * 9/17/2026
 * @author shai8
 * BankAccount.Java: The BankAccount class stores a person's banking information, including their account number, balance, and account status. It uses constructors, getters, and setters to create, access, and update account details.
 */

public class BankAccount {

    // Instance variables
    private String personName;
    private String bankName;
    private String accountNumber;
    private String accountType;
    private double balance;
    private float interestRate;
    private boolean active;

    // No-argument constructor
    public BankAccount() {
    }

    // Parameterized constructor
    public BankAccount(String personName,
                       String bankName,
                       String accountNumber,
                       String accountType,
                       double balance,
                       float interestRate,
                       boolean active) {

        this.personName = personName;
        this.bankName = bankName;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.balance = balance;
        this.interestRate = interestRate;
        this.active = active;
    }

    // Getter and setter methods

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public float getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(float interestRate) {
        this.interestRate = interestRate;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
