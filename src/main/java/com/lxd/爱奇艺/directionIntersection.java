package com.lxd.爱奇艺;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class directionIntersection {
        public static void main(String[] args){
            Scanner sc = new Scanner(System.in);
            String str = sc.next();
            boolean result = isXiangYu(str);
            String out = result==true?"True":"False";
            System.out.println(out);
        }
        public static boolean isXiangYu(String str){
            int n = str.length();
            int x = 0,y=0;
            Set<String> result = new HashSet();
            result.add(x+","+y);
            for(int i=0;i<n;i++){
                switch(str.charAt(i)){
                    case 'N':
                        x++;
                        break;
                    case 'S':
                        x--;
                        break;
                    case 'E':
                        y++;
                        break;
                    case 'W':
                        y--;
                        break;
                    default:
                        break;
                }
                if(!result.add(x+","+y)){
                    return true;
                }
            }
            return false;
        }
}
