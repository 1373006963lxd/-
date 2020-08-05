package com.lxd.niukework.Array;

public class GetMaxAndMin {
    static int  Max;
    static int Min;
    public static void GetMaxAndMin(int arr[]){
         Max = arr[0];
         Min = arr[0];
        int len =arr.length;
        for(int i=1;i<len-1;i++){
            if(i+1>len){
                if(arr[i]>Max){
                    Max = arr[i];
                }
                if(arr[i]<Min){
                    Min = arr[i];
                }
            }
            if(arr[i]>arr[i+1]){
                if(arr[i]>Max){
                    Max = arr[i];
                }
                if(arr[i+1]<Min){
                    Min = arr[i+1];
                }
            }
            if(arr[i]<arr[i+1]){
                if(arr[i+1]>Max){
                    Max = arr[i+1];
                }
                if(arr[i]<Min){
                    Min = arr[i];
                }
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = {7,3,19,40,7,1};
        GetMaxAndMin(arr);
        System.out.println("max"+" "+Max);
        System.out.println("min"+" "+Min);
    }
}
