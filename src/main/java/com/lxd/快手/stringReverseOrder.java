package com.lxd.快手;

public class stringReverseOrder {
    public static void main(String[] args) {
        String str = "My name is lxd";
        System.out.print(stringReverseOrder.reverseOrder(str));
    }
    public  static  String reverseOrder(String str){
        char[] arr = str.trim().toCharArray();
        StringBuilder result = new StringBuilder();
        for(int i=arr.length-1;i>=0;i--){
            result.append(arr[i]);
            }
        return result.toString();
        }
    }
