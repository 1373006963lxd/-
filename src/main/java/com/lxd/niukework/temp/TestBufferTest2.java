package com.lxd.niukework.temp;


import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class TestBufferTest2 {

    //客户端
    @Test
    public void client() throws IOException {
        //获取通道
        SocketChannel clientChannel=null;
        FileChannel   inChannel = null;
        ByteBuffer byteBuffer = null;
        try {
            clientChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1",8080));
            inChannel = FileChannel.open(Paths.get("F:\\JavaIDEA\\NiuKe\\src\\main\\resources\\static\\1.jpg"), StandardOpenOption.READ);

            byteBuffer = ByteBuffer.allocate(1024);

            while(inChannel.read(byteBuffer)!=-1){
                byteBuffer.flip();
                clientChannel.write(byteBuffer);
                byteBuffer.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            inChannel.close();
            clientChannel.close();
        }

        clientChannel.shutdownOutput();
        int len = 0;
        while((len=clientChannel.read(byteBuffer))!=-1){
            byteBuffer.flip();
            System.out.println(new String(byteBuffer.array(),0,len));
            byteBuffer.clear();
        }
    }


    //服务端
    @Test
    public void server() throws IOException {
        //获取通道
        ServerSocketChannel serverChannel = ServerSocketChannel.open();
        FileChannel outChannel = FileChannel.open(Paths.get("F:\\JavaIDEA\\NiuKe\\src\\main\\resources\\static\\5.jpg"), StandardOpenOption.READ,StandardOpenOption.WRITE,StandardOpenOption.CREATE);
        //绑定连接
        serverChannel.bind(new InetSocketAddress(8080));
        //获取客户端连接的通道
        SocketChannel clientChannel = serverChannel.accept();

        ByteBuffer buf = ByteBuffer.allocate(1024);
        //接受客户端的数据，并保存到本地
        while(clientChannel.read(buf)!=-1){
            buf.flip();
            outChannel.write(buf);
            buf.clear();
        }
        //发送反馈给客户端
        buf.put("服务端接受数据成功".getBytes());
        buf.flip();
        clientChannel.write(buf);

        outChannel.close();
        serverChannel.close();
        clientChannel.close();
    }



}