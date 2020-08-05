package com.lxd.niukework.PinDuoDuo;

import java.util.*;

/**
 * @auther li xiao dong
 * @date 2020/8/2 0002 下午 22:53
 */
public class DiceSort {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            Map<String,Integer> hashMap=new HashMap<>();
            int n = scanner.nextInt();
            for (int i=0;i<n;i++){
                int [] a=new int[6];
                for (int j=0;j<6;j++){
                    a[j]=scanner.nextInt();
                }
                swap(a,0);
                String s = Arrays.toString(a);
                if (hashMap.containsKey(s)){
                    Integer integer = hashMap.get(s);
                    hashMap.put(s,integer+1);
                }else {
                    hashMap.put(s,1);
                }
            }
            System.out.println(hashMap.size());
            Collection<Integer> values = hashMap.values();
            int []a=new int[values.size()];
            int k=0;
            for (Integer value : values) {
                a[k++]=value;
            }

            Arrays.sort(a);
            for (int i=a.length-1;i>=0;i--){
                if (i==0){
                    System.out.print(a[i]);
                }else {
                    System.out.print(a[i] + " ");
                }
            }
            System.out.println();


        }


    }

    private static void swap(int[] a,int left) {
        if (left<4) {
            int index = 0;
            int min=Integer.MAX_VALUE;
            for (int i = left; i <6; i++) {
                if (a[i] <min) {
                    min=a[i];
                    index = i;
                }
            }
            if (index==left){

            } else if (index-left==1){
                int tmp=a[left];
                a[left]=a[index];
                a[index]=tmp;

                tmp=a[4];
                a[4]=a[5];
                a[5]=tmp;
            } else if (index%2==0){
                //直接反转不用变形
                int tmp=a[left];
                int tmp2=a[left+1];
                a[left]=a[index];
                a[left+1]=a[index+1];
                a[index]=tmp2;
                a[index+1]=tmp;

            }else {
                int tmp=a[left];
                int tmp2=a[left+1];
                a[left]=a[index];
                a[left+1]=a[index-1];
                a[index-1]=tmp;
                a[index]=tmp2;
            }
            swap(a,left+2);

        }

    }
}
