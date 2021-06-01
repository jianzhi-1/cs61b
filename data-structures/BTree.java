//BTree with arbitrary L
//Invariants
//1.    All leaves are of same distance from root
//2.    A non-leaf node with k items must have exactly k + 1 items
//3.    No node contain more than L items

public class BTree<T extends Comparable<T> > {
    private int l;
    private T[] val;
    private BTree<T>[] children;
    private int n; //number of values;
    private int nsize; //size of children
    private BTree<T> par; //parent pointer
    
    public BTree(int L){
        l = L;
        val = (T[]) new Comparable[L + 1];
        children = (BTree<T>[]) new BTree[L+2];
        par = null;
    }

    //constructor for splitting
    private BTree(int L, T[] v, BTree<T>[] ch, BTree<T> p, boolean left){
        l = L;
        val = (T[]) new Comparable[L + 1];
        children = (BTree<T>[]) new BTree[L + 2];
        if (left == true){
            //left half
            n = 0;
            nsize = 0;
            for (int i = 0; i < (l/2); i++){
                val[i] = v[i];
                if (val[i] != null) n++;
            }
            for (int i = 0; i <= (l/2); i++){
                children[i] = ch[i];
                if (children[i] != null) nsize++;
            } 
        } else {
            //right half
            n = 0;
            nsize = 0;
            for (int i = (l/2) + 1; i < l; i++){
                val[i - ((l/2) + 1)] = v[i];
                if (val[i - ((l/2) + 1)] != null) n++;
            }
            for (int i = (l/2) + 1; i <= l; i++){
                children[i - ((l/2) + 1)] = ch[i];
                if (children[i - ((l/2) + 1)] != null) nsize++;
            }
        }
        par = p;
    }

    public void propagate(T x, BTree<T> tl, BTree<T> tr){
        //just add to list
        int idx = 0;
        for (int i = 0; i < n; i++){
            if (x.compareTo(val[i]) < 0) break;
            idx++;
        }
        for (int i = idx + 1; i <= n; i++){
            val[i] = val[i - 1];
        }
        val[idx] = x;
        for (int i = idx + 2; i <= n + 1; i++){
            children[i] = children[i - 2];
        }
        children[idx] = tl;
        children[idx + 1] = tr;
        n++;
        
        if (n == l){
            BTree<T> cl = new BTree(l, val, children, par, true);
            BTree<T> cr = new BTree(l, val, children, par, false);
            if (par != null) par.propagate(val[l/2], cl, cr);
            else {
                T temp = val[l/2];
                val = (T[]) new Comparable[l];
                val[0] = temp;
                children = (BTree<T>[]) new BTree[l + 2];
                children[0] = cl;
                children[1] = cr;
                n = 1;
                nsize = 2;
                return;
            }
        }
    }

    public void insert(T x){
        if (nsize == 0){
            //leaf node
            int idx = 0;
            for (int i = 0; i < n; i++){
                if (x.compareTo(val[i]) < 0) break;
                idx++;
            }
            for (int i = idx + 1; i <= n; i++) val[i] = val[i - 1];
            val[idx] = x;
            n++;
            if (n == l){
                BTree<T> cl = new BTree(l, val, children, par, true);
                BTree<T> cr = new BTree(l, val, children, par, false);
                if (par != null){
                    par.propagate(val[l/2], cl, cr);
                } else {
                    T temp = val[l/2];
                    val = (T[]) new Comparable[l];
                    val[0] = temp;
                    children = (BTree<T>[]) new BTree[l + 2];
                    children[0] = cl;
                    children[1] = cr;
                    n = 1;
                    nsize = 2;
                    return;
                }
            }
        } else {
            if (x.compareTo(val[0]) < 0){
                children[0].insert(x);
            } else if (x.compareTo(val[n - 1]) > 0){
                children[n].insert(x);
            } else {
                for (int i = 1; i < n; i++){
                    if (x.compareTo(val[i]) < 0){
                        children[i].insert(x);
                        return;
                    }
                }
            }
        }

    }

    public boolean find(T x){
        if (n == 0) return false;
        if (nsize == 0){
            for (int i = 0; i < n; i++){
                if (x.equals(val[i])) return true;
            }
            return false;
        }
        if (x.equals(val[0]) || x.equals(val[n - 1])) return true;
        if (x.compareTo(val[0]) < 0) return children[0].find(x);
        if (x.compareTo(val[n - 1]) > 0) return children[n].find(x);
        for (int i = 1; i < n; i++){
            if (x.equals(val[i])) return true;
            if (x.compareTo(val[i]) < 0) return children[i].find(x);
        }
        return false;
    }

}
