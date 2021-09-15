public class IntList {
    public int first;
    public IntList rest;

    public IntList(int f, IntList r){
        first = f;
        rest = r;
    }

    public static void main(String[] args){
        IntList L = new IntList(15, null);
        L = new IntList(10, L);
        L = new IntList(5, L);
        System.out.println(L.size());
        System.out.println(L.iterativeSize());
        System.out.println(L.get(0));
        System.out.println(L.get(1));
        System.out.println(L.get(2));
    }

    //O(N)
    public int size(){
        if (this.rest == null) return 1;
        return 1 + this.rest.size();
    }
    
    //also O(N)
    public int iterativeSize(){
        int sz = 0;
        IntList p = this; //pointer
        while (p != null){
            sz++;
            p = p.rest;
        }
        return sz;
    }

    public int get(int i){
        IntList p = this;
        int val = p.first;
        while (i > 0){
            p = p.rest;
            val = p.first;
            i--;
        }
        return val;
    }
    

}
