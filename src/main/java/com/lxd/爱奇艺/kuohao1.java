package com.lxd.爱奇艺;

import java.util.Scanner;
import java.util.Stack;

public class kuohao1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(piPei(str));
    }
    public static boolean piPei(String str){
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<str.length();i++) {
            switch (str.charAt(i)) {
                case '(':
                case '{':
                case '[':
                    stack.push(str.charAt(i));
                    continue;
                case ')':
                    if (stack.isEmpty() || stack.pop() != '(') {
                        return false;
                    }
                    continue;
                case '}':
                    if (stack.isEmpty() || stack.pop() != '{') {
                        return false;
                    }
                    continue;
                case ']':
                    if(stack.isEmpty()||stack.pop()!='['){
                        return false;
                    }
                    continue;
            }
        }
        return stack.isEmpty();
    }
}
