package com.ronggang.javastructure.FirstPage_JavaGrammar;

/**
 * @Author: shaoRongGang
 * @Description:
 * @Date:Created in 22:24 2020/4/13
 * @Modifid By:
 * @Version：
 */
public class P1_13_DispUnicode {
    public static void main(String[] args) {
        P1_13_DispUnicode dispUnicode = new P1_13_DispUnicode();
        dispUnicode.queryCoding("和谐美好， 智慧诚信，务实创新");
    }

    private void queryCoding(String sArg){
        System.out.println("用户传递的字符串参数是：");
        System.out.println(sArg);
        System.out.println("计算得到的汉字Unicode编码是：");
//        依次取出每一个字符进行操作
        for (int i = 0; i < sArg.length() ; i++) {
//           首先判断是不是汉字，不是则跳过
            char ch = sArg.charAt(i);
            if (ch < 19968 || ch > 40869)continue;
            System.out.printf((int)ch + " ");
        }
    }
}
