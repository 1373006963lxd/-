package com.lxd.美团;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MaxProfit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(sc.nextInt(),sc.nextInt());
        }
        System.out.println(maxProfit(map,a,b));
    }
    public static int maxProfit(HashMap<Integer, Integer> map,int a,int b){
        int result = 0;
        if(map.isEmpty()){
            return 0;
        }
        int[] arr = new int[map.size()];
        int i = 0;
        for(Map.Entry entry:map.entrySet()){
            arr[i++] = Integer.parseInt(entry.getKey().toString());
        }
        Arrays.sort(arr);
        int count = 1;
        for(int j=arr.length-1;j>=0;j--){
            if(count<=a){
                result+=arr[j];
                map.remove(arr[j]);
            }
            count++;
        }

        int[] arr1 = new int[map.size()-a];
        int k = 0;
        for(Map.Entry entry:map.entrySet()){
            arr[k++] = Integer.parseInt(entry.getValue().toString());
        }
        Arrays.sort(arr1);
        int count1 = 1;
        for(int j=arr1.length-1;j>=0;j--){
            if(count<=b){
                result+=arr[j];
                map.remove(arr[j]);
            }
            count1++;
        }
        return result;
    }
}
