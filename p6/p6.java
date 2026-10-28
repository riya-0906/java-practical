
package bank;

import java.util.Scanner;

// Custom exception
class InsufficientBalanceException extends Exception {
    InsufficientBalanceException(String msg) {
        super(msg);
    }
}

class Account {
    static String bankName = "ABC Bank";
    private final int accountNo;
    private double balance;

    Account(int accountNo, double balance) {
        this.accountNo = accountNo;
        this.balance = balance;
    }

    // Static method
    static void showBank() {
        System.out.println("Bank: " + bankName);
    }

    // Final method
    final void showAccount() {
        System.out.println("Account No: " + accountNo);
        System.out.println("Balance: Rs. " + balance);
    }

    void withdraw(double amount)
            throws InsufficientBalanceException {
        if (amount <= 0)
            throw new IllegalArgumentException(
                "Amount must be positive");
        if (amount > balance)
            throw new InsufficientBalanceException(
                "Insufficient balance");

        balance -= amount;
        System.out.println("Withdrawal successful.");
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Account a = new Account(101, 5000);

        try {
            Account.showBank();
            a.showAccount();

            System.out.print("Enter withdrawal amount: ");
            double amount = sc.nextDouble();

            a.withdraw(amount);
            a.showAccount();
        } catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (java.util.InputMismatchException e) {
            System.out.println("Invalid input! Enter a number.");
        } finally {
            sc.close();
            System.out.println("Transaction process completed.");
        }
    }
}
