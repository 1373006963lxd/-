package com.lxd.niukework.Sort;

import java.util.Arrays;

/*
*
* 快速排序
*
* */
public class quickSort {
    public static void sort(int array[],int low,int high){
        int i;
        int j;
        int index;
        if(low>high){
            return;
        }
        i = low;
        j = high;
        index = array[low];//取左边的值为基准值
        if(high-low+1<5){
            insert(array,low,high);
        }else {
            while (i < j) {
                while (i < j && array[j] > index) {
                    j--;
                }
                if (i < j) {//从右边找到小于基准的值，则与右边的互换
                    array[i++] = array[j];
                }
                while (i < j && array[i] < index) {
                    i++;
                }
                if (i < j) {//从左边找到大于基准的值，则与左边的互换。
                    array[j--] = array[i];
                }
                array[i] = index;//基准值的位置
                sort(array, low, i - 1);
                sort(array, i + 1, high);
            }
        }
    }

    public static void insert(int[] a,int low,int high){
        for(int i=low+1;i<=high;i++){
            int temp = a[i];
            for(int j=low;j<i;j++){
                if(a[j]>temp){
                    int t = temp;
                    a[i] = a[j];
                    a[j] = t;
                }
            }
        }
    }

    public static void quicjSort(int array[]){
        sort(array,0,array.length-1);
    }

    public static void main(String[] args) {
        int[] a = {5,2,6,1,7,3,4,4};
        quickSort.sort(a,0,a.length-1);
        System.out.print(Arrays.toString(a));
    }
}
