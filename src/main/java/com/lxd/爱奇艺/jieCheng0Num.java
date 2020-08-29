package com.lxd.爱奇艺;

import java.util.Scanner;

public class jieCheng0Num {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int result = 0;
        int t = 0;
        for(int i=1;i<=n;i++){
            t = i;
            while(t%5==0&&t!=1){
                result++;
                t/= 5;
            }
        }
        System.out.println(result);
    }
}
