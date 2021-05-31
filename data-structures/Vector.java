public class Vector<T> {
    
    private T[] items;
    private int size;

    public Vector(){
        items = (T[]) new Object[100];
        size = 0;
    }

    private void resize(int capacity){
        T[] a = (T[]) new Object[capacity];
        System.arraycopy(items, 0, a, 0, size);
        items = a;
    }

    public void pushBack(T x){
        if (size == items.length) resize(size*2);
        items[size] = x;
        size++;
    }

    public void popBack(){
        items[size - 1] = null;
        size--;
        if (4*size < items.length) resize(size/2);
    }

    public T back(){
        return items[size - 1];
    }

    public int size(){
        return size;
    }

    @Override
    public String toString(){
        StringBuilder s = new StringBuilder("[");
        for (int i = 0; i < size; i++){
            s.append(items[i].toString());
            if (i != size - 1) s.append(", ");
        }
        s.append("]");
        return s.toString();
    }

    @Override
    public boolean equals(Object other){
        if (other == null) return false;
        if (this == other) return true;
        if (other.getClass() != this.getClass()) return false;
        Vector<T> o = (Vector<T>) other;
        if (this.size() != o.size()) return false;
        for (int i = 0; i < this.size(); i++){
            if (!items[i].equals(o.items[i])) return false;
        }
        return true;
    }

    public static <T> Vector<T> of(T... n){
        Vector<T> res = new Vector<T>();
        for (T x : n) res.pushBack(x);
        return res;
    }

}

