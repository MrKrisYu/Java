package com.krisyu.threadDemo.threadLocalDemo;

/**
 * @Author: Kris
 * @Date: 2021/1/12 - 01 - 12 - 17:15
 * @Description: com.krisyu.threadDemo.threadLocalDemo
 * @version: 1.0
 */
public class InheritableThreadLocalTest {
    public static void main(String[] args) throws InterruptedException {
//        ExecutorService threadPool = Executors.newFixedThreadPool(2);
        InheritableThreadLocal<String> inheritTL = new InheritableThreadLocal<String>(){
            @Override
            protected String childValue(String parentValue){
                if(parentValue.equals("我在main线程设置的值"))
                    return "childValueChangeSuccess";
                return null;
            }
        };
//        ThreadLocal<String> parentTL = new ThreadLocal<>();
        while(true){
            String curThreadName = Thread.currentThread().getName();
            System.out.println(curThreadName + " --> is running");
            inheritTL.set("我在main线程设置的值");
//            parentTL.set("我是父线程的独占值");
            System.out.println(curThreadName+ "--> inheritableThreadLocal的值 = "
                    + inheritTL.get());
//            System.out.println(curThreadName+ "--> parentThreadLocal的值 = "
//                    + parentTL.get());
            Thread.sleep(1000);

            new Thread(()->{
                String curThreadName1 = Thread.currentThread().getName();
                System.out.println(curThreadName1 + " --> is running");
                System.out.println(curThreadName1+ "--> inheritableThreadLocal的值 = "
                        + inheritTL.get());
//                System.out.println(curThreadName1 + " --> 开始改变值");
//                inheritTL.set("我在子线程里面变了");
//                System.out.println(curThreadName+ "--> inheritableThreadLocal的值 = "
//                        + inheritTL.get());
                System.out.println(curThreadName1 + " --> is over");
            }).start();
        }
    }
}
