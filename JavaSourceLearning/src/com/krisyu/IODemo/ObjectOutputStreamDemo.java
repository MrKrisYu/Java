package com.krisyu.IODemo;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * @Author: Kris
 * @Date: 2021/1/6 - 01 - 06 - 22:16
 * @Description: com.krisyu.IODemo
 * @version: 1.0
 */
public class ObjectOutputStreamDemo {
    public static void main(String[] args) {
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;

        try {
            fileOutputStream = new FileOutputStream("testFile.txt");
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeInt(18);
            objectOutputStream.writeObject(new Person(18,"余建前"));
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                if (objectOutputStream != null) {
                    objectOutputStream.close();
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
