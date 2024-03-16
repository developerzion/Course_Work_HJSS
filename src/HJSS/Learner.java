package HJSS;

import java.util.Scanner;

public class Learner {

    public enum Gender {
        MALE,
        FEMALE,
        OTHERS
    }

    public enum Grade {
        GRADE_1,
        GRADE_2,
        GRADE_3,
        GRADE_4,
        GRADE_5,
    }

    private int id;
    private String name;
    private int age;
    private String emergencyContactNo;
    private Gender gender;
    private Grade grade;

    public Learner(int id, String name, int age, String emergencyContactNo, Gender gender, Grade grade) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.emergencyContactNo = emergencyContactNo;
        this.gender = gender;
        this.grade = grade;
    }

    public Learner(int len) {
        this.CreateNewLearner(len);
    }

    public void insertGender(Scanner inputString) {
        System.out.print("Enter gender from list provided [ MALE | FEMALE | OTHER ] : ");
        String gender = inputString.nextLine();
        try {
            this.gender = Gender.valueOf(gender.toUpperCase());
        } catch (Exception e) {
            System.out.println("Invalid gender input");
            insertGender(inputString);
        }
    }

    public void insertAge(Scanner inputInt) {
        System.out.print("Enter your age : ");
        int age = inputInt.nextInt();
        if (age < 4 || age > 11) {
            System.out.println("Learners age must be between 4 and 11");
            insertAge(inputInt);
        } else {
            this.age = age;
        }
    }

    public void CreateNewLearner(int len) {
        Scanner inputInt = new Scanner(System.in);
        Scanner inputString = new Scanner(System.in);

        this.id = len + 1;
        System.out.print("Enter your fullname : ");
        this.name = inputString.nextLine();
        insertAge(inputInt);

        System.out.print("Enter emergency contact number : ");
        this.emergencyContactNo = inputString.nextLine();
        insertGender(inputString);
        System.out.print("Enter grade from list provided [ GRADE_1 ... GRADE_5 ] : ");
        String gd = inputString.nextLine();
        this.grade = Grade.valueOf(gd);
        System.out.print("Record successfully added  \n");
    }

    // @Override
    public String toString() {
        return id + "     "
                + name + "      "
                + age + "       "
                + emergencyContactNo + "     "
                + gender + "     "
                + grade;
    }

}
