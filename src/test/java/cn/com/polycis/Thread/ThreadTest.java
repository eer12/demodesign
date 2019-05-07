package cn.com.polycis.Thread;


public class ThreadTest {

    public static void main(String[] args) {
        MyThread1 T1 = new MyThread1("A");
     //   MyThread2 T2 = new MyThread2("B");
        MyThread1 T2 = new MyThread1("B");
        //T1 与T2 是两个线程,T1启动后,T2就启动,不是T1线程启动处理数据结束后,T2才执行
        /*T1.start();
        T2.start();*/
        new Thread(T1).start();
        new Thread(T2).start();
    }

}

class MyThread1 extends Thread {
    private String name;

    public MyThread1(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(name + ":" + i);
            try {
                sleep(500); //休眠1秒，避免太快导致看不到同时执行
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}

class MyThread2 extends Thread {
    private String name;

    public MyThread2(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(name + ":" + i);
            try {
                sleep(1500); //休眠1秒，避免太快导致看不到同时执行
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}


