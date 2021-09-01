package com.hzwq.queue.LeetCode;

import com.hzwq.array.MyArray;

import java.lang.reflect.Array;

public class ListNode {
    int val;
    ListNode next;
    public ListNode(){

    }
    public ListNode(int val){
        this.val = val;
    }
    public ListNode(int val,ListNode next){
        this.val = val;
        this.next = next;
    }


    // 向链表中添加数组中的数据
    public ListNode(int [] array){
        // 考虑异常情况
        if (array.length == 0 || array == null)
            throw new IllegalArgumentException("arr cannot be Empty");
        this.val = array[0];
        ListNode cur = this;

        for (int i = 1; i < array.length; i++) {
            cur.next = new ListNode(array[i]);
            cur = cur.next;
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        ListNode cur = this;
        while (cur != null){
            res.append(cur.val + "=>");
            cur = cur.next;
        }
        res.append("NULL");

        return res.toString();
    }
}
