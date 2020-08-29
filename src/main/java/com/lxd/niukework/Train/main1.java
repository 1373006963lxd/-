package com.lxd.niukework.Train;

import java.util.Scanner;

public class main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        int t = sc.nextInt();
//        sc.nextLine();
        while (true) {
            String str = sc.nextLine();
            StringBuilder result = new StringBuilder();
            char[] ch = str.toCharArray();
            output(ch, result);
//            t--;
        }
    }
    public static  void output(char[] ch, StringBuilder result){
            if ((ch[0] >= 'A' && ch[0] <= 'Z') || (ch[0] >= 'a' && ch[0] <= 'z') || (ch[0] >= 0 && ch[0] <= 9)) {
                result.append(Character.toLowerCase(ch[0]));
            }
            for (int i = 1; i < ch.length; i++) {
                if ((ch[i] >= 'A' && ch[i] <= 'Z') || (ch[i] >= 'a' && ch[i] <= 'z') || (ch[i] >= 0 && ch[i] <= 9)) {

                    if (((ch[i - 1] < 'A' && ch[i - 1] > '9') || (ch[i - 1] > 'Z' && ch[i - 1] < 'a') || ch[i - 1] > 'z' || ch[i - 1] < '0' || ch[i - 1] == ' ') && (i - 1) != 0) {
                        result.append(Character.toUpperCase(ch[i]));
                    } else {
                        result.append(Character.toLowerCase(ch[i]));
                    }
                }
            }
            //再用循环输入输出的时候一定要换行println
            System.out.println(result.toString());
        }
}
