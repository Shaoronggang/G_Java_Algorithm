package com.ronggang.javastructure.FirstPage_JavaGrammar;

/**
 * @Author: shaoRongGang
 * @Description: 打印3 ~ 100之间的素数，每行打印6个数
 * @Date:Created in 21:32 2020/4/13
 * @Modifid By:
 * @Version：
 */
public class P1_12_SuShu {


    public static void main(String[] args) {
        System.out.println("3~100之间的素数：");
        int iCount = 0;
        boolean isPrime ;
        for (int i = 3; i <= 100 ; i++) {
//            判断是否是素数
            isPrime = true;
            for (int j = 2; j <= i/2 ; j++) {
                if (i%j == 0){
                    isPrime = false;
                    break;
                }
            }

            if (isPrime){
                System.out.print(i + "\t");
                iCount++;
                if (iCount%6 == 0)
                    System.out.println();

            }



        }
    }

}
