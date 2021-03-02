package com.krisyu.netDemo.socketDemo.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author: Kris
 * @Date: 2021/1/14 - 01 - 14 - 16:15
 * @Description: com.krisyu.netDemo.socketDemo
 * @version: 1.0
 */
public class Server {
    public static void main(String[] args) {
        ServerSocket server;
        try {
            server = new ServerSocket(10086);
            // 侦听要连接到此套接字，并接受它
            Socket socketServer = server.accept();
           // 读数据
            InputStream inputStream = socketServer.getInputStream();
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            String read = dataInputStream.readUTF();
            System.out.println("Server --> " + read);

            // 写数据
            OutputStream outputStream = socketServer.getOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
            dataOutputStream.write("Server has received successful".getBytes());

            // 关闭流
            dataOutputStream.close();
            outputStream.close();
            dataInputStream.close();
            inputStream.close();
            socketServer.close();
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
