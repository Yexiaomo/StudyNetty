package com.atguigu.nio;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NIOFileChannel01 {
    public static void main(String[] args) throws IOException {
        String str = "hello,劈里啪啦";
        //创建本地输出流
        final FileOutputStream fileOutputStream = new FileOutputStream("E:\\keshan\\testfilechannel.txt");
        //创建通道
        final FileChannel fileChannel = fileOutputStream.getChannel();
        //创建缓存区buffer
        final ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        //数据放入缓存区
        byteBuffer.put(str.getBytes());
        //缓冲区写入通道
        byteBuffer.flip();
        fileChannel.write(byteBuffer);

        //关闭通道
        fileOutputStream.close();
    }
}
