// 10.Use Synchronize method to enable synchronization between multiple threads trying to access method at same time.
// 11.Use Synchronize block to enable synchronization between multiple threads trying to access method at same time.
// 12.Use Atomic Classes instead of Synchronize method and blocks.

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
public class Ques10_11_12 {
    int count;
    int countsync1;
    int countsync2;
    //12.use atomic classes
    AtomicInteger countsync3=new AtomicInteger();
    Lock lock = new ReentrantLock(true);
    int countsync4;

    public void incrementCount() {
        count++;
        //11.synchroised block
        synchronized (this){countsync2++;}
        countsync3.incrementAndGet();
        lock.lock();
        countsync4++;
        lock.unlock();
    }
    //10.synchronised method
    synchronized public void incrementCountsync1(){
        countsync1++;
    }

    public void employee1() {
        for (int i=1;i<=2000;i++){
            incrementCount();
            incrementCountsync1();
        }
    }

    public void employee2() {
        for (int i=1;i<=2000;i++){
            incrementCount();
            incrementCountsync1();
        }
    }

    public static void main(String[] args) throws InterruptedException {

        Ques10_11_12 ques10_11_12 = new Ques10_11_12();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                ques10_11_12.employee1();
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                ques10_11_12.employee2();
            }
        });
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(ques10_11_12.count);
        System.out.println(ques10_11_12.countsync1);
        System.out.println(ques10_11_12.countsync2);
        System.out.println(ques10_11_12.countsync3);
        System.out.println(ques10_11_12.countsync4);
    }
}
