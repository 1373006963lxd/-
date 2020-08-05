package com.lxd.niukework.PinDuoDuo;

import java.util.Scanner;

/**
 * @auther li xiao dong
 * @date 2020/8/2 0002 下午 22:27
 */
public class ChineseDinner {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = 0,m = 0,t = 0;
            n = in.nextInt();
            m = in.nextInt();
            t = in.nextInt();
        int[][]  a= new int[n+1][2];
        int[][]  b= new int[m+1][2];
        //中餐二维数组
        for(int i=0;i<n;i++){
            a[i][0] = in.nextInt();
            a[i][1] = in.nextInt();
        }
        a[n][0] = 0;
        a[n][1] = 0;
        //晚餐二维数组
        for(int j=0;j<m;j++){
            b[j][0] = in.nextInt();
            b[j][1] = in.nextInt();
        }
        b[m][0] = 0;
        b[m][1] = 0;
        int mnum = 0;
        int rnum = -1;
        boolean flag = true;
        for(int i=0;i<=n;i++){
            //中餐热量值
            int zr = a[i][0];
            //中餐美味值
            int zm = a[i][1];
            for(int j=0;j<=m;j++){
                //晚餐热量值
                int wr = b[j][0];
                //晚餐美味值
                int wm = b[j][1];
                mnum = zm+wm;
                if(mnum>=t&&flag){
                    rnum = zr+wr;
                    flag = false;
                }else if(mnum>=t){
                    rnum = Math.min(rnum,(zr+wr));
                }
            }
        }
        System.out.print(rnum);
    }

}
