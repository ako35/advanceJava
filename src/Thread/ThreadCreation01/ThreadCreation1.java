package Thread.ThreadCreation01;

public class ThreadCreation1 {

    public static void main(String[] args) {

        Sayac thread1=new Sayac("Ali");
        thread1.start();
        Sayac thread2=new Sayac("Fatma");
        thread2.start();

    }

}
