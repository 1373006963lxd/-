package com.lxd.腾讯;

import java.util.Scanner;
class Link{
    int val;
    Link next;
    public Link(int val){
        this.val = val;
    }
}
public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        Link newHead = null;
        Link cur = newHead;
        for (int i = 0; i < n; i++) {
            Link node = new Link(sc.nextInt());
            if(i==k-1){
                continue;
            }else if(i==0){
                newHead = node;
                cur = newHead;
                System.out.print(cur.val+" ");
            }else{
                newHead.next = node;
                newHead = newHead.next;
                if(i!=(n-1)) {
                    System.out.print(newHead.val + " ");
                }else{
                    System.out.print(newHead.val);

                }
            }
        }
    }
}
