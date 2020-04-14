package com.ronggang.javastructure.FirstPage_JavaGrammar;

/**
 * @Author: shaoRongGang
 * @Description: 通过枚举求毕业生人数和已就业学生的人数，
 * 已知某大学软件学院本年度毕业生的人数为三百人左右，且学生就业率为83.23%。
 * 通过for循环，来求出最可能的学生人数以及就业人数。假定总人数三百人左右的描述，
 * 是指人数上下波动在20以内。
 * @Date:Created in 19:58 2020/4/13
 * @Modifid By:
 * @Version：
 */
public class P1_10_StuEnum {
    /**
     * Todo：回头自己按照逻辑再刷一遍
     * @param iNum  大概的数字
     * @param iOff 上下波动的区间
     * @param fPersent 就业率
     */
    private void calcByEnum(int iNum,int iOff,float fPersent){
        int iRealNum = 300;
//     fTmp 是两个数据的差值,最小差值,将差值进行对比,如果有更小的差值则将差值替换
//     如果最小差值设定的值太小了,那么将会导致无法筛选出最小差值
        float fTmp,fMinDiff = 1.0f;
//        此处需要注意点是,循环是包括初始值的
        for (int i = iNum - iOff + 1; i <= iNum + iOff; i++) {
//            通过比较相应的两个值的差值,来判断,哪个差值最小,就取哪个值
            fTmp = Math.abs(Math.round(i*fPersent)/(float)i - fPersent );
            System.out.println("i = " +i +  "就业率："+ Math.round(i*fPersent)/(float)i);
            if (fTmp < fMinDiff){
                fMinDiff = fTmp;
                iRealNum = i;
            }
        }
        int iJiuYe = Math.round(iRealNum*fPersent);
        System.out.println("通过枚举，计算出学生总人数是：" + iRealNum);
        System.out.println("已就业学生人数是：" + iJiuYe);
        System.out.println("问题陈述给出的就业率是：" + fPersent*100 + "%");
        System.out.println("计算结果对应的就业率是：" + (iJiuYe/(float)iRealNum)*100 + "%");

    }

    public static void main(String[] args) {
        P1_10_StuEnum stuEnum = new P1_10_StuEnum();
        stuEnum.calcByEnum(300,20,0.8323f);

    }


}
