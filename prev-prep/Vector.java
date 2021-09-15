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

}

