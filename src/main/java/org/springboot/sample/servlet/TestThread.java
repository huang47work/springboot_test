package org.springboot.sample.servlet;

/**
 * Created by huangsiqian on 2017/4/26 0026.
 */
public class TestThread {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        new TestThread1().start();
        new TestThread1().start();
        new TestThread1().start();
        new TestThread1().start();
    }
}

class TestThread1 extends Thread {
    private int tickets = 20;

    public void run() {
        while (true) {
            if (tickets > 0)
                System.out.println(Thread.currentThread().getName() + "出售票" + tickets--);
            else
                break;
        }
    }
}
