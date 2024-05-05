package com.pluralsight;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class Main {
    private static final Scanner userInput = new Scanner(System.in);

    // Show the user all the options they have
    public static void main(String[] args) {
        String choice = "";
        while (!choice.equals("X")) {
           // try {
                // Welcome the user to the program
                System.out.println("Hello, Welcome to your very own business and personal expense tracker!");
                System.out.println("-".repeat(70));

                System.out.println("What service would you like to access?");
                System.out.println("D.) Add Deposits");
                System.out.println("P.) Make Payment");
                System.out.println("L.) Ledger");
                System.out.println("X.) Exit");

                choice = userInput.nextLine().toUpperCase();
                switch (choice) {
                    case "D":
                        addDeposit();
                        break;
                    case "P":
                        addPayment();
                        break;
                    case "L":
                        LedgerDisplay.showLedgerScreen();
                        break;
                    case "X":
                        System.out.println("Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid input, Press Enter to try again.");
                        userInput.nextLine();
                        System.out.println();
                        break;

                }
//            } catch (Exception exception) {
//                System.out.println("An error occurred: " );
//
//            }
        }
    }
    public static void addDeposit(){
        System.out.println("Deposits");
        System.out.println();
        System.out.print("Enter description: ");
        String description = userInput.nextLine();

        System.out.println("Enter vendor: ");
        String vendor = userInput.nextLine();


        System.out.println("Enter amount of payment: ");
        double amount = Double.parseDouble(userInput.nextLine());

        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();

        Transactions deposit = new Transactions(date, time, description, vendor, amount);

        try
        {
            FileWriter writer = new FileWriter("files/transactions.csv");
            writer.write(deposit.csvString() + "\n");
            writer.close();
        }catch (IOException exception){
            System.out.println("Sorry we ran into a problem: " + exception.getMessage());
        }
    }



    public static void addPayment(){
        System.out.println("Payments");
        System.out.println();
        System.out.print("Enter Payment description: ");
        String description = userInput.nextLine();

        System.out.println("Enter vendor: ");
        String vendor = userInput.nextLine();


        System.out.println("Enter amount of payment: ");
        double amount = Double.parseDouble(userInput.nextLine());
            amount *= -1;
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();

        Transactions payment = new Transactions(date, time, description, vendor, amount);

        try
        {
            FileWriter writer = new FileWriter("files/transactions.csv");
            writer.write(payment.csvString() + "\n");
            writer.close();
        }catch (IOException exception){
            System.out.println("Sorry we ran into a problem: " + exception.getMessage());
        }



    }
}
