package com.wuym.basic.container;

import java.util.Iterator;
import java.util.Stack;

public class StackTest {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("U");
        stack.push("n");
        stack.push("c");
        stack.pop();
        stack.pop();
        stack.pop();
        stack.push("e");
        stack.push("r");
        stack.push("t");
        stack.pop();
        stack.pop();
        stack.pop();
        stack.push("a");
        stack.pop();
        stack.push("i");
        stack.pop();
        stack.push("n");
        stack.push("t");
        stack.push("y");
        stack.pop();
        stack.pop();
        stack.pop();
        stack.push("r");
        stack.push("u");
        stack.pop();
        stack.pop();
        stack.push("l");
        stack.push("e");
        stack.push("s");
        System.out.println(stack);
        Iterator<String> it = stack.iterator();
        while (it.hasNext()){
            String str = it.next();
            if(str.equals("e")){
                it.remove();
            }
            System.out.print(str);
        }
        System.out.println(stack);
    }
}
