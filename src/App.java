import HJSS.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class App {

    static Collection<Learner> learners = new ArrayList<Learner>();
    static Collection<Coach> coaches = new ArrayList<Coach>();

    public static void displayMenu() {
        System.out.println(
                "\n [1] Login as learner \n [2] Register new learner \n [3] Login as coach \n [4] Exit \n [5] Print learner's records \n");
    }

    public static void main(String[] args) throws Exception {

        learners.add(new Learner(1, "John Doe", 6, "07011223344", Learner.Gender.MALE, Learner.Grade.GRADE_3));
        learners.add(new Learner(2, "Jane Smith", 8, "090088776655", Learner.Gender.FEMALE, Learner.Grade.GRADE_2));

        coaches.add(new Coach(1, "Dewan", Learner.Gender.MALE));
        coaches.add(new Coach(2, "Tina", Learner.Gender.FEMALE));
        coaches.add(new Coach(3, "Steve", Learner.Gender.MALE));
        coaches.add(new Coach(4, "Viktoria", Learner.Gender.FEMALE));

        int input;
        displayMenu();
        do {

            Scanner x = new Scanner(System.in);
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
                // case 5:
                // printLearnersList();
                // break;
                default:
                    break;
            }

        } while (input != 0);
    }
}
