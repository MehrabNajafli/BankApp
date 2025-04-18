package org.example;

import java.util.Scanner;

public class MiniBankApp {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);
        System.out.println("Please enter the user: ");
        String user = console.nextLine();
        BankAccount bankAccount = new BankAccount(user);
        System.out.println("Account created");
        System.out.println("User: " + bankAccount.getUser());
        System.out.println("Account Number: " + bankAccount.getAccountNumber());
        System.out.println("Card Number: " + bankAccount.getCardNumber());
        System.out.println("PIN : " + bankAccount.getPin());
        System.out.println("Balance: " + bankAccount.getBalance());

        int attempts = 0;
        boolean loggedIN = false;

        while(attempts < 3){
            System.out.println("Enter the user: ");
            String inputUser = console.nextLine();

            System.out.println("Enter the card number: ");
            String inputCardNumber = console.nextLine();

            System.out.println("Enter the pin code: ");
            String inputPin = console.nextLine();

            if(user.equals(inputUser)){
                System.out.println("Valid user, then enter another data: ");
                if(inputCardNumber.equals(bankAccount.getCardNumber()) && inputPin.equals(bankAccount.getPin())) {
                    System.out.println("Data is correct, welcome back");
                    loggedIN = true;
                    break;
                }else {
                    System.out.println("Invalid user info");
                    attempts++;


                }
            }else {
                System.out.println("Invalid user");
                attempts++;
            }


        }
        if(!loggedIN){
            System.out.println("Maximum three amounts, Program will be finished, BYE BYE");
            return;
        }


        int choice;
        do{
            System.out.println("Menu: ");
            System.out.println("1 See balance");
            System.out.println("2 Deposit Money");
            System.out.println("3 Withdraw Money");
            System.out.println("4 Exit");

            System.out.println("Your choice: ");
            choice = console.nextInt();
            console.nextLine();

            switch (choice){
                case 1 -> {
                    System.out.println("Balance: " + bankAccount.getBalance());
                }
                case 2 -> {
                    System.out.println("Enter the amount of deposit: ");
                    double depositAmount = console.nextDouble();
                    bankAccount.deposit(depositAmount);
                }
                case 3 -> {
                    System.out.println("Enter the amount of withdrawn: ");
                    double withdrawAmount = console.nextDouble();
                    bankAccount.withdraw(withdrawAmount);

                }
                case 4 -> {
                    System.out.println("Your choice exit from program, BYE BYE");
                }
                default -> {
                    System.out.println("Not valid choice, try again");

                }

            }





        }while(choice != 4);
        console.close();
    }
}