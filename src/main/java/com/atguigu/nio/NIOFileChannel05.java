package com.atguigu.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 从一个通道直接复制到另一个通道
 */
public class NIOFileChannel05 {
    public static void main(String[] args) throws IOException {

        final ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        byteBuffer.putInt(1);
        byteBuffer.putDouble(2.0);
        byteBuffer.putChar('c');
        byteBuffer.putShort((short) 1);

        byteBuffer.flip();

        System.out.println(byteBuffer.getInt());
        System.out.println(byteBuffer.getDouble());
        System.out.println(byteBuffer.getChar());
        System.out.println(byteBuffer.getShort());
    }
}
