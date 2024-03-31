package HJSS;

import java.util.ArrayList;
import java.util.Collection;
import HJSS.Learner.*;

public class Lesson {

    static Collection<Lesson> lessons = new ArrayList<Lesson>();

    private String day;
    private String time;
    private int gradeLevel;
    private int maxCapacity;
    private String coach;
    private Collection<Learner> learners;

    public Lesson() {
        lessons.add(new Lesson("Monday", "4-5pm", 1, "Dewan"));
        lessons.add(new Lesson("Tuesday", "4-5pm", 1, "Tina"));
    }

    public Lesson(String day, String time, int gradeLevel, String coach) {
        this.day = day;
        this.time = time;
        this.gradeLevel = gradeLevel;
        this.coach = coach;
        this.maxCapacity = 3;
        this.learners = new ArrayList<>();
    }

    public String getDay() {
        return day;
    }

    public String getTime() {
        return time;
    }

    public int getGradeLevel() {
        return gradeLevel;
    }

    public Collection<Learner> getLearners() {
        return learners;
    }

    public boolean addLearner(Learner learner) {
        if (learners.size() < maxCapacity) {
            learners.add(learner);
            this.maxCapacity = maxCapacity - 1;
            return true;
        }
        return false;
    }

    public int gradeNumber(Learner.Grade grade) {
        if (grade == Grade.GRADE_1)
            return 1;
        else if (grade == Grade.GRADE_2)
            return 2;
        else if (grade == Grade.GRADE_3)
            return 3;
        else if (grade == Grade.GRADE_4)
            return 4;
        return 5;
    }

    public void bookSwimmingLesson(Learner learner, String day, String time) {
        for (Lesson lesson : lessons) {
            if (lesson.getDay().equalsIgnoreCase(day) && lesson.getTime().equalsIgnoreCase(time)) {
                if ((gradeNumber(learner.geGrade()) == lesson.getGradeLevel() ||
                        gradeNumber(learner.geGrade()) == lesson.getGradeLevel() - 1) && lesson.addLearner(learner)) {
                    System.out.println("Booking successful for " + learner.getName() +
                            " on " + day + " at " + time);
                } else {
                    System.out.println("Booking unsuccessful for " + learner.getName() +
                            " on " + day + " at " + time + ". Invalid grade level or no vacancy.");
                }
                return;
            }
        }
        System.out.println("Lesson not found for " + day + " at " + time);
    }

}
