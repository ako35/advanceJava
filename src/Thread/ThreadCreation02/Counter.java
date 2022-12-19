package Thread.ThreadCreation02;

public class Counter implements Runnable{

    private String name;

    public Counter(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(name+" basladi");
        for (char i='a'; i<='z'; i++){
            System.out.println(name+" --> "+i);
        }
        System.out.println(name+" bitti");
    }
}
