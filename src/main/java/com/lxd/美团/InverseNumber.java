package com.lxd.美团;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class InverseNumber {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(true) {
            Long n = in.nextLong();
            HashMap<Long, Long> map = new HashMap<>();
            int result = 0;
            for (Long i = 1L; i < n / 2; i++) {
                Long temp = i * 4;
                if (isNiXu(i, temp)) {
                    result++;
                    map.put(i, temp);
                }
            }
            System.out.println(result);
            for (Map.Entry<Long, Long> entry : map.entrySet()) {
                System.out.println(entry.getKey() + " " + entry.getValue());
            }
        }
    }
    public static boolean isNiXu(Long a,Long b){
        String a1 = a.toString();
        String b1 = b.toString();
        if(a1.length()!=b1.length()){
            return false;
        }
        StringBuilder s = new StringBuilder();
        for(int i = b1.length()-1;i>=0;i--){
            s.append(b1.charAt(i));
        }
        if(a==Long.parseLong(s.toString())){
            return true;
        }
        return false;
    }
}
