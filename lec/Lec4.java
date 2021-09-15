
public class Lec4{
    
    // Non-destructively remove all instances of x from L
    static IntList removeAll(IntList L, int x){
        if (L == null) return null;
        if (L.head == x){
            return removeAll(L.tail, x);
        } else {
            return new IntList(L.head, removeAll(L.tail, x));
        }
    }

    // Iteratively non-destructively remove all instances of x from L
    static IntList iterRemoveAll(IntList L, int x){
        IntList result, last;
        //result stores the returned pointer
        //last points to the last node in the IntList under construction
        result = last = null;
        for (; L != null; L = L.tail){
            if (x == L.head) continue;
            if (last == null){
                //initializes both result and last
                result = last = new IntList(L.head, null);
            } else {
                //construct the IntList based on last
                last = last.tail = new IntList(L.head, null);
            }
        }
        return result;
    }

    //destructively remove all instances of x from L
    static IntList dremoveAll(IntList L, int x){
        if (L == null) return null;
        if (L.head == x) return dremoveAll(L.tail, x); //it's not necessary to break any link
        //unlike C, no need to clean up i.e. no need to worry about memory leaks
        L.tail = dremoveAll(L.tail, x); //reconstructs the link
        return x;
    }

    //iteratively destructively remove
    static IntList diterRemoveAll(IntList L, int x){
        IntList result, last;
        result = last = null; //result return 
        while (L != null){
            IntList next = L.tail;
            if (x != L.head){
                if (last == null){
                    result = last = L;
                } else {
                    last.tail = L;
                    last = last.tail;
                }
                L.tail = null; //must set this, otherwise the IntList is not broken
            }
            L = next;
        }
        return result;
    }

}
