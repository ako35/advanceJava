package Generics;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class GenericType<T> {
    private T type;
    public T getType() {
        return type;
    }
    public void setType(T type) {
        this.type = type;
    }
    public static void main(String[] args) {
        // generic yapi kullanarak ayni classdan iki farkli data turunde obje olusturalim
        GenericType<String>obj1=new GenericType<>();
        // trick: diamond icine non primitive type kullanabiliriz.
        obj1.setType("Generic Types");
        GenericType<String>obj2=new GenericType<>();
        // obj2.setType(65);
        // not: cast probleminden nasil kurtulurum?
        GenericType<Integer>obj3=new GenericType<>();
        obj3.setType(65);
        int a= obj3.getType();
        System.out.println(a);
        //not: classcastexception probleminden nasil kurtulurum?
        List<String>list=new ArrayList<>();
        list.add("alper");
        list.add("halide");
        // list.add(22);
        Map<Integer,String>map=new HashMap<>();
        map.put(1,"generic");
        // map.put("generic",1);
    }
}
