public class BTreeDriver {
    public static void main(String[] args){
        BTree<Integer> s = new BTree<>(3);
        for (int i = 5; i < 10000; i+=5){
            s.insert(i);
        }
        System.out.println(s.find(7506));
        System.out.println("HELLO");
    }
}
