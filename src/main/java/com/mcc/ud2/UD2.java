package com.mcc.ud2;

// <IMPORTS GO HERE>
import java.util.Scanner;

public class UD2 {

    final static String bankName = "Bank of MiraCosta";
    static int netAmount = 0;

    public static void main(String[] args) {
        /***** DECLARATION SECTION *****/
        String[] customersNames = { "Eli", "Kavita", "Oscar", "Brandan", "Josh" };
        String[] transactions = { "Withdraw: 1 ", "Deposit: 2 ", "Payments: 3 " };
        char enterChar;

        /***** OUTPUT SECTION *****/
        System.out.println("=====================================\n");
        System.out.printf("%n%25s%n", bankName);
        System.out.println("");

        // Loop throught the names.
        System.out.println("What is the first name of your account?\n");
        for (String names : customersNames) {
            System.out.printf("%-9s", names);
        }
        System.out.println("");

        // Prompt the user to pick one name from the list of names.
        String readName = "";
        Scanner input = new Scanner(System.in);
        System.out.print("\nName: ");
        readName = input.nextLine();
        boolean results = false;
        for (int i = 0; i < customersNames.length; i++) {
            if (readName.equals(customersNames[i])) {
                results = true;
            }
        }

        // Checks if the name is in the list of names.
        if (results) {
            System.out.printf("%n%15s%s!%n", "Hello ", readName);
        } else {
            System.out.println("Choose from one of the listed names.");
            System.exit(0);
        }

        // Loop through the transactions.
        do {

            // Prompt the user for transations.
            System.out.println("\nWhat transaction would you like to do?\n");
            for (String payType : transactions) {
                System.out.printf("%n%-10s%n", payType);
            }
            System.out.println("");

            // User input to pick which transaction.
            int readTransaction = UtilityBelt.readInt("\nTransaction: ", 1, 4);

            // Transactions.
            Main.transactionHistory(readTransaction);

            // Prompt the user to choose a transaction.
            enterChar = UtilityBelt.readChar("\nWould you like to make another transcation? ", "YyNn");

            // Exit the loop and print final balance.
            if (enterChar == 'N' || enterChar == 'n') {
                if (netAmount > 0) {
                    System.out.printf("%n%s%d%n", "Final Balance is: $", netAmount);
                }
                System.out.println("\nGoodBye! Come Back Again! 👋");
            }

        } while (enterChar == 'Y' || enterChar == 'y');
        System.out.println("\n=====================================");
    }

    /***** STATIC METHODS *****/

    /*
     * Method to go through the user transcation choices and calculates the amount
     * the user has in their account.
     *
     * @params actionOption: a number that decides which transaction to make.
     *
     * @return void.
     */
    public static void transactionHistory(int actionOption) {
        switch (actionOption) {
            // First case to withdraw money from the users account.
            case 1:
                System.out.println("");
                int withdrawAmount = UtilityBelt.readInt("Withdraw Amount: ", 1, 500);
                netAmount = netAmount - withdrawAmount;
                if (netAmount < 0) {
                    System.out.println("\nNot enough to withdraw money.");
                }
                break;
            case 2:
                // Second case to deposit money to the users account.
                System.out.println("");
                int depositAmount = UtilityBelt.readInt("Deposit Amount: ", 1, 5000);
                netAmount = netAmount + depositAmount;
                break;
            case 3:
                // Third case for the user to make a payment.
                System.out.println("");
                int paymentAmount = UtilityBelt.readInt("Payment Amount: ", 1, 500);
                netAmount = netAmount - paymentAmount;
                if (netAmount < 0) {
                    System.out.println("\nNot enough to make a payment");
                }
                break;
            default:
                // Default if the user didn't choose from the options 1-3.
                System.out.println("\nMust be one of the selected transactions");
                break;
        }

        // Print current balance if the balance is greater than 0.
        if (netAmount > 0) {
            System.out.printf("%n%s%d%n", "Current Balance is: $", netAmount);
        }
    }
}

