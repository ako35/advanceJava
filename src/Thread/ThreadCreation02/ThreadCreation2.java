package Thread.ThreadCreation02;

public class ThreadCreation2 {

    public static void main(String[] args) {

        System.out.println("Yaris baslasin...");
        Counter counter=new Counter("Ali");
        Thread thread1=new Thread(counter);
        Counter counter1=new Counter("Fatma");
        Thread thread2=new Thread(counter1);

        thread1.start();
        thread2.start();

//        try {
//            Thread.sleep(100);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Yaris bitti...");

    }

}
