package com.atguigu.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NIOFileChannel02 {
    public static void main(String[] args) throws IOException {

        //创建本地输入流
        final File file = new File("E:\\keshan\\testfilechannel.txt");
        final FileInputStream fileInputStream = new FileInputStream(file);
        //创建通道
        final FileChannel fileChannel = fileInputStream.getChannel();
        //创建缓存区buffer
        final ByteBuffer byteBuffer = ByteBuffer.allocate((int) file.length());
        //通道写入缓冲区
        fileChannel.read(byteBuffer);
        //打印数据
        String str = new String(byteBuffer.array());
        System.out.println(str);
        //关闭通道
        fileInputStream.close();
    }
}
