package in.codesoft.tasks;

import java.util.Scanner;
import java.util.InputMismatchException;

public class ATM {

    private BankAccount account;
    private Scanner scanner;

    public ATM(BankAccount account) {
        this.account = account;
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        int choice = -1;

        while (choice != 4) {
            System.out.println("\n====== ATM MACHINE ======");
            System.out.println("1. Withdraw Money");
            System.out.println("2. Deposit Money");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        handleWithdraw();
                        break;
                    case 2:
                        handleDeposit();
                        break;
                    case 3:
                        handleCheckBalance();
                        break;
                    case 4:
                        System.out.println("Thank you for using ATM!");
                        break;
                    default:
                        System.out.println("Invalid choice!");
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Enter numeric value.");
                scanner.next();
            }
        }
    }

    private void handleWithdraw() {
        System.out.print("Enter amount to withdraw: ");
        try {
            double amount = scanner.nextDouble();
            if (account.withdraw(amount)) {
                System.out.println("Withdrawal successful!");
                System.out.println("Remaining Balance: " + account.getBalance());
            } else {
                System.out.println("Transaction failed!");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid amount.");
            scanner.next();
        }
    }

    private void handleDeposit() {
        System.out.print("Enter amount to deposit: ");
        try {
            double amount = scanner.nextDouble();
            if (account.deposit(amount)) {
                System.out.println("Deposit successful!");
                System.out.println("Updated Balance: " + account.getBalance());
            } else {
                System.out.println("Invalid deposit amount.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid amount.");
            scanner.next();
        }
    }

    private void handleCheckBalance() {
        System.out.println("\nAccount Holder: " + account.getAccountHolderName());
        System.out.println("Account Number: " + accountNumberMasked());
        System.out.println("Current Balance: " + account.getBalance());
    }

    private String accountNumberMasked() {
        return "XXXXXX" + account.getAccountHolderName();
    }
}