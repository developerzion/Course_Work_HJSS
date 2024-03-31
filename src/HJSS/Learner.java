package HJSS;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class Learner {

    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RESET = "\033[0m";

    static Collection<Coach> coaches = new ArrayList<Coach>();

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
        this.createNewLearner(len);
    }

    public String getName() {
        return this.name;
    }

    public Grade geGrade() {
        return this.grade;
    }

    public String toString() {
        return id + "   "
                + name + "      "
                + age + "       "
                + emergencyContactNo + "     "
                + gender + "     "
                + grade;
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
        int newAge = inputInt.nextInt();
        if (newAge < 4 || newAge > 11) {
            System.out.println("Learners age must be between 4 and 11");
            insertAge(inputInt);
        } else {
            this.age = newAge;
        }
    }

    public void insertGrade(Scanner inputString) {
        System.out.print("Enter grade from list provided [ GRADE_1 ... GRADE_5 ] : ");
        String newGrade = inputString.nextLine();
        try {
            this.grade = Grade.valueOf(newGrade.toUpperCase());
        } catch (Exception e) {
            System.out.println("Invalid grade input");
            insertGrade(inputString);
        }
    }

    public void createNewLearner(int len) {
        Scanner inputInt = new Scanner(System.in);
        Scanner inputString = new Scanner(System.in);

        this.id = len + 1;
        System.out.print("Enter your fullname : ");
        this.name = inputString.nextLine();
        insertAge(inputInt);

        System.out.print("Enter emergency contact number : ");
        this.emergencyContactNo = inputString.nextLine();
        insertGender(inputString);
        insertGrade(inputString);
        System.out.print(ANSI_GREEN + "Record successfully added  \n" + ANSI_RESET);
    }

    public static void printLearnersRecord(Collection<Learner> learners) {
        System.out.println(ANSI_GREEN + "\n=========== LIST OF LEARNERS ==========" + ANSI_RESET);
        System.out.println("=======================================================================================");
        System.out.printf("%-6s%-25s%-7s%-25s%-9s%s%n", "ID", "NAME", "AGE", "CONTACT ADDRESS", "GENDER", "GRADE");
        System.out.println("=======================================================================================");
        for (Learner learner : learners) {
            System.out.printf("%-6s%-25s%-7s%-25s%-9s%s%n", learner.id, learner.name, learner.age,
                    learner.emergencyContactNo, learner.gender, learner.grade);
        }

    }

    // int loggedId, String loggedName, Grade loggedGrade
    public static void loggedIn(Learner learner) {
        System.out.println(ANSI_GREEN + "\nYou are  currently logged in as: " + learner.name + "!" + ANSI_RESET);
        System.out.println(
                "\n[1]: Book a swimming lesson \n[2]: Change/Cancel a booking \n[3]: Attend a swimming lesson \n[4]: Print learners report \n[5]: Exit");
        System.out.print(ANSI_GREEN + "\nEnter your choice: " + ANSI_RESET);
        int input;
        Scanner x = new Scanner(System.in);
        input = x.nextInt();

        switch (input) {
            case 1:
                swimmingLesson(learner);
                break;
            default:
                break;
        }

    }

    public static void swimmingLesson(Learner learner) {
        Lesson lesson = new Lesson();

        String day;
        String time;

        Scanner scan = new Scanner(System.in);
        System.out.print("Enter preferred day: ");
        day = scan.nextLine();
        System.out.print("Enter preferred time: ");
        time = scan.nextLine();

        lesson.bookSwimmingLesson(learner, day, time);
    }

    public static void authenticateLearner(Collection<Learner> learners, int id) {
        try {
            for (Learner learner : learners) {
                if (learner.id == id) {
                    loggedIn(learner);
                }
            }
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }

    public static void learnerMenu(Collection<Learner> learners) {
        int input;
        printLearnersRecord(learners);
        System.out
                .println("======================================================================================= \n");
        System.out.print(ANSI_GREEN + "Select learners id you want to login as or press 0 to exit: " + ANSI_RESET);
        Scanner scan = new Scanner(System.in);
        input = scan.nextInt();

        if (input == 0) {
            System.exit(0);
        } else {
            authenticateLearner(learners, input);
        }
    }

}
