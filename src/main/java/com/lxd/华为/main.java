package com.lxd.华为;

import java.util.Scanner;

public class main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine().trim();
        String str1 = sc.nextLine().trim();
        int score = 0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)==str1.charAt(i)){
                score+=20;
            }else if(score!=0){
                score-=10;
            }
        }
        System.out.println(score);
    }
}
