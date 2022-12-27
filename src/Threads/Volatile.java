package Threads;
public class Volatile {
    volatile public static int flag=0;
    public static void main(String[] args) {
        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    if(flag==0){
                        System.out.println("Thread1 calisiyor...");
                    } else break;
                }
            }
        });
        thread1.start();
        Thread thread2=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                flag=1;
                System.out.println("flag degeri 1 olarak degistirildi");
            }
        });
        thread2.start();
    }
}
