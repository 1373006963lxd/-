package com.lxd.niukework.Train;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Test {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Map<Integer,Integer> map = new LinkedHashMap<>();
        int abc = 0,acc = 0;
        int count = 0;
        for(int i=1;i<10;i++){
            for(int j=0;j<10;j++){
                for(int k=0;k<10;k++){
                    if(i==j||j==k||i==k){
                        continue;
                    }else{
                        abc = i*100+j*10+k;
                        acc = i*100+k*10+k;
                        if((abc+acc)==n&&abc!=acc){
                            count++;
                            map.put(abc,acc);
                        }
                    }
                }
            }
        }
        System.out.println(count);
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
    }

}