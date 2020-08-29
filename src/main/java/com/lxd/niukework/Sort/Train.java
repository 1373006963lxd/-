package com.lxd.niukework.Sort;

import java.util.Arrays;

public class Train {
    public static void quick(int[] a,int start,int end) {
        int len = a.length;
        if (start > end) {
            return;
        }
        int i = start;
        int j = end;
        int flag = a[start];
        int sub = end - start;
            while (i < j) {
                while (i < j && a[j] > flag) {
                    j--;
                }
                if (i < j) {
                    a[i++] = a[j];
                }
                while (i < j && a[i] < flag) {
                    i++;
                }
                if (i < j) {
                    a[j--] = a[i];
                }
            }
        a[i] = flag;
        quick(a,start,i-1);
        quick(a,i+1,end);
    }

    public static void main(String[] args) {
        int[] a = {5,2,6,1,7,3,4,4};
        Train.quick(a,0,a.length-1);
        System.out.print(Arrays.toString(a));
    }
}
