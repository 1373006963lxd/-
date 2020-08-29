package com.lxd.快手;

import java.util.Scanner;

public class stringReverseOrder1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        //解决空行的问题
        sc.nextLine();
        while(t>0) {
                String str = sc.nextLine();
                System.out.println(reverseString(str));
                t--;
        }
    }
    public static String reverseString(String str){
        String[] arr = str.split(" ");
        StringBuffer result = new StringBuffer();
        for(int i=arr.length-1;i>=0;i--){
            if(i==0){
                result.append(arr[i]);
            }else {
                result.append(arr[i] + " ");
            }
        }
        return result.toString();
    }
}
