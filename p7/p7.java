
import java.util.*;

class Box<T> {
    private T value;

    void set(T value) {
        this.value = value;
    }

    T get() {
        return value;
    }
}

public class Main {

    // Generic method
    static <T> void display(T value) {
        System.out.println(value);
    }

    // Bounded type parameter
    static <T extends Number> double square(T n) {
        return n.doubleValue() * n.doubleValue();
    }

    // Upper-bounded wildcard
    static double sum(List<? extends Number> list) {
        double total = 0;
        for (Number n : list)
            total += n.doubleValue();
        return total;
    }

    // Lower-bounded wildcard
    static void addNumbers(List<? super Integer> list) {
        list.add(10);
        list.add(20);
    }

    public static void main(String[] args) {
        Box<Integer> b = new Box<>();
        b.set(100);
        System.out.println("Box: " + b.get());

        display("Hello Java");
        display(25);

        System.out.println("Square: " + square(5));

        List<Double> nums = Arrays.asList(2.5, 3.5);
        System.out.println("Sum: " + sum(nums));

        List<Number> values = new ArrayList<>();
        addNumbers(values);
        System.out.println("Values: " + values);
    }
}
