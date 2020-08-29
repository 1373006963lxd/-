package com.lxd.niukework.temp;


import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Date;
import java.util.Scanner;

public class TestBufferClient3 {

    @Test
    public void client() throws IOException {
        SocketChannel clientChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1",8081));
        clientChannel.configureBlocking(false);
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            String str = sc.next();
            byteBuffer.put((new Date().toString()+"\n"+str).getBytes());
            byteBuffer.flip();
            clientChannel.write(byteBuffer);
            byteBuffer.clear();
        }
        clientChannel.close();
    }
}