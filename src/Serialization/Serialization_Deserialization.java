package Serialization;
import java.io.*;
public class Serialization_Deserialization {
    public static void main(String[] args) {
        // writeObjects();
        readObjects();
    }
    private static void writeObjects(){
        System.out.println("User objeleri olusturuluyor...");
        User user1=new User(1L,"yunus","123418234");
        User user2=new User(2L,"yusuf","456789123");
        User user3=new User(3L,"betul","789123564");
        try {
            FileOutputStream fos=new FileOutputStream("user.dat");
            try {
                ObjectOutputStream oos=new ObjectOutputStream(fos);
                oos.writeObject(user1);
                oos.writeObject(user2);
                oos.writeObject(user3);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    private static void readObjects(){
        try {
            FileInputStream fis=new FileInputStream("user.dat");
            try {
                ObjectInputStream ois=new ObjectInputStream(fis);
                try {
                    User user1= (User) ois.readObject();
                    User user2= (User) ois.readObject();
                    User user3= (User) ois.readObject();
                    System.out.println(user1);
                    System.out.println(user2);
                    System.out.println(user3);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
class User implements Serializable{
    private Long id;
    private String name;
    private String tcKimlikNo;
    public User(Long id, String name, String tcKimlikNo) {
        this.id = id;
        this.name = name;
        this.tcKimlikNo = tcKimlikNo;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getTcKimlikNo() {
        return tcKimlikNo;
    }
    public void setTcKimlikNo(String tcKimlikNo) {
        this.tcKimlikNo = tcKimlikNo;
    }
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tcKimlikNo='" + tcKimlikNo + '\'' +
                '}';
    }
}
