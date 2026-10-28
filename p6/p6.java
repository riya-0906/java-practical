class InvalidAmountException extends Exception {
    InvalidAmountException(String msg) {
        super(msg);
    }
}

class BankAccount {
    static String bankName = "ABC Bank";
    private double balance;
    final int accountNo;

    BankAccount(int no, double balance) {
        accountNo = no;
        this.balance = balance;
    }

    static void showBank() {
        System.out.println(bankName);
    }

    void deposit(double amount) throws InvalidAmountException {
        if (amount <= 0)
            throw new InvalidAmountException("Invalid amount!");
        balance += amount;
    }

    final void showBalance() {
        System.out.println("Balance: " + balance);
    }
}

public class Main {
    public static void main(String[] args) {
        BankAccount.showBank();
        BankAccount a = new BankAccount(101, 1000);

        try {
            a.deposit(-500);
        } catch (InvalidAmountException e) {
            System.out.println(e.getMessage());
        } finally {
            a.showBalance();
            System.out.println("Transaction completed.");
        }
    }
}
