package com.lxd.腾讯;

import java.util.Iterator;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

public class main4 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int k = sc.nextInt();
        SortedSet<String> set = new TreeSet<>();
        for(int i=0;i<str.length();i++){
            for(int j=i+1;j<=str.length();j++){
                set.add(str.substring(i,j));
            }
        }
        Iterator it = set.iterator();
        int count = 0;
        while(it.hasNext()){
            count++;
            if(count==k){
                System.out.print(it.next());
            }else{
                it.next();
            }
        }
    }
}
