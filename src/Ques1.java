public class Ques1 {
    public static void main(String[] args) {
        System.out.println("Thread name::" + Thread.currentThread().getName());
        new MultiThreadingUsingThreadCLass().start();
        new MultiThreadingUsingThreadCLass().start();
        Thread thread2 = new MultiThreadingUsingThreadCLass();
        thread2.start();
        new Thread(new MultiThreadingUsingRunnableInterface()).start();
        Thread thread4 = new Thread(new MultiThreadingUsingRunnableInterface());
        thread4.start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread name::" + Thread.currentThread().getName());
            }
        }).start();
        new Thread(()->{System.out.println("Thread name::" + Thread.currentThread().getName());}).start();
    }
}

class MultiThreadingUsingThreadCLass extends Thread {
    @Override
    public void run() {
        System.out.println("Thread name::" + Thread.currentThread().getName());
    }
}

class MultiThreadingUsingRunnableInterface implements Runnable {
    @Override
    public void run() {
        System.out.println("Thread name::" + Thread.currentThread().getName());
    }
}
