public interface List61B<T>{
    public void addLast(T x);
    public T getLast();
    public int size();
    public T removeLast();

    default public void printSize(){
        System.out.println(size());
    }
}