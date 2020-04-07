package com.hzwq.stack;

import java.util.Stack;
/**
 * @Author: shaoRongGang
 * @Description: 栈的应用的经典案例,括号匹配
 * @Date:Created in 17:56 2020/4/6
 * @Modifid By:
 * @Version：
 */
public class Utils {


    /**
     * 使用栈判断'(','[','{'等括号是否匹配
     * @param s
     * @return
     */
    public boolean ParenthesisMatchingisValid(String s){
        ArrayStack<Character> stack = new ArrayStack();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{'){
                stack.push(c);
            }else {
                if (stack.isEmpty()) {
                    return false;
                }

                char topChar = stack.pop();
                if (c == ')' && topChar != '(')
                    return false;
                if (c == ']' && topChar != '[')
                    return false;
                if (c == '}' && topChar != '{')
                    return false;
            }
        }
        return stack.isEmpty();
    }

}
