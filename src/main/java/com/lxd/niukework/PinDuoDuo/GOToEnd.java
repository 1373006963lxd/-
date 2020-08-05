package com.lxd.niukework.PinDuoDuo;

import java.util.Scanner;

/**
 * @auther li xiao dong
 * @date 2020/8/2 0002 下午 22:19
 */
public class GOToEnd {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int k = 0;
        int n = 0;
        //输入k起点到终点的距离及次数
        k = in.nextInt();
        n = in.nextInt();
        int[] a = new int[n];
        for(int i=0;i<n;i++){
            a[i] = in.nextInt();
        }
        int sum = 0;
        int roback = 0;
        int total = 0;
        //总距离达不到终点的情况
        for(int i=0;i<n;i++){
            total+=a[i];
        }
        if(total<k){
            System.out.print(k-total);
            System.out.print(" ");
            System.out.print(0);
        }else{
            //距离达到的情况及回退的情况
            for(int i=0;i<n;i++){
                sum+=a[i];
                if(sum==k){
                    System.out.print("paradox");
                    break;
                }else if(sum>k){
                    sum = k-(sum-k);
                    roback++;
                    if(i==(n-1)){
                        System.out.print((k-sum));
                        System.out.print(" ");
                        System.out.print(roback);
                    }
                }
            }
        }
    }
}
