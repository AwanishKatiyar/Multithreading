public class Ques14 {
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
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("employee 2 Done");
        }
    }
    public void employee3(){
        synchronized (this) {
            System.out.println("employee 3 Started");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("employee 3 Done");
        }
    }
    public void employee4(){
        synchronized (this) {
            System.out.println("employee 4 Started");
            System.out.println("employee 4 Done");
            notifyAll();
        }
    }
    public static void main(String[] args) {
        Ques14 ques14 = new Ques14();
        new Thread(new Runnable() {
            @Override
            public void run() {
                ques14.employee1();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                ques14.employee2();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                ques14.employee3();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                ques14.employee4();
            }
        }).start();
    }
}
