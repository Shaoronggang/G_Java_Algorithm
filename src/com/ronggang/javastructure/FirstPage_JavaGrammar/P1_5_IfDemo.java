package com.ronggang.javastructure.FirstPage_JavaGrammar;

/**
 * @Author: shaoRongGang
 * @Description:一般情况下，if 语句的嵌套不超过三个层次
 * @Date:Created in 21:44 2020/4/11
 * @Modifid By:
 * @Version：
 */
public class P1_5_IfDemo {
    public static void main(String[] args) {
        int iScore = 78;
        String sGrade;
        if (iScore >= 90)
            sGrade = "优";
                    else if (iScore >= 80)
                        sGrade = "良";
                    else if (iScore >= 70)
                        sGrade = "中";
                    else if (iScore >= 60)
                        sGrade = "及格";
                    else
                        sGrade = "不及格";
        System.out.println("学生的成绩是：" + iScore);
        System.out.println("学生的等级是：" + sGrade);
    }
}
