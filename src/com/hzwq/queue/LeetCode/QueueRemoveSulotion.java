package com.hzwq.queue.LeetCode;

public class QueueRemoveSulotion {
    public ListNode removeElements(ListNode head, int val,int depth){

        // 初始编码
//        while(head != null && head.val == val){
//            ListNode delNode = head;
//            head = head.next;
//            delNode.next = null;
//        }
//
//        if(head == null)
//            return head;
//        ListNode prev = head;
//        while(prev.next !=null){
//            if(prev.next.val == val){
//                ListNode delNode = prev.next;
//                prev.next = delNode.next;
//                delNode.next = null;
//            }else
//                prev = prev.next;
//        }
//        return head;

        // 使用虚拟头节点方案

//        ListNode dummyHead = new ListNode(-1);
//        dummyHead.next = head;
//        ListNode prev = dummyHead;
//        while (prev.next != null){
//            if (prev.next.val == val){
//                prev.next = prev.next.next;
//            }else
//                prev = prev.next;
//        }
//        return dummyHead.next;

        // 使用递归来解决


        // 最基本问题,一般是递归结束的标志
//        if (head == null)
//            return null;
//        ListNode res = removeElements(head.next,val);
//        if (head.val == val)
//            return res;
//        else
//            head.next = res;
//            return head;

            //进一步简化递归函数
//        head.next = removeElements(head.next,val);
//        return head.val == val?head.next:head;

        // 递归的调用
        String depthString = generateDepthString(depth);
        System.out.print(depthString);
        System.out.println("Call:remove" + val + "in" + head);
        if (head == null){
            System.out.print(depthString);
            System.out.print("Return:" + head);
            return head;
        }

        ListNode res =  removeElements(head.next,val,depth + 1);
        System.out.print(depthString);
        System.out.println("After remove " + val + ":" + res);
        ListNode ret;
        if (head.val == val)
            ret = res;
        else{
            head.next = res;
            ret = head;
        }

        System.out.print(depthString);
        System.out.println("Return：" + ret);
        return ret;

    }


    private String generateDepthString(int depth){
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            res.append("--");
        }
        return res.toString();
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,6,4,5,6};
        ListNode head = new ListNode(nums);
        System.out.println(head);
        int val = 6;
        ListNode headNode = (new QueueRemoveSulotion()).removeElements(head,val,0);
        System.out.println(headNode);
    }


}
