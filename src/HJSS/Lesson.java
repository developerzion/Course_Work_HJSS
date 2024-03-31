package HJSS;

import java.util.ArrayList;
import java.util.Collection;

public class Lesson {

    private String day;
    private String time;
    private int gradeLevel;
    private String coach;
    private Collection<Learner> learners;

    public Lesson(String day, String time, int gradeLevel, String coach) {
        this.day = day;
        this.time = time;
        this.gradeLevel = gradeLevel;
        this.coach = coach;
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

    public void addLearner(Learner learner) {
        learners.add(learner);
    }

}
