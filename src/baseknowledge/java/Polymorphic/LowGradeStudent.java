package baseknowledge.java.Polymorphic;

import java.util.Objects;

public class LowGradeStudent  extends Student implements Comparable<LowGradeStudent>{

    String name;
    String score;

    public LowGradeStudent(String name, String score) {
        this.name = name;
        this.score = score;
    }

    public LowGradeStudent() {
    }

    public LowGradeStudent(int age, String name, String score) {
        super(age);
        this.name = name;
        this.score = score;
    }

    private void setName(String name){
        this.name = name;
    }

    public int getAvScore(int score){
        return score;
    }

    private int getGrade(int year){
    return 1;
    }

    public static String getMessage(String info){
        return info;
    }

    public void hello() {
        System.out.println("LowGradeStudent:hello");
    }

    @Override
    public int compareTo(LowGradeStudent other) {
        return this.name.compareTo(other.name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LowGradeStudent)) return false;
        LowGradeStudent that = (LowGradeStudent) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(score, that.score);
    }


    @Override
    public int hashCode() {
        return Objects.hash(name, score);
    }

    @Override
    public String toString() {
        return "LowGradeStudent{" +
                "name='" + name + '\'' +
                ", score='" + score + '\'' +
                '}';
    }
}
