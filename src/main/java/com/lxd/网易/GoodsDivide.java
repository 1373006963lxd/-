package com.lxd.网易;

import java.util.Scanner;

public class GoodsDivide {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0) {
            T--;
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = sc.nextInt();
            //Arrays.sort(a); 这行可以不要，写的时候忘记删去了
            System.out.println(new Solution().value(n, a));
        }
    }
}
    class Solution{
        int[] a;
        int n;
        int ans = Integer.MAX_VALUE;
        public int value(int n, int[] a) {
            this.a = a;
            this.n = n;
            dfs(n - 1, 0, 0, 0);
            return ans;
        }

        //递归：一个物品选择给a、给b、扔掉三种选择
        void dfs(int index, int p1, int p2, int value) {
            if(index == -1) {
                if(p1 == p2 && ans > value) ans = value;
                return;
            }
            dfs(index - 1, p1 + a[index], p2, value);
            dfs(index - 1, p1, p2 + a[index], value);
            dfs(index - 1, p1, p2, value + a[index]);
        }
    }
