package baidu;

import java.util.Scanner;

/**
 * @auther li xiao dong
 * @date 2020/3/29 0029 下午 20:51
 */
public class LcmGcd {
        public static void main(String[] args){
            Scanner sc = new Scanner(System.in);
            int count = sc.nextInt();
            int minlcm = 0;
            int maxgcd = 0;
            int result = 0;
            for(int i=count;i>0;i--){
                for(int j=count;j!=i;j--){
                    maxgcd = shu(i,j);
                    minlcm = beishu(i,j,maxgcd);
                    result = result > (minlcm-maxgcd)?result:(minlcm-maxgcd);
                }
            }
            System.out.println(result);
        }
        static void swap(int a,int b){
            int k;
            if(a<b){
                k=a;
                a=b;
                b=k;
            }
        }
        //求最大公约数
        static int shu(int a,int b){
            int k,y;
            swap(a,b);
            while(a%b!=0){
                y = a%b;
                a = b;
                b = y;
            }
            return b;
        }
        //求最小公倍数
        static int beishu(int a,int b,int l){
            int k;
            k = (a*b)/l;
            return k;
        }
}
