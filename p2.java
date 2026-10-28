class Person{
  protected String name;
  protected int age;
  Person(String name, int age) {
    this.name = name;
    this.age = age;
    System.out.println("Person Constructor");
  }
  void display() {
    System.out.println("Name: " + name);
    System.out.println("Age: " + age);
  }
}
class Student extends Person {
  private int rollNo;
  Student(String name, int age, int rollNo){
    super(name, age);
    this.rollNo = rollNo;
    System.out.println("Student Constructor");
  }
  void showStudent() {
    display();
    System.out.println("rollNo : " + rollNo);
  }
}
class Faculty ectends Student{
  private String subjects;
  Faculty(String name, int age,int rollNo, String subject){
    super(name, age,rollNo);
    this.subject = subject;
    System.out.println("Faculty Constructor");
  }
  void showFaculty(){
    showStudent();
    System.out.println("Subject: " + subject);
  }
}
public class Main{
  public static void main(String[] args) {
    Faculty f = new
      Faculty("Riya", 19,3, "Java");
    System.out.println("\nFaculty Details);
    f.showfaculty();
  }
}
                       
