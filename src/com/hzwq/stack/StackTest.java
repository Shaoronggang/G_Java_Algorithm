package com.hzwq.stack;

/**
 * @Author: shaoRongGang
 * @Description:
 * @Date:Created in 16:14 2020/4/6
 * @Modifid By:
 * @Version：
 */
public class StackTest {
    public static void main(String[] args) {
        ArrayStack<Integer> stack = new ArrayStack<>();
        for (int i = 0; i < 10; i++) {
            stack.push(i);
            System.out.println(stack);
        }

        stack.pop();
        System.out.println(stack);

        Utils utils = new Utils();
       Boolean isValid =  utils.ParenthesisMatchingisValid("{[()]}");
        System.out.println(isValid);
    }
}
