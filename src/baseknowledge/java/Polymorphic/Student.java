package baseknowledge.java.Polymorphic;

public class Student {
    private int age;
    public Student() {
    }


    public Student(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void hello() {
        System.out.println("Student:hello");
    }

}
