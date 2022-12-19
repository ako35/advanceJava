package Thread.ThreadCreation01;

public class Sayac extends Thread{

    private String name;

    public Sayac(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(name+" basladi.");
        for (int i=1; i<101; i++){
            System.out.println(name+" --> "+i);
        }
        System.out.println(name+" bitti.");
    }
}
