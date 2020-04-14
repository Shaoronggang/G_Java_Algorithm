package com.ronggang.javastructure.FirstPage_JavaGrammar;

/**
 * @Author: shaoRongGang
 * @Description: 将ASCII码位于32~126之间的95个字符显示在屏幕上。
 * 为了美观，要求小于100的码值前填充一个0，每打印8个字符后换行
 * @Date:Created in 22:30 2020/4/12
 * @Modifid By:
 * @Version：
 */
public class P1_9_ShowAscii {
    public static void main(String[] args) {
        String temp = "";
        for (int i = 32; i <= 126 ; i++) {
            temp = i<100?"0"+i:i+"";
            System.out.print(temp + "=" + (char)i + "  ");
//            每8个一个循环,换行
            if ((i - 31)%8 == 0)
                System.out.printf("\n");
        }
    }
}
