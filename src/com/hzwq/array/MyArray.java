package com.hzwq.array;

public class MyArray {
    private long[] array;
    // 表示有效数据的长度
    private int elements;

    public MyArray(){
        array = new long[50];
    }

    public MyArray(int maxsize){
        array = new long[maxsize];
    }

    /**
     * 添加数据
     */
    public void insert(long value){
        array[elements] = value;
        elements++;
    }

    /**
     * 数据的显示
     */
    public void display(){
        System.out.print("{");
        for (int i = 0; i < elements; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.print("}");
    }

    /**
     * 根据值来查找
     * @param value
     * @return
     */
    public int search(long value){
        int i;
        for ( i = 0; i <elements  ; i++) {
            if (value == array[i]){
                break;
            }
        }

        if (i == elements){
            return -1;
        }else {
            return -1;
        }

    }

    /**
     * 根据下标查找元素
     * @param index
     * @return
     */
    public long search(int index){

        if (index >= elements || index < 0){
            throw new ArrayIndexOutOfBoundsException();
        }else {
            return array[index];
        }

    }



}
