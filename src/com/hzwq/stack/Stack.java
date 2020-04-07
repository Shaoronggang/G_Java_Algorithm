package com.hzwq.stack;

import com.hzwq.array.GoodArray;

/**
 * @Author: shaoRongGang
 * @Description:
 * @Date:Created in 22:23 2020/4/2
 * @Modifid By:
 * @Version：
 */
public interface Stack<E> {

//    入栈
void push(E e);
//  出栈
E pop();
// 查看栈顶的元素
E peek();
// 获取栈中元素的大小
int getSize();
// 栈是否为空
boolean isEmpty();

}
