import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
public class Ques8 {
    public static void main(String[] args)
    {
        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        try
        {
            executorService.scheduleWithFixedDelay(new Runnable()
            {
                @Override
                public void run()
                {
                    try
                    {
                        Thread.sleep(2000L);
                        System.out.println("Schedule at fixed delay");
                    } catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                }
            }, 0, 1, TimeUnit.SECONDS);
            executorService.scheduleAtFixedRate(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1000L);
                        System.out.println("Scheduled at fixed rate");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }, 0, 1, TimeUnit.SECONDS);

            executorService.schedule(new Runnable() {
                @Override
                public void run() {
                    System.out.println("Task executed after 1 second");
                }
            }, 3, TimeUnit.SECONDS);
        } finally {
            executorService.shutdown();
        }

        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        try {
            scheduledExecutorService.scheduleWithFixedDelay(new Runnable() {
                @Override
                public void run() {
                    System.out.println("Thread 1 executed ");
                }
            }, 0, 1, TimeUnit.SECONDS);
            scheduledExecutorService.scheduleWithFixedDelay(new Runnable() {
                @Override
                public void run() {
                    System.out.println("Thread 2 executed");
                }
            }, 0, 1, TimeUnit.SECONDS);
            scheduledExecutorService.scheduleWithFixedDelay(new Runnable() {
                @Override
                public void run() {
                    System.out.println("Thread 3 executed");
                }
            }, 0, 1, TimeUnit.SECONDS);
        } finally {
            scheduledExecutorService.shutdown();
        }
    }
}
