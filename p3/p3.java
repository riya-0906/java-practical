
class Payment {
    // Compile-time polymorphism: Method Overloading
    void pay(double amount) {
        System.out.println("Payment amount: Rs. " + amount);
    }

    void pay(double amount, String method) {
        System.out.println("Payment method: " + method);
        System.out.println("Payment amount: Rs. " + amount);
    }

    // Method to be overridden by subclasses
    void processPayment(double amount) {
        System.out.println("Processing a general payment of Rs. " + amount);
    }
}

class CreditCardPayment extends Payment {
    // Run-time polymorphism: Method Overriding
    @Override
    void processPayment(double amount) {
        System.out.println("Paid Rs. " + amount + " using Credit Card.");
    }
}

class UPIPayment extends Payment {
    @Override
    void processPayment(double amount) {
        System.out.println("Paid Rs. " + amount + " using UPI.");
    }
}

class CashPayment extends Payment {
    @Override
    void processPayment(double amount) {
        System.out.println("Paid Rs. " + amount + " using Cash.");
    }
}

public class Main {
    public static void main(String[] args) {

        // 1. Compile-time polymorphism
        Payment p = new Payment();

        System.out.println("=== Method Overloading ===");
        p.pay(1000);
        p.pay(2000, "Debit Card");

        // 2. Run-time polymorphism
        System.out.println("\n=== Method Overriding ===");

        Payment payment;

        payment = new CreditCardPayment();
        payment.processPayment(1500);

        payment = new UPIPayment();
        payment.processPayment(2500);

        payment = new CashPayment();
        payment.processPayment(500);
    }
}
