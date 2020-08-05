package baidu;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @auther li xiao dong
 * @date 2020/3/29 0029 下午 22:00
 */
public class LargeNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        int a[] = new int[count];
        for(int i=0;i<count;i++){
            int num = sc.nextInt();
            a[i] = num;
        }
        int k = 0;
        for(int i=0;i<Integer.MAX_VALUE;i++){
            Arrays.sort(a);
            a[count-1] = a[count-1]-count;
            for(int j=0;j<count-1;j++){
                a[j] = a[j]+1;
            }
            k++;
            Arrays.sort(a);
            if(a[count-1]<count){
                System.out.println(k);
                break;
            }
        }
    }
}
