public class BSTDriver {
    public static void main(String[] args){
        BSTSet<Integer> s = new BSTSet<>();
        s.insert(5);
        s.insert(55);
        System.out.println("Size of set:");
        System.out.println(s.size());
        System.out.println(s.find(45));
        System.out.println("Hello World!");
    }
}
