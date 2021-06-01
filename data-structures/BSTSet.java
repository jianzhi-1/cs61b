public class BSTSet<T extends Comparable<T>>{
    public int size;
    private T val;
    private BSTSet<T> l, r;

    public BSTSet(){
        size = 0;
        val = null;
        l = null;
        r = null;
    }

    public int size(){
        return size;
    }

    public void insert(T x){
        size++;
        if (val == null){
            val = x;
            return;
        }
        if (l == null) l = new BSTSet<>();
        if (r == null) r = new BSTSet<>();
        if (val.compareTo(x) < 0) r.insert(x);
        else l.insert(x);
    }

    public boolean find(T x){
        if (val == null) return false;
        if (val.equals(x)) return true;
        if (l == null) l = new BSTSet<>();
        if (r == null) r = new BSTSet<>();
        if (val.compareTo(x) < 0) return r.find(x);
        else return l.find(x);
    }

    public T lowerBound(T x){
        return x;
    }

    public T upperBound(T x){
        return x;
    }

    public void delete(T x){
        if (val == null) return;
        if (val.equals(x)){
            if (l == null) l = new BSTSet<>();
            if (r == null) r = new BSTSet<>();
            if (l.size() == 0 && r.size() == 0){
                val = null;
            } else if (l.size() > 0 && r.size() > 0){
                T obj = upperBound(x);
                val = obj;
            } else if (l.size() > 0){
                val = l.val;
                r = l.r;
                l = l.l;
            } else if (r.size() > 0){
                val = r.val;
                l = r.l;
                r = r.r;
            }
            return;
        }

    }
}
