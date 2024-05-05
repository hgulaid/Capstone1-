package com.pluralsight;

import javax.xml.transform.Source;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
            case "P":
                System.out.println("Invalid input, Press Enter to try again.");
//addPayment();
                break;
            case "R":
                System.out.println(" // call to the ledger screen");
                break;
            case "H":
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

    public static void showAllEntries(){
        List<Transactions> transactions = new ArrayList<>();


    }

}





