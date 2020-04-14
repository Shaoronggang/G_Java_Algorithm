package com.ronggang.javastructure.FirstPage_JavaGrammar;

import java.util.Scanner;

/**
 * @Author: shaoRongGang
 * @Description: 从命令行输入数据，来计算长方形的面积，周长
 * @Date:Created in 17:02 2020/4/11
 * @Modifid By:
 * @Version：
 */
public class P1_3_E_sequence {


    public static void main(String[] args) {
        double width,height,area,girth;
        Scanner key_in = new Scanner(System.in);
        System.out.println("请输入长方形的宽：");
        width = key_in.nextDouble();
        System.out.println("请输入长方形的长：");
        height = key_in.nextDouble();
        area = width * height;
        girth = 2*width*height;
        System.out.println("长方形的面积是：" + area +  "\n长方形的周长是：" + girth);

    }

}
