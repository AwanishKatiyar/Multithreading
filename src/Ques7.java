import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
public class Ques7 {
    public static void main(String[] args) throws InterruptedException {
        List<Callable<String>> runnableList = new ArrayList<>();

        runnableList.add(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "thread 1";
            }
        });
        runnableList.add(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "thread 2";
            }
        });
        runnableList.add(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "thread 3";
            }
        });
        runnableList.add(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "thread 4";
            }
        });
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        List<Future<String>> futureList = executorService.invokeAll(runnableList);
        futureList.forEach((e) -> {
            if (e.isDone()) {
                try {
                    System.out.println(e.get());
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                } catch (ExecutionException e1) {
                    e1.printStackTrace();
                }
                finally {
                    executorService.shutdown();
                }
            }
        });
    }
}
