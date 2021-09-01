package baseknowledge.java.Polymorphic;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author shaoronggang
 * @date 2021-05-07
 *
 */
public class GenericLearn {

    public static void main(String[] args) {
        ArrayList<LowGradeStudent> list = new ArrayList<>();
        list.add(new LowGradeStudent(28,"xiaogang","60"));
        list.add(new LowGradeStudent(28,"Joe","80"));
        list.add(new LowGradeStudent(28,"LiLy","100"));
        list.add(new LowGradeStudent(28,"Han","90"));
        LowGradeStudent[] lowGradeStudents = list.toArray(new LowGradeStudent[list.size()]);
        System.out.println(Arrays.toString(lowGradeStudents));
        Arrays.sort(lowGradeStudents);
        System.out.println(Arrays.toString(lowGradeStudents));
    }


}
