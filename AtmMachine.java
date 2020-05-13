import java.util.Scanner;
import java.util.Date;
/**
 * Author:Aristotelis Kondylis
 * Programming 1
 * This is a class used to access bank accounts
 */
public class AtmMachine {
    private static Scanner in ;
    private static double balance = 0; // initial balance to 0 for everyone
    private static int anotherTransaction;
    /**
     * This is the main method
     * @param args
     */
    public static void main(String args[]) {
        in = new Scanner(System.in);
        String accountName;
        System.out.println("Welcome to Gold Financial:\n\n Please choose your account name.");
        accountName = in.nextLine();
        System.out.println("Hello " + accountName);
        System.out.println("How much money would you like to add to your account balance: ");
        while (!in.hasNextDouble()){
            System.out.println("Sorry that in not an appropriate value.Please try again.\n\n");
            in.next(); 
        }
        balance = in.nextDouble();
        // call our transaction method here
        transaction();
    }
    /**
     * This is the transaction method
     */
    private static void transaction() {
        // here is where most of the work is
        int choice;
        
            System.out.println("Please select an option");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Balance");
            System.out.println("4. Transfer between accounts");
        choice = in .nextInt();
        switch (choice) {
            case 1:
                double amount;
                System.out.println("Please enter amount to withdraw: ");
                amount = in .nextDouble();
                if (amount > balance || amount == 0) {
                    System.out.println("You have insufficient funds\n\n");
                    anotherTransaction(); // ask if they want another transaction
                } else {
                    // they have some cash
                    // update balance
                    balance = balance - amount;
                    System.out.println("You have withdrawn " + amount + " and your new balance is " + balance + "\n");
                    anotherTransaction();
                }
                break;
            case 2:
                // option number 2 is depositing
                double deposit;
                System.out.println("Please enter amount you would wish to deposit: ");
                deposit = in .nextDouble();
                // update balance
                balance = deposit + balance;
                System.out.println("You have deposited " + deposit + " new balance is " + balance + "\n");
                anotherTransaction();
                break;
            case 3:
                // this option is to check balance
                System.out.println("Your balance is " + balance + "\n");
                anotherTransaction();
                break;
            
            case 4:
                // this option is for transfering between accounts
                double transferamount;
                double newbalance;
                System.out.println("Please enter the amount you would wish to transfer: ");
                transferamount = in .nextDouble();
                //update second account balance
                System.out.println("Your second accounts balance is " + transferamount + "\n");
                newbalance = balance - transferamount;
                System.out.println("Your first accounts balance is now " + newbalance + "\n");
                anotherTransaction();
                break;
            default:
                System.out.println("Invalid option:\n\n");
                anotherTransaction();
                break;
            }
        }
    /**
     * This is the anotherTransaction method
     */
    private static void anotherTransaction() {
        System.out.println("Do you want another transaction?\n\nPress 1 for another transaction\n0 To exit");
        anotherTransaction = in .nextInt();
        if (anotherTransaction == 1) {
            transaction(); // call transaction method
        } else if (anotherTransaction == 0) {
            System.out.println("Thanks for choosing us. Good Bye!");
            Date today= new Date();
            System.out.println(today);
        } else {
            System.out.println("Invalid choice\n\n");
            anotherTransaction();
        }
    }
}