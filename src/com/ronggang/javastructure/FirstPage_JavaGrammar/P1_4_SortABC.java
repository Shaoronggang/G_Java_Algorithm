package com.ronggang.javastructure.FirstPage_JavaGrammar;

/**
 * @Author: shaoRongGang
 * @Description: SortABC.java 将三个变量从小到大排列  冒泡排序的原理
 * @Date:Created in 21:31 2020/4/11
 * @Modifid By:
 * @Version：
 */
public class P1_4_SortABC {
    public static void main(String[] args) {
        int a=856,b = 2, c = 307;
//      t作为临时变量，两个同类型变量交换时，所存放的值
        int t;
        if (a >  b){
            t = a; a = b;b = t;
        }
        if (a > c){
            t = a;a = c;c = t;
        }

        if (b > c){
            t = b;b = c;c = t;
        }

        System.out.println("排序之后： a= " + a + ",b = " + b + ",c = " + c);

    }
}
