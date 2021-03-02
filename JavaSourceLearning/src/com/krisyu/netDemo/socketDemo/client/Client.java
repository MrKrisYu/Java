package com.krisyu.netDemo.socketDemo.client;

import java.io.*;
import java.net.Socket;

/**
 * @Author: Kris
 * @Date: 2021/1/14 - 01 - 14 - 16:09
 * @Description: com.krisyu.netDemo.socketDemo
 * @version: 1.0
 */
public class Client {
    public static void main(String[] args) {
        Socket client;
        try {
            // 获取套接字对象——指定主机名和端口号
            client = new Socket("localHost", 10086);
            // 获取输出流
            OutputStream outputStream = client.getOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
            dataOutputStream.writeUTF("Test Socket @KrisYu");

            // 获取输入流
            InputStream inputStream = client.getInputStream();
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            byte[] databuff = new byte[1024];
            int len = dataInputStream.read(databuff);
            System.out.println("Client Read -->" + new String(databuff, 0, len));

            // 关闭流
            dataInputStream.close();
            inputStream.close();
            dataOutputStream.close();
            outputStream.close();
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
