abstract class Employee {
    String name;

    Employee(String name) {
        this.name = name;
    }

    abstract double calculateSalary();

    void display() {
        System.out.println("Employee: " + name);
    }
}

interface Payable {
    void pay();
}

interface Printable {
    void print();
}

class Manager extends Employee implements Payable, Printable {
    Manager(String name) {
        super(name);
    }

    double calculateSalary() {
        return 50000 + 10000;
    }

    public void pay() {
        System.out.println("Salary paid.");
    }

    public void print() {
        System.out.println("Salary: " + calculateSalary());
    }
}

class Clerk extends Employee {
    Clerk(String name) {
        super(name);
    }

    double calculateSalary() {
        return 20000;
    }
}

public class Main {
    public static void main(String[] args) {
        Manager m = new Manager("Rahul");
        m.display();
        m.pay();
        m.print();

        Clerk c = new Clerk("Amit");
        c.display();
        System.out.println("Salary: " + c.calculateSalary());
    }
}
