package Threads.WaitNotifypackage;
public class ShopWaitNotify {
    public static int stock = 0;
    public static void main(String[] args) {
        ShopWaitNotify shopWaitNotify=new ShopWaitNotify();
        Thread consumerThread=new Thread(new Runnable() {
            @Override
            public void run() {
                shopWaitNotify.consumeProduct(3);
            }
        });
        Thread producerThread=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                shopWaitNotify.produceProduct(5);
            }
        });
        consumerThread.setName("Tuketici");
        producerThread.setName("Uretici");
        consumerThread.start();
        producerThread.start();
    }
    public synchronized void consumeProduct(int amount) {
        if (amount > stock) {
            System.out.println(Thread.currentThread().getName() + " urun satin almak istiyor...");
            System.out.println("Yeterli urun yok");
            System.out.println("Guncel stok: " + stock);
            System.out.println("Tuketici urun girisi yapilmasini bekliyor...");
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        if (amount <= stock) {
            System.out.println(Thread.currentThread().getName() + " urun satin almak istiyor...");
            System.out.println(amount + " adet urun satildi");
            stock -= amount;
            System.out.println("Guncel stok: " + stock);
        } else {
            System.out.println(Thread.currentThread().getName() + " urun satin almak istiyor...");
            System.out.println(amount + " adet urun yok" + stock + " adet urun alabilirsiniz...");
        }
    }
    public synchronized void produceProduct(int amount) {
        System.out.println(Thread.currentThread().getName() + " urun eklemek istiyor...");
        System.out.println(amount + " adet urun eklendi...");
        stock += amount;
        System.out.println("Guncel stok: " + stock);
        notify();
    }
}
