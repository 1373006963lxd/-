package com.lxd.niukework.Sort;

import java.util.Arrays;

public class BinarySearch {
    public static int binarySearch(int[] a,int k){
        int len = a.length;
        int start = 0;
        int end = len-1;
        Arrays.sort(a);
        while(start<=end){
            int mid = (start+end)/2;
            if(a[mid]==k){
                return mid;
            }else if(a[mid]<k){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] a = {1,2,10,5,4,7};
        System.out.print(BinarySearch.binarySearch(a,10));

    }
}
