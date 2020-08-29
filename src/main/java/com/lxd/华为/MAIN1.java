package com.lxd.华为;

import java.util.Arrays;
import java.util.Scanner;

public class MAIN1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(get(n,arr));
    }
    public static int get(int n,int[] arr){
        int[]  sortArr = Arrays.copyOf(arr,n);
        Arrays.sort(sortArr);
        int p = n-1,q = n-1;
        while(p>=0 &&q>=0){
            if(arr[p]==sortArr[q]){
                --p;
                --q;
            }else{
                while(p>=0&&arr[p]!=sortArr[q]){
                    --p;
                }
            }
        }
        return q+1;
    }
}
