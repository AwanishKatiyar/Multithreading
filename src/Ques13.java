public class Ques13 {
    public void employee1(){
        synchronized (this) {
            System.out.println("employee 1 Started");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("employee 1 Done");
        }
    }
    public void employee2(){
        synchronized (this) {
            System.out.println("employee 2 Started");
            System.out.println("employee 2 Done");
            notify();
        }
    }
    public static void main(String[] args) {
        Ques13 ques13 = new Ques13();
        new Thread(new Runnable() {
            @Override
            public void run() {
                ques13.employee1();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                ques13.employee2();
            }
        }).start();
    }
}
