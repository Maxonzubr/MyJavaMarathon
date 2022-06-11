package day6;

public class Task3 {
    public static void main(String[] args) {
        Student student1 = new Student("Rob");
        Teacher teacher1 = new Teacher("Bob", "History of Java");
        teacher1.evaluate(student1);
    }
}
