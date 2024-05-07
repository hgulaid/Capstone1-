package com.pluralsight;

import java.util.List;
import java.util.Scanner;
import java.util.Collections;


public class LedgerDisplay {

private static final Scanner userInput = new Scanner(System.in);


    public static void showLedgerScreen() {
    //Showing us the transactions/ledger screen here.
    String ledgerChoice = "";
        while (!ledgerChoice.equals("H")) {
        // try {
        // Welcome the user to the program
        System.out.println("Transaction History");
        System.out.println("-".repeat(70));

        System.out.println();
        System.out.println("A.) Show all entries");
        System.out.println("D.) Show only deposits");
        System.out.println("P.) Show only payments");
        System.out.println("R.) Reports");
        System.out.println("H.) Home screen");


        ledgerChoice = userInput.nextLine().toUpperCase();
        switch (ledgerChoice) {
            case "A":
               showAllEntries();
                //addDeposit();
                break;
            case "D":
                showAllDeposits();
                break;
            case "P":
                showAllPayments();
                break;
            case "R":
                ReportsDisplay.showReportsScreen();
                break;
            case "H":
                System.out.println("Goodbye!");
                System.out.println();
                System.out.println();
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

    public static void showAllEntries(){
        System.out.println("All transactions");
        System.out.println("-".repeat(35));
        System.out.println("Date:                         Time:                          Description:                  Vendor:                        Amount:");



        List<Transactions> transactions = FileReader.csvReader("files/transactions.csv");
        Collections.reverse(transactions);


        for (Transactions transaction : transactions){
            System.out.println(transaction);

        }

    }

    public static void showAllDeposits(){
        System.out.println("All Deposits");
        System.out.println("-".repeat(35));
        System.out.println("Date:                         Time:                          Description:                  Vendor:                        Amount:");



        List<Transactions> transactions = FileReader.csvReader("files/transactions.csv");
        Collections.reverse(transactions);


        for (Transactions transaction : transactions){
            if (transaction.getAmount() > 0){
                System.out.println(transaction);

            }

        }

    }

    public static void showAllPayments(){
        System.out.println("All Payments");
        System.out.println("-".repeat(35));
        System.out.println("Date:                         Time:                          Description:                  Vendor:                        Amount:");



        List<Transactions> transactions = FileReader.csvReader("files/transactions.csv");
        Collections.reverse(transactions);


        for (Transactions transaction : transactions){
            if (transaction.getAmount() < 0){
                System.out.println(transaction);

            }

        }

    }


}





