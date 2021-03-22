package com.atguigu.nio;

import java.nio.IntBuffer;

public class BasicBuffer {
    public static void main(String[] args) {
        IntBuffer intBuffer = IntBuffer.allocate(5);
        //放入数据
        for(int i = 0; i < 5; i++)
            intBuffer.put(i*2);
        //取出数据
        intBuffer.flip();
        while (intBuffer.hasRemaining()){
            System.out.println(intBuffer.get());
        }
    }
}
