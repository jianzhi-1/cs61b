import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.Iterator;

public class Template {

    //variables
    private int size;

    //constructor
    public Template(){
        size = 0;
    }

    //attributes
    public void addFirst(int x){
        size += 1;
    }

    public int size(){
        return size;
    }

    public static void main(String[] args){
        System.out.println("Hello World!");
    }

}
