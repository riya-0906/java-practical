
interface Payable {
    double calculateSalary();
}

interface Printable {
    void printDetails();
}

// Abstract class
abstract class Employee implements Payable, Printable {
    protected int id;
    protected String name;

    Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Abstract method
    abstract void displayRole();

    // Concrete method
    void displayBasicDetails() {
        System.out.println("Employee ID: " + id);
        System.out.println("Employee Name: " + name);
    }
}

// Subclass 1: Full-time employee
class FullTimeEmployee extends Employee {
    private double monthlySalary;
    private double bonus;

    FullTimeEmployee(int id, String name,
                     double monthlySalary, double bonus) {
        super(id, name);
        this.monthlySalary = monthlySalary;
        this.bonus = bonus;
    }

    @Override
    double calculateSalary() {
        return monthlySalary + bonus;
    }

    
    void displayRole() {
        System.out.println("Role: Full-Time Employee");
    }

    
    public void printDetails() {
        displayBasicDetails();
        displayRole();
        System.out.println("Total Salary: Rs. " + calculateSalary());
    }
}

// Subclass 2: Part-time employee
class PartTimeEmployee extends Employee {
    private int hoursWorked;
    private double hourlyRate;

    PartTimeEmployee(int id, String name,
                     int hoursWorked, double hourlyRate) {
        super(id, name);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    
    double calculateSalary() {
        return hoursWorked * hourlyRate;
    }

    
    void displayRole() {
        System.out.println("Role: Part-Time Employee");
    }

    
    public void printDetails() {
        displayBasicDetails();
        displayRole();
        System.out.println("Total Salary: Rs. " + calculateSalary());
    }
}

// Subclass 3: Commission-based employee
class CommissionEmployee extends Employee {
    private double sales;
    private double commissionRate;

    CommissionEmployee(int id, String name,
                       double sales, double commissionRate) {
        super(id, name);
        this.sales = sales;
        this.commissionRate = commissionRate;
    }

    
    double calculateSalary() {
        return sales * commissionRate / 100;
    }

    
    void displayRole() {
        System.out.println("Role: Commission-Based Employee");
    }

    
    public void printDetails() {
        displayBasicDetails();
        displayRole();
        System.out.println("Total Salary: Rs. " + calculateSalary());
    }
}

public class Main {
    public static void main(String[] args) {
        Employee e1 = new FullTimeEmployee(
            101, "Aman", 40000, 5000
        );

        Employee e2 = new PartTimeEmployee(
            102, "Priya", 80, 250
        );

        Employee e3 = new CommissionEmployee(
            103, "Rahul", 200000, 5
        );

        Employee[] employees = {e1, e2, e3};

        for (Employee e : employees) {
            e.printDetails();
            System.out.println("--------------------");
        }
    }
}
