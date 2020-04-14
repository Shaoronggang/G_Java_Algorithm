package com.ronggang.javastructure.FirstPage_JavaGrammar;

/**
 * @Author: shaoRongGang
 * @Description:求1到100的和  使用while循环，while循环通常用于循环次数不确定的时候
 * @Date:Created in 20:55 2020/4/12
 * @Modifid By:
 * @Version：
 */
public class P1_7_Sum100 {
    public static void main(String[] args) {
        int iLoop = 1;
        int iSum = 0;
        while (iLoop <=100){
            iSum += iLoop;
            iLoop ++;
        }
        System.out.println("1到100的累加和是： " + iSum);

    }
}
