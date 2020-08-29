package com.lxd.B站;

public class fourOperationGet24 {
   static boolean result = false;
    public  static  boolean Game24Points (int[] arr) {

        if(arr == null || arr.length == 0) {
            return false;
        }
        f(arr, 1, arr[0]);
        return result;
    }
    public static void f(int[] arr, int index,int sum) {
        if(index >= arr.length || result == true) {
            if(sum == 24) {
                result = true;

            }
            return;
        }
        f(arr, index+1, sum + arr[index]);
        f(arr, index+1, sum - arr[index]);
        f(arr, index+1, sum * arr[index]);
        if(arr[index]!= 0) {
            f(arr, index+1, sum / arr[index]);
        }

    }

    public static void main(String[] args) {
        int[] arr = {2,1,0,12};
        System.out.print(fourOperationGet24.Game24Points(arr));
    }
}
