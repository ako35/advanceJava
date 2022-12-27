package Threads;
public class MultiThreading01 {
    public static void main(String[] args) {
        long startTime=System.currentTimeMillis();
        CounterWithoutMultiThread counter1=new CounterWithoutMultiThread(1);
        CounterWithoutMultiThread counter2=new CounterWithoutMultiThread(2);
        counter1.countMe();
        System.out.println();
        counter2.countMe();
        long endTime=System.currentTimeMillis();
        System.out.println("WithoutMultiThread ile gecen sure: "+(endTime-startTime));
        System.out.println();
        long startTime2=System.currentTimeMillis();
        CounterWithMultiThread counter3=new CounterWithMultiThread(1);
        CounterWithMultiThread counter4=new CounterWithMultiThread(2);
        counter3.start();
        System.out.println();
        counter4.start();
        try {
            counter3.join();
            counter4.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        long endTime2=System.currentTimeMillis();
        System.out.println("WithMultiThread ile gecen sure: "+(endTime2-startTime2));
    }
}
class CounterWithoutMultiThread{
    private int threadNum;

    public CounterWithoutMultiThread(int threadNum) {
        this.threadNum = threadNum;
    }
    public void countMe(){
        for (int i=1;i<=10;i++){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("i "+i+" Thread number: "+threadNum);
        }
    }
}
class CounterWithMultiThread extends Thread{
    private int threadNum;

    public CounterWithMultiThread(int threadNum) {
        this.threadNum = threadNum;
    }

    @Override
    public void run() {
        countMe();
    }
    public  void countMe(){
        for (int i=1;i<=10;i++){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("i "+i+" Thread number: "+threadNum);
        }
    }
}
