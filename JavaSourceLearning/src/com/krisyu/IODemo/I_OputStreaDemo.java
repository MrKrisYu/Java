package com.krisyu.IODemo;

import java.io.*;

/**
 * @Author: Kris
 * @Date: 2021/1/6 - 01 - 06 - 19:09
 * @Description: com.krisyu.IODemo
 * @version: 1.0
 */
public class I_OputStreaDemo {
    public static byte[] Input(){
        InputStream inputStream = null;
        byte[] data = new byte[1024];
        int len;
        try {
            inputStream = new FileInputStream("testFile.txt");
            len = inputStream.read(data);
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                if(inputStream != null)
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return data;
    }

    public static void Write(byte[] data){
        OutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream("src/testFile.txt");
            outputStream.write(data);
        }catch (IOException e){
            e.printStackTrace();
        }finally{
            try {
                if(outputStream != null){
                    outputStream.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }



    public static void main(String[] args) {
        byte[] dataFromTxt = Input();
        StringBuilder readyToWrite = new StringBuilder();
        for(byte b: dataFromTxt){
            if(b!=0)
                readyToWrite.append((char)b);
        }
        readyToWrite.trimToSize();
        Write(readyToWrite.toString().getBytes());
    }

}
