
import java.util.ArrayList;
import java.util.List;

// Teacher: can exist independently
class Teacher {
    private String name;

    Teacher(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }
}

// Course: can exist independently
class Course {
    private String courseName;

    Course(String courseName) {
        this.courseName = courseName;
    }

    String getCourseName() {
        return courseName;
    }
}

// Department aggregates Teachers
class Department {
    private String departmentName;
    private List<Teacher> teachers = new ArrayList<>();

    Department(String departmentName) {
        this.departmentName = departmentName;
    }

    void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }

    String getDepartmentName() {
        return departmentName;
    }

    void displayTeachers() {
        System.out.println("Department: " + departmentName);
        for (Teacher teacher : teachers) {
            System.out.println("Teacher: " + teacher.getName());
        }
    }
}

// Student is associated with Courses
class Student {
    private String name;
    private List<Course> courses = new ArrayList<>();

    Student(String name) {
        this.name = name;
    }

    void enroll(Course course) {
        courses.add(course);
    }

    void displayCourses() {
        System.out.println("Student: " + name);
        for (Course course : courses) {
            System.out.println("Course: " + course.getCourseName());
        }
    }
}

// College composes Departments
class College {
    private String collegeName;
    private List<Department> departments = new ArrayList<>();

    College(String collegeName) {
        this.collegeName = collegeName;
    }

    // Departments are created inside the College
    void addDepartment(String departmentName) {
        departments.add(new Department(departmentName));
    }

    void displayDepartments() {
        System.out.println("College: " + collegeName);
        for (Department department : departments) {
            System.out.println(
                "Department: " + department.getDepartmentName()
            );
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // Composition
        College college = new College("ABC College");
        college.addDepartment("Computer Science");
        college.addDepartment("Electronics");

        // Aggregation
        Teacher t1 = new Teacher("Mr. Sharma");
        Teacher t2 = new Teacher("Ms. Verma");

        Department cs = new Department("Computer Science");
        cs.addTeacher(t1);
        cs.addTeacher(t2);

        // Association
        Student student = new Student("Aman");
        Course c1 = new Course("Java Programming");
        Course c2 = new Course("Database Management");

        student.enroll(c1);
        student.enroll(c2);

        college.displayDepartments();
        System.out.println();

        cs.displayTeachers();
        System.out.println();

        student.displayCourses();
    }
}
