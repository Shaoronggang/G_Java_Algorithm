package com.ronggang.javastructure.FirstPage_JavaGrammar;

import java.util.Random;
import java.util.Scanner;

/**
 * @Author: shaoRongGang
 * @Description:
 * @Date:Created in 16:15 2020/4/11
 * @Modifid By:
 * @Version：
 */
public class P1_1_FindInt {
    static int N = 20;
    public static void main(String[] args) {
        int[] arr = new int[N];
        int x,n,j;
        int f = -1;
        boolean isFind = false;
        Random r = new Random();                      // 随机种子
        for ( j = 0; j < N; j++) {
            arr[j] = r.nextInt(100);          // 产生数组
        }

        System.out.println("随机生成的数据序列：");
        for (j = 0; j < N; j++) {
            System.out.print(arr[j] + " ");          // 输出序列
        }

        System.out.print("\n\n");

        // 如果没有找到的话，就让它一直找
        while (!isFind){
        System.out.print("输入要查找的整数：");
        Scanner input = new Scanner(System.in);
        x = input.nextInt();                          // 输入要查找的数
        for (j = 0; j < N; j++) {
            if (x == arr[j])                          // 找到数据
            {
                f = j;
                break;
            }
        }
            if (f < 0){
                System.out.println("没找到数据：" + x);
            }else {
                System.out.print("数据：" + x + " 位于数组的第 " + (f + 1) + "个元素处.\n");
                isFind = true;
            }
        }
    }
}
