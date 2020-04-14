package com.ronggang.javastructure.FirstPage_JavaGrammar;

/**
 * @Author: shaoRongGang
 * @Description: 打印几个特定字符的ASCII码，包括数字0和9，大写字母A和Z，小写字母a和z
 * @Date:Created in 16:46 2020/4/11
 * @Modifid By:
 * @Version：
 */
public class P1_2_PrintAscii {
    public static void main(String[] args) {
        P1_2_PrintAscii obj = new P1_2_PrintAscii();
        obj.dispAscii('0');
        obj.dispAscii('9');
        obj.dispAscii('A');
        obj.dispAscii('Z');
        obj.dispAscii('a');
        obj.dispAscii('z');
    }

//  获取字符的ASCII码
    public void dispAscii(char ch){
        int iTmp = (int)ch;
        System.out.println(ch + " 的ASCII码是：" + iTmp);
    }
}
