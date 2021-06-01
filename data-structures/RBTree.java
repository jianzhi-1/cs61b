public class RBTree<T extends Comparable<T>> {

    private class Node<T extends Comparable<T>>{
        public T val;
        private Node<T> l;
        private Node<T> r;
        private boolean red; //whether the link to the parent in red
    
        private Node(){
            val = null;
            l = null;
            r = null;
            red = false;
        }

        private Node(T x, boolean edger){
            val = x;
            l = null;
            r = null;
            red = edger;
        }

        public boolean find(Node<T> node, T x){
            if (node == null) return false;
            if (node.val.equals(x)) return true;
            if (x.compareTo(node.val) < 0) return find(node.l, x);
            else return find(node.r, x);
        }
    

    }

    private Node<T> n;
    
    public RBTree(){
        n = null;
        System.out.println("DONE");
    }

    public void insert(T x){
        n = insert(n, x);
    }

    public boolean find(T x){
        return n.find(n, x);
    }

    private boolean isRed(Node<T> node){
        if (node == null) return false;
        return node.red;
    }

    public Node<T> insert(Node<T> node, T x){
        if (node == null) return new Node(x, true);
        int cmp = x.compareTo(node.val);
        if (cmp < 0) node.l = insert(node.l, x);
        else if (cmp > 0) node.r = insert(node.r, x);
        else node.val = x;

        if (isRed(node.r) && !isRed(node.l)) node = rotateLeft(node);
        if (isRed(node.l) && !isRed(node.r)) node = rotateRight(node);
        if (isRed(node.l) && isRed(node.r)) flipColors(node);

        return node;
    }

    private void flipColors(Node<T> node){
        node.red = true;
        node.l.red = false;
        node.r.red = false;
    }

    public Node<T> rotateLeft(Node<T> node){
        //must have a right child
        Node<T> res = node.r;
        node.r = res.l;
        res.l = node;
        return res;
    }

    public Node<T> rotateRight(Node<T> node){
        //must have a left child
        Node<T> res = node.l;
        node.l = res.r;
        res.r = node;
        return res;
    }


    public static void main(String[] args){
        RBTree<Integer> s = new RBTree<>();
        for (int i = 5; i < 10000; i+=5){
            s.insert(i);
        }
        System.out.println(s.find(7506));
    }

}
