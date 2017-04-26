package org.springboot.sample.servlet;

/**
 * Created by huangsiqian on 2017/4/26 0026.
 */
public class ThreadDemo1 {
    public static void main(String[] args) {
// TODO Auto-generated method stub
//创建了一个窗口
        TicketWindow tw1 = new TicketWindow();

//使用三个线程同时启动
        Thread t1 = new Thread(tw1);
        Thread t2 = new Thread(tw1);
        Thread t3 = new Thread(tw1);

        t1.start();
        t2.start();
        t3.start();
    }

}

//售票窗口
class TicketWindow implements Runnable {
    //一共两千张票
    private int nums = 2000;
    @Override
    public void run() {
        while (true) {
//出票速度是1秒一张
//认为if else 要保证原子性(同步代码块)
//先判断是否还有票
            synchronized (this) {
                if (nums > 0) {
                    System.out.println
                            (Thread.currentThread().getName() + "在售出第" + nums + "票");
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    nums--;
                } else {
                    break;
                }
            }
        }
    }
}
