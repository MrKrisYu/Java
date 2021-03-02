package com.krisyu.netDemo.socketDemo.client;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @Author: Kris
 * @Date: 2021/1/14 - 01 - 14 - 16:51
 * @Description: com.krisyu.netDemo.socketDemo.client
 * @version: 1.0
 */
public class PicCilent {
    public static void main(String[] args) throws Exception {
        // 获取  读取本地文件的输入流
        FileInputStream fileInputStream = new FileInputStream("读书逻辑.png");
        // 创建套接字
        Socket client = new Socket("localhost", 10086);
        // 获取套接字IO流
        OutputStream outputStream = client.getOutputStream();
        InputStream inputStream = client.getInputStream();

        // 传输图像
        int len = 0;
        byte[] picBuff = new byte[1024];
        while((len = fileInputStream.read(picBuff)) != -1){
            outputStream.write(picBuff);
        }
        // 显示关闭 套接字的输出流
        client.shutdownOutput();
        len = 0;
        byte[] feedBuff = new byte[1024];
        len = inputStream.read(feedBuff);
        System.out.println(new String(feedBuff,0,len));
        // 显示关闭 套接字的输入流
        client.shutdownInput();

        // 显示关闭其他I/O流
        inputStream.close();
        outputStream.close();
        fileInputStream.close();
        client.close();
    }
}
