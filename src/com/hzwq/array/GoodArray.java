package com.hzwq.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: shaoRongGang
 * @Description: 这是使用java数组封装的数组类
 * @Date:Created in 22:25 2020/4/2
 * @Modifid By:
 * @Version：
 *  @param <E> 添加泛型,扩展了相应的功能,使相应的数据结构支持存放所有的数据类型
 */

public class GoodArray<E> {
    //  添加一个数组
    private E[] data;
    //  数组总有多少元素
    private int size;

    public GoodArray(int capacity) {
//         初始化一个数组
        data = (E[]) new Object[capacity];
        this.size = 0;
    }

    public GoodArray() {
        this(10);
    }

    //  获取数组的元素个数
    public int getSize() {
        return size;
    }

    //    返回数组的容量
    public int getCapacity() {
        return data.length;
    }

    //  判断数组是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    //    向数组尾部添加一个数据
    public void addLast(E e) {
        add(size, e);
    }

    //    向数组头部添加一个数据
    public void addFirst(E e) {
        add(0, e);
    }

    //    向数组指定位置添加一个数据
    public void add(int index, E e) {

        if (index < 0 || index > size)
            throw new IllegalArgumentException("addLast failed,Array is full");

        if (size == data.length)
            reSize(2*data.length);
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }

        data[index] = e;
        size++;
    }

    /**
     * 数组的扩容
      * @param newCapcity 新的容量值
     */
    private void reSize(int newCapcity) {
        E[] newArray = (E[]) new Object[newCapcity];
        for (int i = 0; i < size ; i++) {
            newArray[i] = data[i];
        }
//      改变data的指向，这样原来的数组就会被回收
        data = newArray;
    }

    //    获取index 索引下的元素
    public E get(int index) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("get failed,index is Illegal");
        return data[index];
    }

    //   修改index索引下的元素的值
    public void set(int index, E e) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("set failed,index is Illegal");
        data[index] = e;
    }

    //   查看数组中是否包含某个元素
    public boolean contain(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    //    查看数组中是否包含这个元素，如果包含的话，返回下标，如果不包含返回-1
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    //查找
    public List<Integer> findAll(E e) {
        List<Integer> list = new ArrayList<>();
        for (int i = size-1; i >= 0 ; i--) {
            if (data[i].equals(e)) {
                list.add(i);
            }
        }

        if (list.size() > 0) {
            return list;
        }

        return null;
    }

    //    删除数组指定位置数据,并且返回删除的元素
    public E remove(int index) {

        if (index < 0 || index > size)
            throw new IllegalArgumentException("remove failed,Index is illgal");

        E ret = data[index];
        for (int i = index + 1; i < size ; i++) {
            data[i - 1] = data[i];
        }

        size--;
        data[size] = null;  // loitering objects  != memory leak   指得是主动回收相应的已经没有用的对象（暂存的）

        if (size == data.length/2)
            reSize(data.length/2);
        return ret;
    }

    public void removeItem(int index) {

        if (index < 0 || index > size)
            throw new IllegalArgumentException("removeItem failed,index is illgal");

        E ret = data[index];
        for (int i = index; i <= size - 1; i++) {
            data[i] = data[i + 1];
        }

        size--;
    }


    //  todo：需要优化  删除数组中所有的元素
    public void removeElementAll(E e) {
//        使用了数组里面封装的方法来实现相应的删除所有的功能的方法
//        boolean flag = true;
//
//        while (flag){
//            int ret = find(e);
//            if (ret == -1)
//                flag = false;
//
//            remove(ret);
//        }

// 使用集合来实现删除数组中全部元素的功能
        List<Integer> indexList = findAll(e);

        for (Integer a : indexList) {
            this.toString();
            remove(a);
        }
    }

    //删除第一个元素 返回删除的值
    public E removeFirst() {
        return remove(0);
    }

    //    删除一个元素，并且返回一个值，判断是否删除成功
    public int removeElement(E e) {
        int index = find(e);

        if (index != -1) {
            remove(index);
        }
        return index;
    }

    //    删除数组中最后一个元素
    public E removeLast() {
        return remove(size - 1);
    }


    /**
     * @return
     */
    @Override
    public String toString() {
        StringBuffer stringBuilder = new StringBuffer();
        stringBuilder.append(String.format("Array :size=%d , capacity = %d\n", size, data.length));
        stringBuilder.append("[");
        for (int i = 0; i < size; i++) {
            stringBuilder.append(data[i]);
            if (i != size - 1) {
                stringBuilder.append(",");
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }


}
