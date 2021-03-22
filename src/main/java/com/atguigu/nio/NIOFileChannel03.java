package com.atguigu.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NIOFileChannel03 {
    public static void main(String[] args) throws IOException {

        //创建文件输入输出流
        final FileInputStream fileInputStream = new FileInputStream("data/1.txt");
        final FileOutputStream fileOutputStream = new FileOutputStream("data/2.txt");
        //创建通道
        final FileChannel fileChannel1 = fileInputStream.getChannel();
        final FileChannel fileChannel2 = fileOutputStream.getChannel();
        //创建缓存区buffer
        final ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        //通道1写入缓冲区,再写入通道2
        while(true){
            byteBuffer.clear();
            int read = fileChannel1.read(byteBuffer);
            if(read == -1){
                break;
            }
            byteBuffer.flip();
            fileChannel2.write(byteBuffer);
        }
        //关闭通道
        fileInputStream.close();
        fileOutputStream.close();
    }
}
