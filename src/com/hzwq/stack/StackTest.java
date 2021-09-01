package com.hzwq.stack;

import java.util.Random;

/**
 * @Author: shaoRongGang
 * @Description:
 * @Date:Created in 16:14 2020/4/6
 * @Modifid By:
 * @Version：
 */
public class StackTest {
    public static void main(String[] args) {
//        ArrayStack<Integer> stack = new ArrayStack<>();
//        for (int i = 0; i < 10; i++) {
//            stack.push(i);
//            System.out.println(stack);
//        }
//
//        stack.pop();
//        System.out.println(stack);
//
//        Utils utils = new Utils();
//       Boolean isValid =  utils.ParenthesisMatchingisValid("{[()]}");
//        System.out.println(isValid);

        int opCount = 100000;

        ArrayStack<Integer> arrayStack = new ArrayStack<>();
        double time1 = testStack(arrayStack,opCount);
        System.out.println("ArrayStack time:" + time1 + "s");

        // 链表中的时间消耗，包含了更多的new操作，导致耗时。
        LinkListStack<Integer> linkListStack = new LinkListStack<>();
        double time2 = testStack(linkListStack,opCount);
        System.out.println("LinkListStack time:" + time2 + "s");
    }

    private static double testStack(Stack<Integer> stack,int opCount){
        long startTime = System.nanoTime();
        Random random = new Random();
        for (int i = 0; i < opCount; i++) {
            stack.push(random.nextInt(Integer.MAX_VALUE));
        }

        for (int i = 0; i < opCount; i++) {
            stack.pop();
        }

        long endTime = System.nanoTime();

        return (endTime - startTime)/10000000000.0;
    }
}
