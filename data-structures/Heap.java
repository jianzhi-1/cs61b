public class Heap<T extends Comparable<T>> {

    //Principles
    //1.    Heap always filled from left
    //2.    Smallest number on top
    //3.    Parent of node k is (k - 1)/2

    private T[] item;
    private int size;

    public Heap(){
        size = 0;
        item = (T[]) new Comparable[100];
    }

    public T top(){
        return item[0];
    }

    private int parent(int x){
        if (x == 0) return -1;
        return (x - 1)/2;
    }

    public void push(T x){

        if (3*size > item.length){
            T[] nitem = (T[]) new Comparable[2*item.length];
            for (int i = 0; i < size; i++) nitem[i] = item[i];
            item = nitem;
        }

        item[size] = x;
        int k = size;
        while (parent(k) != -1 && item[k].compareTo(item[parent(k)]) < 0){
            T temp = item[k];
            item[k] = item[parent(k)];
            item[parent(k)] = temp;
            k = parent(k);
        }
        size++;
    }

    public void pop(){
        if (size == 0) return;
        if (size == 1){
            item[0] = null;
            size = 0;
            return;
        }
        item[0] = item[size - 1];
        item[size - 1] = null;
        int k = 0;
        while (item[2*k + 1] != null){
            if (item[k].compareTo(item[2*k + 1]) > 0){
                T temp = item[k];
                item[k] = item[2*k + 1];
                item[2*k + 1] = temp;
            } else if (item[2*k + 2] != null && item[k].compareTo(item[2*k + 2]) > 0){
                T temp = item[k];
                item[k] = item[2*k + 2];
                item[2*k + 2] = temp;
            } else break;
        }
        size--;
    }

    public int size(){
        return size;
    }

}
