import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
public class Ques15 {
    Lock lock = new ReentrantLock(true);
    Condition condition = lock.newCondition();
    public void employee1() {
        try {
            lock.lock();
            System.out.println("employee 1 Started");
            condition.await();
            System.out.println("employee 1 Finished");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }
    public void employee2() {
        try{
            lock.lock();
            System.out.println("employee 2 Started");
            System.out.println("employee 2 Finished");
            condition.signal();
        }finally {
            lock.unlock();
        }
    }
    public static void main(String[] args) throws InterruptedException {
        Ques15 ques15 = new Ques15();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                ques15.employee1();
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                ques15.employee2();
            }
        });
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
    }
}
