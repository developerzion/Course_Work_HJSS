package HJSS;

import java.util.Collection;
import java.util.Scanner;

public class Coach {
    private int id;
    private String name;
    public Learner.Gender Gender;

    // coach class constructor
    public Coach(int id, String name, Learner.Gender gender) {
        this.id = id;
        this.name = name;
        this.Gender = gender;
    }

    public String toString() {
        return id + "               "
                + name + "               "
                + Gender + "               ";
    }

    public static void printCoachList(Collection<Coach> coaches) {
        System.out.println("=======================================================================================");
        for (Coach c : coaches) {
            System.out.println(c);
        }
        System.out.println("=======================================================================================");
    }

    public static void coachMenu(Collection<Coach> coaches) {
        int input;
        do {
            System.out.println("[1]: Show list of registered coach" + "\n[2]: Exit");
            Scanner sc = new Scanner(System.in);
            input = sc.nextInt();

            switch (input) {
                case 1:
                    printCoachList(coaches);
                    break;
                case 2:
                    System.exit(0);
                    break;
                default:
                    break;
            }
        } while (input != 0);
    }

}