package com.krisyu.netDemo.socketDemo.server;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author: Kris
 * @Date: 2021/1/14 - 01 - 14 - 16:58
 * @Description: com.krisyu.netDemo.socketDemo.server
 * @version: 1.0
 */
public class picServer {
    public static void main(String[] args) throws Exception {
        // 创建 写入本地的输出流
        FileOutputStream fileOutputStream = new FileOutputStream("Logistic of Reading.png");
        // 创建服务器套接字
        ServerSocket serverSocket = new ServerSocket(10086);
        Socket server = serverSocket.accept();

        // 创建用于网络传输的IO流
        InputStream inputStream = server.getInputStream();
        OutputStream outputStream = server.getOutputStream();
        // 接收图像
        int len = 0; byte[] readBuff = new byte[1024];
        while((len = inputStream.read(readBuff)) != -1){
                fileOutputStream.write(readBuff);
        }
        // 显示关闭套接字的输入流
        server.shutdownInput();

        File picFile = new File("Logistic of Reading.png");
        String feedBack = "Pic transfer State: " + (picFile.exists()?"Successful":"Failed");
        System.out.println("Server is ready to write:" + feedBack);
        outputStream.write(feedBack.getBytes());
        // 显示关闭套接字输出流
        server.shutdownOutput();
        // 关闭其他流
        outputStream.close();
        inputStream.close();
        server.close();
        serverSocket.close();
        fileOutputStream.close();
    }
}
