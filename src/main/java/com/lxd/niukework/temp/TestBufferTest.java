package com.lxd.niukework.temp;

import org.junit.jupiter.api.Test;

import java.nio.ByteBuffer;

//针对nio中的缓存api测试
public class TestBufferTest {

    @Test
    public void test1() {
        String str = "abcd";
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        System.out.println("--------------------------------allocate()初始状态-------------------------------");
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());


        byteBuffer.put(str.getBytes());
        System.out.println("--------------------------------put()后状态-------------------------------");
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());

        byteBuffer.flip();
        System.out.println("--------------------------------flip()切换模式后状态-------------------------------");
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());


        byte[] dst = new byte[byteBuffer.limit()];
        byteBuffer.get(dst);
        System.out.println("----------------------------------读取缓冲区中的数据-----------------------------");
        System.out.println(new String(dst,0,dst.length));
        System.out.println("--------------------------------get()后状态-------------------------------");
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());

        byteBuffer.clear();
        System.out.println("--------------------------------clear()后状态-------------------------------");
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());

        byteBuffer.put(str.getBytes());
        System.out.println("--------------------------------put()后状态-------------------------------");
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());

        byteBuffer.put(str.getBytes());
        System.out.println("--------------------------------put()后状态-------------------------------");
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());

        //必须切换读状态
        byteBuffer.flip();
        byte[] bytes = new byte[byteBuffer.limit()];
        byteBuffer.get(bytes);
        System.out.println("-----------------------------------读完数据后----------------------------------");
        System.out.println(new String(bytes,0,bytes.length));
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());

        byteBuffer.clear();//直接切换状态只改变position的位置,所以每读完应该clear（）,每写完数据读的时候flip（）
        String str1 = "abcdefghigk";
        byteBuffer.put(str1.getBytes());
        System.out.println("-----------------------------------读取完直接存数据后----------------------------------");
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());
    }

    @Test
    public void test2(){
        String str = "abcdef";
        ByteBuffer buf = ByteBuffer.allocate(1024);
        buf.put(str.getBytes());

        buf.flip();
        byte[] dst = new byte[buf.limit()];
        buf.get(dst,0,2);
        System.out.println(new String(dst,0,2));
        System.out.println("----------------------------读取两个字节后的状态--------------------------------");
        System.out.println(buf.position());
        System.out.println(buf.limit());
        System.out.println(buf.capacity());

        //标记
        buf.mark();
        buf.get(dst,2,2);
        System.out.println(new String(dst,2,2));
        System.out.println("------------------继续读后的position的位置");
        System.out.println(buf.position());

        //reset() 恢复到mark的位置
        buf.reset();
        System.out.println("-----------------------------position恢复到mark的位置-----------------------------------");
        System.out.println(buf.position());

        //判断缓冲区是否还剩余数据
        if(buf.hasRemaining()){
            System.out.println("-------------------------查看缓冲区中还剩余多少可操作的数据（position后面的数据个数------------------------------------）");
            System.out.println(buf.remaining());
        }
    }
}