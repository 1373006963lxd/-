package com.lxd.niukework.setTest;

import java.util.HashSet;
import java.util.Set;

public class setTest {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("A");
        if(!set.add("A")){
            System.out.print(true);
        }else{
            System.out.print(false);
        }
    }
}
