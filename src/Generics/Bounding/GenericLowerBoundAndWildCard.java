package Generics.Bounding;
import java.util.ArrayList;
import java.util.List;
public class GenericLowerBoundAndWildCard {
    public static void main(String[] args) {
        List<Object>ol=new ArrayList<>();
        addElements(ol);
        List<Number>nl=new ArrayList<>();
        addElements(nl);
        // List<Double>dl=new ArrayList<>();
        // addElements(dl);
        System.out.println();
        printElements(new ArrayList<String>());
        System.out.println();
        // List<String>strList=new ArrayList<>();
        // printObj(strList);
        List<Object>objectList=new ArrayList<>();
        printObj(objectList);
    }
    public static void addElements(List<? super Integer> list){
        for (int i=1;i<10;i++){
            list.add(i);
        }
    }
    public static void printElements(List<?> listOfUnknown){
        // listOfUnknown.add("java");
        listOfUnknown.add(null);
        for (Object object:listOfUnknown){
            System.out.println(object);
        }
    }
    public static void printObj(List<Object>listOfObject){
        listOfObject.add("java");
        for (Object object:listOfObject){
            System.out.println(object);
        }
    }
}
