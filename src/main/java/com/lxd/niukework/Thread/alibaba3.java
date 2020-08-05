package com.lxd.niukework.Thread;

import java.util.Scanner;

/**
 * @auther li xiao dong
 * @date 2020/3/29 0029 下午 18:04
 */
public class alibaba3 implements Runnable{
    private int n;
    public alibaba3(int n){
        this.n = n;
    }
    @Override
    public void run() {
        System.out.println("number"+":"+n);
    }

    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        int ThreadCount = sc.nextInt();
        for(int j=0;j<2;j++){
        for(int i=1;i<=ThreadCount;i++) {
            alibaba3 al = new alibaba3(i);
            Thread th = new Thread(al);
            th.start();
            th.join();
        }
        }
    }
}
