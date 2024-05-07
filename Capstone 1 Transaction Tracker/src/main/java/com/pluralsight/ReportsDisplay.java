package com.pluralsight;

import javax.xml.transform.Source;
import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;
import java.util.List;


public class ReportsDisplay {
    private static final Scanner userInput = new Scanner(System.in);

    public static void showReportsScreen() {
        int choice = -1;

        while (choice != 0) {
            try {
                // Welcome the user to the program
                System.out.println("Search Transactions");
                System.out.println("-".repeat(70));

                System.out.println();
                System.out.println("1.) Month to Date Transactions");
                System.out.println("2.) Previous Month Transactions");
                System.out.println("3.) Year to Date Transactions");
                System.out.println("4.) Previous Year Transactions");
                System.out.println("5.) Search by Vendor");
                System.out.println("0.) Back to Reports");


                choice = userInput.nextInt();
                switch (choice) {
                    case 1:
                        monthToDateTransactions();
                        break;
                    case 2:
                        previousMonthTransactions();
                        System.out.println("sdfsdf");
                        break;
                    case 3:
                        yearToDateTransactions();
                        break;
                    case 4:
                        previousYearTransactions();
                        break;
                    case 5:
                        //searchByVendor();
                        System.out.println();
                        System.out.println("-".repeat(150));
                        System.out.println("Press Enter to Return");
                        userInput.nextLine();


                        break;
                    case 0:
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
                System.out.println();
            } catch (InputMismatchException e) {
                userInput.nextLine();
                System.out.println("Invalid input please enter a number.");
                System.out.println();
                System.out.println();

            }catch (Exception exception)
            {
                System.out.println();
                System.out.println("Sorry, we encountered a problem.");
                System.out.println();
                System.out.println();

            }
        }
    }
    public static void monthToDateTransactions(){
        LocalDate today = LocalDate.now();
        LocalDate startOfMonth = today.withDayOfMonth(1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        System.out.println("Transactions from start of this month to today");
        System.out.println("-".repeat(70));

        List<Transactions> transactions = FileReader.csvReader("files/transactions.csv");
        for (Transactions transaction: transactions){
            if (!transaction.getDate().isBefore(startOfMonth) && !transaction.getDate().isAfter(today)){
                System.out.println(transaction);
            }
        }

    }

    public static void previousMonthTransactions() {
        LocalDate today = LocalDate.now();
        LocalDate firstDayOfCurrentMonth = today.withDayOfMonth(1);
        LocalDate firstDayOfPreviousMonth = firstDayOfCurrentMonth.minusMonths(1);
        LocalDate lastDayOfPreviousMonth = firstDayOfCurrentMonth.minusDays(1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        System.out.println("Transactions from the previous month");
        System.out.println("-".repeat(70));
        System.out.println("Date:                          Time:                          Description:                  Vendor:                        Amount:");

        List<Transactions> transactions = FileReader.csvReader("files/transactions.csv");

        for (Transactions transaction : transactions) {
            LocalDate transactionDate = transaction.getDate();
            if (!transactionDate.isBefore(firstDayOfPreviousMonth) && !transactionDate.isAfter(lastDayOfPreviousMonth)) {
                System.out.println(transaction);
            }
        }
    }





    public static void yearToDateTransactions(){
        LocalDate today = LocalDate.now();
        LocalDate startOfYear = today.withDayOfYear(1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        System.out.println("Transactions from start of the year to today");
        System.out.println("-".repeat(70));



        System.out.println("Date:                          Time:                          Description:                  Vendor:                        Amount:");

        List<Transactions> transactions = FileReader.csvReader("files/transactions.csv");

        for (Transactions transaction : transactions) {
            LocalDate transactionDate = transaction.getDate();
            if (!transactionDate.isBefore(startOfYear) && !transactionDate.isAfter(today)) {
                System.out.println(transaction);
            }
        }
    }



    public static void previousYearTransactions() {
        LocalDate today = LocalDate.now();
        LocalDate startOfCurrentYear = today.withDayOfYear(1);
        LocalDate startOfPreviousYear = startOfCurrentYear.minusYears(1);
        LocalDate endOfPreviousYear = startOfCurrentYear.minusDays(1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");


        System.out.println("Transactions from the previous year");
        System.out.println("-".repeat(70));

        System.out.println("Date:                          Time:                          Description:                  Vendor:                        Amount:");

        List<Transactions> transactions = FileReader.csvReader("files/transactions.csv");

        for (Transactions transaction : transactions) {
            LocalDate transactionDate = transaction.getDate();
            if (!transactionDate.isBefore(startOfPreviousYear) && !transactionDate.isAfter(endOfPreviousYear)) {
                System.out.println(transaction);
            }
        }
    }







    public static void searchByVendor() {
        System.out.println("Enter the vendor name to search: ");
        String vendorName = userInput.nextLine();

        List<Transactions> transactions = FileReader.csvReader("files/transactions.csv");

        //boolean found = false;

        for (Transactions transaction : transactions) {
            if (transaction.getVendor().equalsIgnoreCase(vendorName)) {
                System.out.println(transactions);
              //  found = true;
            }
        }

      //  if (!found) {
       //     System.out.println("No transactions found for vendor: " + vendorName);
      //  }
    }
}


