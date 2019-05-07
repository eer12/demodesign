package cn.com.polycis.Thread;

public class RunnableTest {

    public static void main(String[] args) {

        //测试Runnable
        MyThread3 t1 = new MyThread3();
        new Thread(t1).start();//同一个t1，如果在Thread中就不行，会报错
        new Thread(t1).start();
        new Thread(t1).start();

    }

}

class MyThread3 implements Runnable {
    private int ticket = 1000;

    @Override
    //记得要资源公共，要在run方法之前加上synchronized关键字，要不然会出现抢资源的情况
    public synchronized void run() {
        for (int i = 0; i < 1000; i++) {
            if (this.ticket > 0) {
                System.out.println("卖票：ticket" + this.ticket--);
            }
        }

    }

}







