package Thread.ThreadCreation03;

public class ThreadCreation3 {

    public static void main(String[] args) {
        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
                Thread.currentThread().setName("Ali");
                String name=Thread.currentThread().getName();
                for (int i=0;i<100;i++){
                    System.out.println(name+" --> "+i);
                }
            }
        });
        System.out.println("thread1 bitti");

        Thread thread2=new Thread(new Runnable() {
            @Override
            public void run() {
                Thread.currentThread().setName("Fatma");
                String name=Thread.currentThread().getName();
                for (int i=0;i<100;i++){
                    System.out.println(name+" --> "+i);
                }
            }
        });
        System.out.println("thread2 bitti");

        thread1.start();
        thread2.start();


    }


}
