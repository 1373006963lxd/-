package com.lxd.网易;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            int m = in.nextInt();
            ArrayList<Integer> list = new ArrayList<>();
            for(int i=0;i<m;i++){
                list.add(in.nextInt());
            }
            for(int i=0;i<m;i++){
                int temp = list.get(i);
                for(int j=1;j<temp;j++){
                    if(!list.contains(j)&&temp>j){
                        System.out.print(j+" ");
                        list.add(j);
                    }
                }
                System.out.print(temp+" ");
            }
            while(list.size()<n){
                int temp = list.size()+1;
                list.add(temp);
                if(list.size()==n){
                    System.out.print(temp);
                }else {
                    System.out.print(temp + " ");
                }
            }
        }
}
