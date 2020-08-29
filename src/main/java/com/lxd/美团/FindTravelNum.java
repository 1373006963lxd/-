package com.lxd.美团;

import java.util.ArrayList;
import java.util.Scanner;

public class FindTravelNum {
    public static void main(String[] args){
        Scanner in  = new Scanner(System.in);
        int num = 0;
        int T = 5;
        ArrayList<String> list = new ArrayList<>();
        while(T>0) {
            T--;
            int count = in.nextInt();
            int result = 0;
            for (int i = 0; i < count; i++) {
                list.add(in.next());
                list.add(in.next());
            }
            input(count, list,result);
            list.clear();
        }
    }
    public static void input(int count,ArrayList<String> list,int result){
        //while(start<count*2)
        int start = 0;
        while (start<count*2){
            String startA = list.get(start);
            int end = start+3;
            while (end<count*2){
                if(list.get(end-1).equals(list.get(end-2))&&list.get(end).equals(startA)){
                    result++;
                    start = end+1;
                    break;
                }
                end+=2;
            }
            if(end>=count*2){
                start+=2;
            }
        }
        System.out.println(result);
    }
}
