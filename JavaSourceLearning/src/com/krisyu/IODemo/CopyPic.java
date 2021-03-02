package com.krisyu.IODemo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Author: Kris
 * @Date: 2021/1/6 - 01 - 06 - 20:45
 * @Description: com.krisyu.IODemo
 * @version: 1.0
 *
 *  纯文本数据，用字符流和字节流都可以；但是视频和图片只能用字节流
 */
public class CopyPic {
    public static void main(String[] args) {
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;

        try {
            fileInputStream = new FileInputStream("读书逻辑.png");
            fileOutputStream = new FileOutputStream("学习逻辑副本.png");
            int len = 0;
            byte[] bytes = new byte[1024];
            while((len = fileInputStream.read(bytes))!=-1){
                fileOutputStream.write(bytes);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
