package com.atguigu.bio;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BIOServer {
    public static void main(String[] args) throws IOException {
        final ExecutorService executorService = Executors.newCachedThreadPool();

        final ServerSocket serverSocket = new ServerSocket(6666);
        System.out.println("服务器启动了");
        while(true){
            //持续监听
            System.out.println("等待连接....");
            final Socket socket = serverSocket.accept();
            System.out.println("连接到一个客户端");
            executorService.execute(new Runnable() {
                public void run() {
                    handler(socket);
                }
            });
        }
    }

    private static void handler(Socket socket) {
        try {
            printThreadInfo(Thread.currentThread());
            final InputStream inputStream = socket.getInputStream();
            byte[] bytes = new byte[1024];
            while(true){
                printThreadInfo(Thread.currentThread());
                int read = inputStream.read(bytes);
                if(read != -1){
                    System.out.println("客户端发来的数据：" + new String(bytes,0, read));
                }else{
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            System.out.println("关闭socket连接");
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void printThreadInfo(Thread currentThread) {
        System.out.println("线程id: "+currentThread.getId() + ", 线程名称："+currentThread.getName());
    }
}
