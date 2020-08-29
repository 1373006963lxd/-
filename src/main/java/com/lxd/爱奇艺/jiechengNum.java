package com.lxd.爱奇艺;

import java.math.BigInteger;
import java.util.Scanner;

public class jiechengNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0) {
            t--;
            int n = sc.nextInt();
            BigInteger result = new BigInteger("1");
            for (int i = 1; i <= n; i++) {
               result =  result.multiply(new BigInteger(String.valueOf(i)));
            }
            System.out.println(get0Num(result));
        }
    }
    public static int get0Num(BigInteger result){
        String str = String.valueOf(result);
        int count = 0;
        for(int i=str.length()-1;i>=0;i--){
            if(str.charAt(i)=='0'){
                count++;
            }else if(str.charAt(i)!='0'){
                break;
            }
        }
        return count;
    }
}
