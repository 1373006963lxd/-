package com.lxd.niukework.ArrayListPKLinkedList;

import java.util.ArrayList;
import java.util.LinkedList;

public class insert {

    /**
     * ArrayList和LinkedList插入数据对比
     * @author lxh96
     *
     */
       /* public static void main(String[] args) {
            ArrayList<Integer> arrayList = new ArrayList<Integer>();
            LinkedList<Integer> linkedList = new LinkedList<Integer>();

            System.out.println("向arrayList中插入100000条数据");
            long startTime = System.currentTimeMillis();
            for (int i = 0; i < 100000; i++) {
                arrayList.add(0,i);
            }
            long endTime = System.currentTimeMillis();
            System.out.println("ArrayList用时"+(endTime-startTime)+"ms");
            //1507ms
            System.out.println("向LinkedList中插入100000条数据");
            startTime = System.currentTimeMillis();
            for (int i = 0; i < 100000; i++) {
                linkedList.add(0,i);
            }
            endTime = System.currentTimeMillis();
            System.out.println("LinkedList用时"+(endTime-startTime)+"ms");
            //16ms
        }*/
   /* public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        LinkedList<Integer> linkedList = new LinkedList<Integer>();

        System.out.println("向arrayList中插入100000条数据");
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            arrayList.add(i);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("ArrayList用时"+(endTime-startTime)+"ms");
        //尾部：100万数据：43ms，10万：12ms、17ms
        System.out.println("向LinkedList中插入100000条数据");
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            linkedList.add(i);
        }
        endTime = System.currentTimeMillis();
        System.out.println("LinkedList用时"+(endTime-startTime)+"ms");
        //尾部：100万  111ms，10万：8ms、10ms
    }*/

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        LinkedList<Integer> linkedList = new LinkedList<Integer>();

        System.out.println("向arrayList中插入100000条数据");
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            arrayList.add(arrayList.size()/2,i);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("ArrayList用时"+(endTime-startTime)+"ms");
        //中间：10万：575ms、100万：98655ms
        System.out.println("向LinkedList中插入100000条数据");
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            linkedList.add(linkedList.size()/2,i);
        }
        endTime = System.currentTimeMillis();
        System.out.println("LinkedList用时"+(endTime-startTime)+"ms");
        //z中间：10万：17603ms，100万：
    }
}
