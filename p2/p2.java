class Person {
    protected String name;

    Person(String name) {
        this.name = name;
    }

    void display() {
        System.out.println("Name: " + name);
    }
}

class Student extends Person {  // Single inheritance
    Student(String name) {
        super(name);
    }
}

class Faculty extends Student { // Multilevel inheritance
    Faculty(String name) {
        super(name);
    }

    void teach() {
        System.out.println(name + " is teaching.");
    }
}

public class Main {
    public static void main(String[] args) {
        Student s = new Student("Rahul");
        s.display();

        Faculty f = new Faculty("Priya");
        f.display();
        f.teach();
    }
}
                       
