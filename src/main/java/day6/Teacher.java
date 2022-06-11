package day6;

import java.util.Random;

public class Teacher {
    private String name;
    private String subject;
    private int gradeInt;
    private String gradeString;
    Random random = new Random();

    Teacher(String name, String subject) {
        this.name = name;
        this.subject = subject;
    }

    void setName(String name) {
        this.name = name;
    }

    void setSubject(String subject) {
        this.subject = subject;
    }

    String getName() {
        return name;
    }

    String getSubject() {
        return subject;
    }

    void evaluate(Student x) {
        gradeInt = random.nextInt(4) + 2;
        switch (gradeInt) {
            case 2:
                gradeString = "Unsatisfactory";
                break;
            case 3:
                gradeString = "Satisfactory";
                break;
            case 4:
                gradeString = "Good";
                break;
            case 5:
                gradeString = "Excellent";
        }
        System.out.print("Teacher " + name + " has grading student " + x.getName() + " by " + gradeString +".");
    }
}
