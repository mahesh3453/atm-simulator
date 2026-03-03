package in.codesoft.tasks;

import java.util.Scanner;

public class ATMSimulator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("====== Welcome to ATM ======");
        System.out.print("Enter Account Number: ");
        String accNo = sc.nextLine();

        System.out.print("Enter PIN: ");
        int pin = sc.nextInt();

        BankAccount userAccount = new BankAccount(accNo);

        if (userAccount.authenticate(pin)) {
            System.out.println("Login Successful!");
            ATM atm = new ATM(userAccount);
            atm.displayMenu();
        } else {
            System.out.println("Invalid Account Number or PIN!");
        }

        sc.close();
    }
}