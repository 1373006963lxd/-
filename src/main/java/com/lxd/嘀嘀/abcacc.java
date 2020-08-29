package com.lxd.嘀嘀;

import java.util.Map;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

public class abcacc {
        public static void main(String[] args) {
            int n = new Scanner(System.in).nextInt();
            SortedMap<Integer,Integer> map = new TreeMap<>();

            for (int i = 101; i < 2000; i++) {
                if (isABC(i) && isABB(n-i) && isSame(i,n-i)){
                    map.put(i,n-i);
                }
            }
            System.out.println(map.size());
            for(Map.Entry<Integer,Integer> e : map.entrySet()){
                System.out.println(e.getKey() + " " + e.getValue());
            }

        }
        public static boolean isSame(int m,int n){
            int ma = m / 100;
            int mc = m % 10;

            int na = n / 100;
            int nc = n % 10;

            return ma == na && mc == nc;
        }

        public static boolean isABC(int n){
            if (n < 100 || n >= 1000)
                return false;
            int a = n / 100;
            int b = (n % 100) / 10;
            int c = n % 10;

            return a != b && a != c && b != c;
        }

        public static boolean isABB(int n){
            if (n < 100 || n >= 1000)
                return false;
            int a = n / 100;
            int b = (n % 100) / 10;
            int c = n % 10;

            return a != b && b == c;
        }
}
