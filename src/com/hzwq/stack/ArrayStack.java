package com.hzwq.stack;

import com.hzwq.array.GoodArray;

/**
 * @Author: shaoRongGang
 * @Description:
 * @Date:Created in 16:34 2020/4/6
 * @Modifid By:
 * @Version：
 */
public class ArrayStack<E> implements Stack<E> {
    //  动态数组
    private GoodArray<E> array;

    //  确定元素个数数组的栈的构造器
    public ArrayStack(int capacity) {
        array = new GoodArray<>(capacity);
    }

    //  数组的栈的构造器
    public ArrayStack() {
        array = new GoodArray<>();
    }

    //向栈中添加元素
    @Override
    public void push(E e) {
        array.addLast(e);
    }

    //从栈中移除元素
    @Override
    public E pop() {
        return array.removeLast();
    }

    //获取栈顶元素
    @Override
    public E peek() {
        return array.getLast();
    }

    //获取栈中元素的长度
    @Override
    public int getSize() {
        return array.getSize();
    }

    //    栈是否为空
    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Stack: [");
        for (int i = 0; i < array.getSize(); i++) {
            res.append(array.get(i));
            if (i != array.getSize() - 1) {
                res.append(",");
            }
        }
        res.append("] top");
        return res.toString();
    }
}
