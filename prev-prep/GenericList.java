public class GenericList<T>{

    //private because doesn't want users to modify it outside the class
    private class Node {
        public T item;
        public Node prev, next;
        public Node(T i, Node n, Node p, boolean s){
            if (s == true){
                next = this;
                prev = this;
                return;
            }
            item = i;
            next = n;
            prev = p;
        }
    }

    //variables
    private int size;
    private Node sentinel;

    //constructor
    public GenericList(){
        size = 0;
        sentinel = new Node(null, null, null, true);
    }

    public void addFirst(T x){
        size += 1;
        sentinel.next = new Node(x, sentinel.next, sentinel, false);
    }

    public void addLast(T x){
        size += 1;
        sentinel.prev = new Node(x, sentinel, sentinel.prev, false);
    }

    public T getFirst(){
        if (size == 0){
            System.out.println("List is empty");
            return null;
        }
        return sentinel.next.item;
    }

    public T getLast(){
        if (size == 0){
            System.out.println("List is empty");
            return null;
        }
        return sentinel.prev.item;
    }

    public int size(){
        return size;
    }

    public static void main(String[] args){
        GenericList<String> x = new GenericList<>();
        System.out.println(x.size());
        x.addFirst("hi");
        x.addLast("hello");
        x.addLast("world");
        System.out.println(x.getLast());
        System.out.println(x.getFirst());
    }
}
