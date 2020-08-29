package com.lxd.niukework.temp;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.Duration;
import java.time.LocalDateTime;

/*
* 一、通道（channel）：用于源节点与目标节点的连接。负责缓冲区中数据的传输。本身不存储数据。因此需要配合缓冲区使用。
*
* 二、通道的主要实现类
* java.nio.channel.Channel接口：
*       FileChannel
*       SocketChannel
*       ServerSocketChannel
*       DatagramChannel
* 三、获取通道：
* 1、Java针对支持通道的类提供了getChannel（）方法
* 本地IO:
* FileInputStream、FileOutPutStream
* RandomAccessFile
* 网络IO:
* Socket
* ServerSocket
* DatagramSocket
* 2、针对各个通道提供静态方法open（）
* Files工具类的newByteChannel
* 四、通道之间的数据传输
* transferFrom（）
* transferTo（）
* 五、分散（Scatter）与聚集（Gather）
* 分散读取：将通道中的数据分散到多个缓冲区中
* 聚集写入：将多个缓冲区中数据聚集到通道中
* 六、字符集：Charset
* 编码：字符串-》字节数组
* 解码：字节数组-》字符串
* */
public class TestChannel {

    //利用通道完成文件的复制
    @Test
    public void test() throws Exception {    //非直接缓冲区
        LocalDateTime start = LocalDateTime.now();
       FileInputStream inputStream = new FileInputStream(new File("F:\\JavaIDEA\\NiuKe\\src\\main\\resources\\static\\1.jpg"));
       FileOutputStream outputStream = new FileOutputStream(new File("F:\\JavaIDEA\\NiuKe\\src\\main\\resources\\static\\2.jpg"));

       FileChannel inChannel = inputStream.getChannel();
       FileChannel outChannel = outputStream.getChannel();
       ByteBuffer buffer = ByteBuffer.allocate(1024);
       //从通道中读入缓冲区
       while (inChannel.read(buffer)!=-1) {
            //切换模式
           buffer.flip();
           //将缓冲区中的数据写入到通道
           outChannel.write(buffer);
           buffer.clear();//清空缓冲区
        }
       LocalDateTime end  = LocalDateTime.now();
       Duration duration = Duration.between(start,end);
        System.out.println(duration.toMillis());
    }

    //使用直接缓冲区完成文件的复制（内存映射文件）
    @Test
    public void test1() throws Exception {
        LocalDateTime start = LocalDateTime.now();
        FileChannel inChannel = FileChannel.open(Paths.get("F:\\JavaIDEA\\NiuKe\\src\\main\\resources\\static\\1.jpg"), StandardOpenOption.READ);
        FileChannel outChannel = FileChannel.open(Paths.get("F:\\JavaIDEA\\NiuKe\\src\\main\\resources\\static\\3.jpg"),StandardOpenOption.READ,StandardOpenOption.WRITE,StandardOpenOption.CREATE);

        //内存映射文件
        MappedByteBuffer inMapper = inChannel.map(FileChannel.MapMode.READ_ONLY,0,inChannel.size());
        MappedByteBuffer outMapper = outChannel.map(FileChannel.MapMode.READ_WRITE,0,inChannel.size());

        //直接对缓冲区进行数据的读写操作
        byte[] buf = new byte[inMapper.limit()];
        inMapper.get(buf);
        outMapper.put(buf);
        inChannel.close();
        outChannel.close();
        LocalDateTime end = LocalDateTime.now();
        Duration duration = Duration.between(start, end);
        System.out.println(duration.toMillis());
    }

    //通道之间的数据传输
    @Test
    public void test2() throws IOException {
        FileChannel inChannel = null;
        FileChannel outChannel = null;
        try {
            inChannel = FileChannel.open(Paths.get("F:\\JavaIDEA\\NiuKe\\src\\main\\resources\\static\\1.jpg"), StandardOpenOption.READ);
            outChannel = FileChannel.open(Paths.get("F:\\JavaIDEA\\NiuKe\\src\\main\\resources\\static\\4.jpg"),StandardOpenOption.READ,StandardOpenOption.WRITE,StandardOpenOption.CREATE);

            inChannel.transferTo(0,inChannel.size(),outChannel);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                inChannel.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            outChannel.close();
        }

    }

    @Test
    public void test3() throws CharacterCodingException {
        Charset cs1 = Charset.forName("GBK");
        //获取编码器
        CharsetEncoder ce = cs1.newEncoder();
        //获取解码器
        CharsetDecoder cd = cs1.newDecoder();

        CharBuffer cbuf = CharBuffer.allocate(1024);
        cbuf.put("我是李晓东");
        cbuf.flip();
        //编码
        ByteBuffer bbuf = ce.encode(cbuf);
        for(int i=0;i<10;i++){
            System.out.println(bbuf.get());
        }
        bbuf.flip();
        CharBuffer buf = cd.decode(bbuf);
        for(int i=0;i<5;i++) {
            System.out.print(buf.get());
        }
    }

}