package com.hzwq.linkList;

/**
 * @Author: shaoRongGang
 * @Description: 链表的测试类
 * @Date:Created in 22:06 2020/4/27
 * @Modifid By:
 * @Version：
 */
public class LinkListTest {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }

        linkedList.add(2,555);
        System.out.println(linkedList);
    }
}
