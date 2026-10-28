class Student {
    private String name;
    private int age;

    Student() {
        name = "Unknown";
        age = 0;
    }

    Student(String n, int a) {
        setName(n);
        setAge(a);
    }

    public String getName() {
        return name;
    }

    public void setName(String n) {
        if (n != null && !n.isEmpty())
            name = n;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int a) {
        if (a > 0)
            age = a;
    }
}

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student();
        Student s2 = new Student("Rahul", 20);

        System.out.println(s1.getName() + " " + s1.getAge());
        System.out.println(s2.getName() + " " + s2.getAge());
    }
}






