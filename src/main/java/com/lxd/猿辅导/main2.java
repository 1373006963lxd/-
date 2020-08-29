package com.lxd.猿辅导;


import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

class BinNode{
    Integer val;
    BinNode leftNode,rightNode;
    public BinNode(Integer n){
        this.val = n;
    }
    public BinNode() {
    }

    public Integer getVal() {
        return val;
    }
    public void setVal(int val) {
        this.val = val;
    }
    public BinNode getLeftNode() {
        return leftNode;
    }
    public void setLeftNode(BinNode leftNode) {
        this.leftNode = leftNode;
    }
    public BinNode getRightNode() {
        return rightNode;
    }
    public void setRightNode(BinNode rightNode) {
        this.rightNode = rightNode;
    }
}

public class main2{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        BinNode root = creatBin(arr);
        bianLi(root);
    }

    public static BinNode creatBin(int[] a){
        int i = 1;
        BinNode root = new BinNode(a[0]);
        BinNode current = null;
        Integer value = null;
        //层序创建二叉树
        LinkedList<BinNode> queue = new LinkedList<BinNode>();
        queue.offer(root);
        while(i<a.length) {
            current = queue.poll();//从链表中移除并获取第一个节点
            value = a[i++];
            if(value!=null) {
                BinNode left =new BinNode(value);
                current.setLeftNode(left);//创建当前节点的左孩子
                queue.offer(left); // 在链表尾部 左孩子入队
            }
            value=a[i++];
            if(value!=null) {
                BinNode right =new BinNode(value);
                current.setRightNode(right);//创建当前节点的右孩子
                queue.offer(right);// 在链表尾部 右孩子入队
            }
        }
        return root;
    }

    public static void bianLi(BinNode pRootOfTree) {
        Stack<BinNode> stack = new Stack<>();
        BinNode cur = pRootOfTree;
        while(cur!=null||!stack.isEmpty()){
            while(cur!=null){
                stack.push(cur);
                System.out.print(cur.val+" ");
                cur = cur.leftNode;
            }
            cur = stack.pop();
            cur = cur.rightNode;
        }
    }
}