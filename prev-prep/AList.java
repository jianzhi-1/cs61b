public class AList<T> {
    private T[] items;
    private int size;

    public AList(){
        items = (T[]) new Object[100];
        size = 0;
    }

    private void resize(int capacity){
        T[] a = (T[]) new Object[capacity];
        System.arraycopy(items, 0, a, 0, size);
        items = a;
    }

    public void addLast(T x){
        if (size == items.length){
            resize(size*2);
        }
        items[size] = x;
        size++;
    }

    public void removeLast(){
        items[size - 1] = null;
        size--;
    }

    public T getLast(){
        return items[size - 1];
    }

    public int size(){
        return size;
    }

}
