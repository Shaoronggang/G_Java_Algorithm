package com.hzwq.array;


import baseknowledge.java.Polymorphic.FlyStatus;
import baseknowledge.java.Polymorphic.Person;
import com.oracle.tools.packager.Log;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class TestArray {

    private int age;
    private String name;
    private Boolean  isOld;


    public static void main(String[] args) {
        /**
         * 数组基础测试
         */
//        java中新建一个数组，需要初始化大小
//            int[] arr = new int[5];
//            int[] arr = new int[]{2,3,6};
////                arr[0] =  1;
//                System.out.println(arr[0]);
        /*-----------------------------------*/

//        MyArray myArray = new MyArray();
//        myArray.insert(25);
//        myArray.insert(2);
//        myArray.insert(53);
////         数组元素展示
//        myArray.display();
////        数组元素查找
////        int index = myArray.search(25);
//        long index = myArray.search(58);
//
//        System.out.println(index);



        GoodArray<Integer> arr = new GoodArray();
        for (int i = 0; i < 10 ; i++) {
            arr.addLast(i);
        }

        System.out.println(arr.toString());
        arr.addFirst(9);
        arr.addLast(9);
        System.out.println(arr.toString());
        arr.removeElementAll(9);
        System.out.println(arr.toString());

        arr.add(1,100);

        System.out.println(arr.toString());



    }

    public TestArray() {
    }

    public TestArray(int age, String name, Boolean isOld) {
        this.age = age;
        this.name = name;
        this.isOld = isOld;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getOld() {
        return isOld;
    }

    public void setOld(Boolean old) {
        isOld = old;
    }
}
