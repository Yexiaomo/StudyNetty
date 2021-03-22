package com.atguigu.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 从一个通道直接复制到另一个通道
 */
public class NIOFileChannel04 {
    public static void main(String[] args) throws IOException {

        //创建文件输入输出流
        final FileInputStream fileInputStream = new FileInputStream("data/1.png");
        final FileOutputStream fileOutputStream = new FileOutputStream("data/2.png");
        //创建通道
        final FileChannel fileChannel1 = fileInputStream.getChannel();
        final FileChannel fileChannel2 = fileOutputStream.getChannel();
        //复制
        fileChannel2.transferFrom(fileChannel1, 0,fileChannel1.size());
        //关闭通道
        fileInputStream.close();
        fileOutputStream.close();
    }
}
