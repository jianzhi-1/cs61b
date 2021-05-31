import java.util.Comparator;

public class ComparatorClass implements Comparable<ComparatorClass>{
    
    private String name;
    private int size;
    
    private static class GenericComparator implements Comparator<ComparatorClass>{
        public int compare(ComparatorClass a, ComparatorClass b){
            return a.name.compareTo(b.name);
        }
    }
    
    public static Comparator<ComparatorClass> getGenericComparator(){
        return new GenericComparator();
    }

    //Usage
    //import java.util.Comparator;
    //Comparator<ComparatorClass> c = ComparatorClass.getGenericComparator();
}
