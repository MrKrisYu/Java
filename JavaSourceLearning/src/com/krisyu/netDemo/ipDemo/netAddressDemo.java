package com.krisyu.netDemo.ipDemo;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @Author: Kris
 * @Date: 2021/1/14 - 01 - 14 - 15:47
 * @Description: com.krisyu.netDemo
 * @version: 1.0
 */
public class netAddressDemo {
    public static void main(String[] args) {
        try {
            InetAddress localHost = InetAddress.getLocalHost();
            String ipv4 = Inet4Address.getLocalHost().getHostAddress();
            System.out.println(localHost.getHostName());
            System.out.println(ipv4);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
