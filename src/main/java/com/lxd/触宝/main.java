package com.lxd.触宝;

import java.util.*;

public class main {
    public static void main(String[] agrs){
        Scanner sc = new Scanner(System.in);
        SortedMap<Integer, Integer> map = new TreeMap<>();
        String str = sc.nextLine();
        String str1 = sc.nextLine();
        String[] arr1 = str.split(" ");
        for(int i=0;i<arr1.length;i++){
            if(map.containsKey(Integer.parseInt(arr1[i]))){
                map.put(Integer.parseInt(arr1[i]),map.get(Integer.parseInt(arr1[i]))+1);
            }else{
                map.put(Integer.parseInt(arr1[i]),1);
            }
        }
        String[] arr2 = str1.split(" ");
        for(int i = 0;i<arr2.length;i++){
            if(map.containsKey(Integer.parseInt(arr2[i]))){
                System.out.print(Integer.parseInt(arr2[i])+" ");
                map.put(Integer.parseInt(arr2[i]),map.get(Integer.parseInt(arr2[i]))-1);
            }
        }
        int count  = 0;
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            if(entry.getValue()!=0&&count<map.size()-1){
                System.out.print(entry.getKey()+" ");
            }else if(entry.getValue()!=0&&count==map.size()-1){
                System.out.print(entry.getKey());
            }
            count++;
        }
    }
}
