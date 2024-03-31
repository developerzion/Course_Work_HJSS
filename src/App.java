import HJSS.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class App {

    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RESET = "\033[0m";

    static Collection<Learner> learners = new ArrayList<Learner>();
    static Collection<Coach> coaches = new ArrayList<Coach>();
    static Collection<Lesson> lessons = new ArrayList<Lesson>();

    public static void displayMenu() {
        System.out.println(
                "\n [1] Login as learner \n [2] Register new learner \n [3] Login as coach \n [4] Exit \n [5] Print learner's records \n");
    }

    public static void main(String[] args) {

        // Pre-add learners
        learners.add(new Learner(1, "John Doe", 6, "07011223344", Learner.Gender.MALE, Learner.Grade.GRADE_1));
        learners.add(new Learner(2, "Jane Smith", 8, "090088776655", Learner.Gender.FEMALE, Learner.Grade.GRADE_1));

        // Pre-add coaches
        coaches.add(new Coach(1, "Dewan"));
        coaches.add(new Coach(2, "Tina"));
        coaches.add(new Coach(3, "Steve"));
        coaches.add(new Coach(4, "Victoria"));

        // Pre-add lessons
        lessons.add(new Lesson("Monday", "4-5pm", 1, "Dewan"));
        lessons.add(new Lesson("Tuesday", "4-5pm", 1, "Tina"));

        int input;
        System.out.println(ANSI_GREEN + "\nWELCOME TO HATFIELD JUNIOR SWIMMING SCHOOL" + ANSI_RESET);

        // Display main menu
        displayMenu();
        do {

            Scanner x = new Scanner(System.in);
            System.out.print(ANSI_GREEN + "\nEnter your choice: " + ANSI_RESET);
            input = x.nextInt();

            switch (input) {
                case 1:
                    Learner.learnerMenu(learners);
                    break;
                case 2:
                    learners.add(new Learner(learners.size()));
                    displayMenu();
                    break;
                case 3:
                    Coach.coachMenu(coaches);
                    break;
                case 4:
                    System.exit(0);
                    break;
                case 5:
                    Learner.printLearnersRecord(learners);
                    break;
                default:
                    break;
            }

        } while (input != 0);
    }
}
