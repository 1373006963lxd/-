package com.lxd.爱奇艺;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class kuoHao {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        boolean result = isValid(str);
        String out = result==true?"True":"False";
        System.out.println(out);
    }
    public static boolean isValid(String str){
        Stack<Character> stack = new Stack<>();
        Map<Character,Character> map = new HashMap<>();
        char[] chars = str.toCharArray();
        map.put(']','[');
        map.put('}','{');
        map.put(')','(');
        for(int i=0;i<str.length();i++){
            if(!map.containsKey(chars[i])){
                stack.push(chars[i]);
            }else{
                if(stack.isEmpty()||map.get(chars[i])!=stack.pop()){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
