package com.ronggang.javastructure.FirstPage_JavaGrammar;

/**
 * @Author: shaoRongGang
 * @Description: 计算1 + 1/3 + 1/5 +  .... + 1/(2*n + 1) 的值.要求要求使用while循环，且必须计算到
 * 1/(2*n + 1)小于0.00001时为止.当循环结束时，显示上述表达式中n的值，以及表达式计算的结果。
 * @Date:Created in 22:17 2020/4/12
 * @Modifid By:
 * @Version：
 */
public class P1_8_DoWhileDemo {
    public static void main(String[] args) {
        int n = 1;
        double dSum = 1.0, dTemp;
        do {
            dTemp = 1.0 / (2 * n + 1);
            dSum += dTemp;
            n++;
//            注意点,需要更高的精度时，可以使用double
        } while (dTemp >= 0.00001);
        System.out.println("循环结束时n的值是：" + (n - 1));
        System.out.println("计算出的结果是：" + dSum);
    }

}
