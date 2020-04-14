package com.ronggang.javastructure.FirstPage_JavaGrammar;

/**
 * @Author: shaoRongGang
 * @Description:根据传入的月份的参数，表示该月有多少天
 * @Date:Created in 23:00 2020/4/11
 * @Modifid By:
 * @Version：
 */
public class P1_6_SwitchDemo {
    public static void main(String[] args) {
    P1_6_SwitchDemo switchDemo = new P1_6_SwitchDemo();
    switchDemo.showDays(6);
    }

    public void showDays(int iMonth){
        int iDays = 0;
        switch (iMonth){
            case 2: iDays=28;break;
            case 4:
            case 6:
            case 9:
            case 11:iDays = 30;break;
            default:iDays = 31;
        }
        System.out.println(iMonth+ "月有" + iDays + "天！");
    }
}
