package com.lxd.触宝;

import java.util.Scanner;

public class main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String str1 = sc.nextLine();
        String[] arr = str.split(" ");
        String[] arr1 = str1.split(" ");
        int min = Integer.MAX_VALUE;
        if(arr1.length==1){
            System.out.println(-1);
        }else {
            for (int i = 0; i < arr.length; i++) {
                int start = Integer.parseInt(arr[i]);
                for (int j = i + 1; j < arr1.length; j++) {
                    int end = Integer.parseInt(arr1[j]);
                    min = Math.min(min, start + end);
                }
            }
            System.out.println(min);
        }
    }
}
