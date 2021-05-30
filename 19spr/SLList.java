public class SLList {

    //private because doesn't want users to modify it outside the class
    //static means never requires SLList variables/functions
    private static class IntNode {
        public int item;
        public IntNode next;
        public IntNode(int i, IntNode n){
            item = i;
            next = n;
        }
    }

    //sentinel node to maintain structure
    private IntNode sentinel;
    private int size;

    public SLList(){
        size = 0;
        sentinel = new IntNode(-1, null);
    }

    public static void main(String[] args){
        SLList L = new SLList();
        L.addLast(20);
        L.addFirst(15);
        L.addFirst(5);
        
        System.out.println(L.size());
    }

    //adds x to the front of the list
    public void addFirst(int x){
        size += 1;
        sentinel.next = new IntNode(x, sentinel.next);
    }

    //add x to the back of list O(N)
    public void addLast(int x){
        size += 1;

        IntNode p = sentinel;

        while (p.next != null){
            p = p.next;
        }
        p.next = new IntNode(x, null);
    }

    //returns the first item in the list
    public int getFirst(){
        return sentinel.next.item;
    }

    public int size(){
        return size;
    }
}
