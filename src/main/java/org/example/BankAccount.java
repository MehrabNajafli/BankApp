package org.example;

import java.util.Random;
import java.util.UUID;

public class BankAccount {

    //Məlumatlar:
    private String accountNumber;
    private String cardNumber;
    private String pin;
    private double balance;
    private String user;

    public BankAccount(String user) {
        this.accountNumber = generateAccountNumber();
        this.cardNumber = generateCardNumber();
        this.pin = generatePin();
        this.balance = 0.0;
        this.user = user;
    }

    // Metodlar:


    public void deposit(double amount){
        if(amount > 0){
           balance = amount + balance;
            System.out.println("Money deposit is succesfull: " + balance);
        }
        else {
            System.out.println("Deposit money cannot be less than zero");
        }
    }


    public void withdraw(double amount){
        if(amount <= 0) {
            System.out.println("Withdraw amount must be more than 0");
        } else if (balance < amount) {
            System.out.println("There are not enough balance of money: " + balance);

        } else {
            balance = balance - amount;
            System.out.println("Your current balance after withdraw will be : " + balance);
        }
    }


    private String generateAccountNumber(){
    String uuid = UUID.randomUUID().toString().replace("-","").toUpperCase();
    return "ACC" + uuid.substring(0,10);
    }


    private String generateCardNumber(){
        Random random = new Random();
        StringBuilder cardNumber = new StringBuilder();
        for(int i = 0; i < 16; i++){
            int digit = random.nextInt(10);
            cardNumber.append(digit);
        }
        return cardNumber.toString();
    }

    private String  generatePin(){
        Random random = new Random();
        int pinNum = 1000 + random.nextInt(9000);
        return String.valueOf(pinNum);

    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getPin() {
        return pin;
    }

    public double getBalance() {
        return balance;
    }

    public String getUser() {
        return user;
    }
}
