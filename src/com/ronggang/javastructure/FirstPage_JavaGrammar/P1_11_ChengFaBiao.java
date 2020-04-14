package com.ronggang.javastructure.FirstPage_JavaGrammar;

/**
 * @Author: shaoRongGang
 * @Description: 使用for循环来打印出九九乘法表
 * @Date:Created in 21:19 2020/4/13
 * @Modifid By:
 * @Version：
 */
public class P1_11_ChengFaBiao {
    public static void main(String[] args) {
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i ; j++) {
                System.out.print(j + "*" + i + "=" + j*i + "\t");
            }
            System.out.println("");
        }

        System.out.println("取余操作：" + 6%2);
    }

}
