public class HoFDemo {
    public static int do_twice(IntUnaryFunction f, int x){
        return f.apply(f.apply(x));
    }

    public static void main(String[] args){
        IntUnaryFunction t = new TenX();
        System.out.println(do_twice(t, 2));
    }
}
