package com.lxd.niukework.Train;

import java.util.ArrayList;
import java.util.Scanner;

public class list {
        public static void main(String[] args){
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            ArrayList<Integer> list = get(n);
            int[][] res = printMatrix(list,n);
            for(int[] i : res){
                for(long j : i){
                    System.out.print(j + " ");
                }
                System.out.println();
            }
        }
        public static int Fibonacci(int n) {
            if(n<=1){
                return n;
            }
            return Fibonacci(n-1)+Fibonacci(n-2);
        }
        public static ArrayList<Integer> get(int n){
            ArrayList<Integer> list = new ArrayList<>();
            for(int i=n*n;i>0;i--){
                list.add(Fibonacci(i));
            }
            return list;
        }
        public  static int[][]  printMatrix(ArrayList<Integer> list,int n) {
            //行数
            int rows = n;
            //列数
            int cols = n;
            //总数据量
            int len = n*n;
            //定义链表
            int[][] arr = new int[n][n];
            //分为四个方向，上下左右
            int top = 0;
            int down = rows-1;
            int right = cols-1;
            int left = 0;
            while(len!=0){
                //从左到右
                for(int i =left;i<=right;i++){
                    arr[top][i] = list.remove(0);
                    len--;
                    //每一个循环都要判断是否已经结束遍历
                    if(len<=0){
                        return arr;
                    }
                }
                //上面遍历完则上面就说明已经遍历，则不能在遍历
                top++;
                //从上到下
                for(int i=top;i<=down;i++){
                    arr[i][right] = list.remove(0);
                    len--;
                    if(len<=0){
                        return arr;
                    }
                }
                right--;
                //从右到左
                for(int i=right;i>=left;i--){
                    arr[down][i] = list.remove(0);
                    len--;
                    if(len<=0){
                        return arr;
                    }
                }
                down--;
                //从下到上
                for(int i=down;i>=top;i--){
                    arr[i][left] = list.remove(0);
                    len--;
                    if(len<=0){
                        return arr;
                    }
                }
                left++;
            }
            return arr;
        }
}
