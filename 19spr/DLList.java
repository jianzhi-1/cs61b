public class DLList {

    //private because doesn't want users to modify it outside the class
    //static means never requires SLList variables/functions
    private static class IntNode {
        public int item;
        public IntNode prev, next;
        public IntNode(int i, IntNode n, IntNode p, boolean s){
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
    private IntNode sentinel;

    //constructor
    public DLList(){
        size = 0;
        sentinel = new IntNode(-1, null, null, true);
    }

    public void addFirst(int x){
        size += 1;
        sentinel.next = new IntNode(x, sentinel.next, sentinel, false);
    }

    public void addLast(int x){
        size += 1;
        sentinel.prev = new IntNode(x, sentinel, sentinel.prev, false);
    }

    public int getFirst(){
        if (size == 0){
            System.out.println("List is empty");
            return -1;
        }
        return sentinel.next.item;
    }

    public int getLast(){
        if (size == 0){
            System.out.println("List is empty");
            return -1;
        }
        return sentinel.prev.item;
    }

    public int size(){
        return size;
    }

    public static void main(String[] args){
        DLList x = new DLList();
        System.out.println(x.size());
        x.addFirst(22);
        x.addLast(10);
        x.addLast(11);
        System.out.println(x.getLast());
    }
}
