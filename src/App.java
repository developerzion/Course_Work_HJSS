import HJSS.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class App {

    static Collection<Learner> learners = new ArrayList<Learner>();

    public static void printLearnersList() {
        System.out.println("=======================================================================================");
        for (Learner i : learners) {
            System.out.println(i);
        }
        System.out.println("=======================================================================================");
    }

    public static void displayMenu() {
        System.out.println(
                "\n [1] Login as learner \n [2] Register new learner \n [3] Login as coach \n [4] Exit \n [5] Print learner's records \n");
    }

    public static void main(String[] args) throws Exception {
        int input;

        learners.add(new Learner(1, "John Doe", 6, "07011223344", Learner.Gender.MALE, Learner.Grade.GRADE_3));
        learners.add(new Learner(2, "Jane Smith", 8, "090088776655", Learner.Gender.FEMALE, Learner.Grade.GRADE_2));

        displayMenu();

        do {

            Scanner x = new Scanner(System.in);
            input = x.nextInt();

            switch (input) {
                case 1:
                    System.out.println("\n You are currently logged in   ass a learner \n");
                    break;
                case 2:
                    learners.add(new Learner(learners.size()));
                    displayMenu();
                    break;
                case 3:
                    System.out.println("\n You are currently logged in as a coach \n");
                    break;
                case 4:
                    System.exit(0);
                    break;
                case 5:
                    printLearnersList();
                    break;
                default:
                    break;
            }

        } while (input != 0);
    }
}
