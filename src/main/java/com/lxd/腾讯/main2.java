package com.lxd.腾讯;

import java.util.Scanner;

public class main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0){
            t--;
            Long n = sc.nextLong();
            Long mid = n/2;
            Long max = 0l;
            for(Long i=mid;i>=0;i--){
                Long left = i;
                for(Long j=mid+1;j<=n;j++){
                    Long right = j;
                    if((left+right)==n){
                        max = Math.max(max,(getMax(left)+getMax(right)));
                    }
                }
            }
            System.out.println(max);
        }
    }
    public static Long getMax(Long n){
        Long sum = 0l;
       while(true){
           Long n1 = n%10;
           sum+=n1;
           n = n/10;
           if(n==0){
               break;
           }
       }
       return sum;
    }
}
