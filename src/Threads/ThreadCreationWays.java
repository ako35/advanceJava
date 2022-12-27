package Threads;
public class ThreadCreationWays {
    public static void main(String[] args) {
        System.out.println("Current Thread : "+Thread.currentThread().getName());
        MyThread thread1=new MyThread();
        // thread1.run();
        thread1.start();
        MyRunnable runnable=new MyRunnable();
        Thread thread2=new Thread(runnable);
        thread2.start();
        Thread thread3=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Current Thread: "+ Thread.currentThread().getName());
                System.out.println("bu isimsiz sinif yoluyla olusturulan bir is parcacigidir.");
            }
        });
        thread3.setName("Thread3");
        thread3.start();
        Thread thread4=new Thread(()->{
            System.out.println("lambda ile yazildi...");
        });
        thread4.start();
        System.out.println("main thread i bitti.");
        Thread thread5=new Thread(()->{
            System.out.println("thread5 calisti.");
        });
        thread5.start();
    }
}
class MyThread extends Thread{
    @Override
    public void run() {
        System.out.println("MyThread thread i calisiyor...");
    }
}
class MyRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("Runnable Interface inden turetilen thread calisiyor...");
    }
}
