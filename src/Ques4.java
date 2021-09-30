import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class Ques4 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        try {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("Thread 1");
                }
            });
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("Thread 2");
                }
            });
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(3000L);
                        System.out.println("Thread 3");
                    } catch (InterruptedException e) {
                        System.out.println("sleep interrupted due to shutdown now");
                    }

                }
            });
        } finally {
            // executorService.shutdownNow();
            executorService.shutdown();
        }
    }
}
