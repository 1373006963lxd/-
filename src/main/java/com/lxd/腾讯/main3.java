package com.lxd.腾讯;

import java.math.BigInteger;
import java.util.Scanner;

public class main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0){
            t--;
            BigInteger n = sc.nextBigInteger();
            BigInteger mid = n.divide(new BigInteger("2"));
            BigInteger max = new BigInteger("0");
            BigInteger i = mid;
            while(i.compareTo(new BigInteger("0"))!=-1){
                BigInteger left = i;
                BigInteger j = mid.add(new BigInteger("1"));
                while(j.compareTo(n)==-1){
                    BigInteger right = j;
                    if((left.add(right)).compareTo(n)==0){
                        BigInteger add = getMax(left).add(getMax(right));
                        if(add.compareTo(max)==1){
                            max = add;
                        }
                        break;
                    }
                    j = j.add(new BigInteger("1"));
                }
                i = i.subtract(new BigInteger("1"));
            }
            System.out.println(max);
        }
    }
    public static BigInteger getMax(BigInteger n){
        BigInteger sum = new BigInteger("0");
        while(true){
            BigInteger n1 = n.remainder(new BigInteger("10"));
            sum= sum.add(n1);
            n = n.divide(new BigInteger("10"));
            if(n.compareTo(new BigInteger("0"))==0){
                break;
            }
        }
        return sum;
    }
}
