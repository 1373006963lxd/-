package com.lxd.触宝;

import java.util.Scanner;

public class main2 {
        public static void main(String[] args){
            Scanner sc = new Scanner(System.in);
            int a = sc.nextInt();
            int count = 0;
            int flag = 1;
            while(flag!=0){
                if((a&flag)!=0){
                    count++;
                }
                flag = flag<<1;
            }
            System.out.println(count);
        }
}
