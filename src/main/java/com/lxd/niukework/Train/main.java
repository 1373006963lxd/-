package com.lxd.niukework.Train;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] strArr = str.split(" ");
        StringBuilder result = new StringBuilder();
        for(int i=0;i<strArr.length;i++){
            if(i==0){
                result.append(strArr[i].toLowerCase());
            }else{
                result.append(tuoFeng(strArr[i]));
            }
        }
        System.out.println(result);
    }
    public static String tuoFeng(String str){
        char[] ch = str.toCharArray();
        StringBuilder result = new StringBuilder();
        for(int i=0;i<ch.length;i++) {
            if ((ch[i] >= 'A' && ch[i] <= 'Z') || (ch[i] >= 'a' && ch[i] <= 'z') || (ch[i] >= 0 && ch[i] <= 9)) {
                if (i == 0) {
                    result.append(Character.toUpperCase(ch[i]));
                } else {
                    result.append(Character.toLowerCase(ch[i]));
                }
            }
        }
        return result.toString();
    }
}