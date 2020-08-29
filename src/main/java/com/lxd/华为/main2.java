package com.lxd.华为;

import java.util.Scanner;

public class main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();
        long c = sc.nextLong();
        long d = sc.nextLong();
        long[] nums = new long[]{a,b,c,d};
        if(a+b+c+d<4) {
            System.out.println(-1);
            return;
        }
    long sum = 0;
    for(long num:nums) {
        sum += num;
    }
    long avg = (sum/4)+1;
    int load;
    do{
        avg--;
        load = 0;
        long aa = 0;
        for(long num:nums){
            if(num<=avg){
                load+=(num-avg);
            }else{
                aa+=(num-avg);
            }
        }
        load+=(aa>>1);
    }while (load<0);
    System.out.println(avg*4);
    }
}
