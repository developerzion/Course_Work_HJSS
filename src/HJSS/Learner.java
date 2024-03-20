package HJSS;

import java.util.Collection;
import java.util.Scanner;

public class Learner {

    public static final String ANSI_GREEN = "\u001B[32m";
    // public static final String ANSI_BLUE = "\034[0m";
    public static final String ANSI_RESET = "\033[0m";

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

    private int loggedId;
    private String loggedName;
    private Grade loggedGrade;

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

    public void insertGrade(Scanner inputString) {
        System.out.print("Enter grade from list provided [ GRADE_1 ... GRADE_5 ] : ");
        String grade = inputString.nextLine();
        try {
            this.grade = Grade.valueOf(grade.toUpperCase());
        } catch (Exception e) {
            System.out.println("Invalid grade input");
            insertGrade(inputString);
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
        insertGrade(inputString);
        System.out.print(ANSI_GREEN + "Record successfully added  \n + " + ANSI_RESET);
    }

    public String toString() {
        return id + "     "
                + name + "      "
                + age + "       "
                + emergencyContactNo + "     "
                + gender + "     "
                + grade;
    }

    public static void operationalMenu(Collection<Learner> learners) {

        System.out.println(ANSI_GREEN +
                "=========== LIST OF LEARNERS =========="
                + ANSI_RESET);

        System.out.println("=======================================================================================");
        for (Learner i : learners) {
            System.out.println(i);
        }
        System.out
                .println("======================================================================================= \n");

        System.out.print("Select learners id you want to login as or press 0 to exit:");
    }

    public static void LoggedIn(int loggedId, String loggedName, Grade loggedGrade) {
        System.out.println(ANSI_GREEN +
                "\nYou are  currently logged in as " + loggedName + "!"
                + ANSI_RESET);

        System.out.println(
                "\n[1]: Book a swimming lesson \n[2]: Cancel or change a booking \n[3]: Attend a booking \n[4]: Print learners report \n[5]: Logout");

        int input;

        Scanner x = new Scanner(System.in);
        input = x.nextInt();

        switch (input) {
            case 1:
                bookSwimmingLesson(loggedId, loggedName, loggedGrade);
                break;
                case 5:
                
                break;
            default:
                break;
        }

    }

    public static void bookSwimmingLesson(int loggedId, String loggedName, Grade loggedGrade) {

        System.out.println(
                "\n----TIME TABLE----\n[1]: View time table by day \n[2]: View time table by grade level \n[3]: View time table  by coach name \n[4]: Go back");
    }

    public static void storeLoggedDetails(Learner instance, int loggedId, String loggedName, Grade loggedGrade) {
        instance.loggedId = loggedId;
        instance.loggedName = loggedName;
        instance.loggedGrade = loggedGrade;

        LoggedIn(loggedId, loggedName, loggedGrade);
    }

    public static void authenticateLearner(Collection<Learner> learners, int id) {
        try {
            for (Learner learner : learners) {
                if (learner.id == id) {
                    storeLoggedDetails(learner, learner.id, learner.name, learner.grade);
                }
            }
        } catch (Exception e) {
            
        }

    }

    public static void learnerMenu(Collection<Learner> learners) {
        int input;
        operationalMenu(learners);
        Scanner sc = new Scanner(System.in);
        input = sc.nextInt();

        if (input == 0) {
            System.exit(0);
        } else {
            authenticateLearner(learners, input);
        }
    }

}
