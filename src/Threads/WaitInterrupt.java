package Threads;
public class WaitInterrupt {
    static public int balance=0;
    public static void main(String[] args) {
        WaitInterrupt obj=new WaitInterrupt();
        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
                obj.withDraw(800);
            }
        });
        thread1.setName("Withdraw Thread");
        thread1.start();
        Thread thread2=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                obj.deposit(2000);
                thread1.interrupt();
            }
        });
        thread2.setName("Deposit Thread");
        thread2.start();
    }
    public void withDraw(int amount){
        synchronized (this){
            if (balance<=0 || balance<amount){
                System.out.println("bekleme");
                try {
                    wait();
                } catch (InterruptedException e) {
                    balance-=amount;
                    System.out.println("basarili");
                }
            }

        }
    }
    public void deposit(int amount){
        balance+=amount;
        System.out.println("basarili");
    }
}
