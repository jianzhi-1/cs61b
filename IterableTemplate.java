public class IterableTemplate<T> implements Iterable<>{

    class CustomIterator<T> implements Iterator<>{

        public CustomIterator(IterableTemplate obj){
            //initialise cursor
        }
    
        //checks if next element exists
        public boolean hasNext(){
    
        }
    
        //moves the cursor/iterator to next element
        public T next(){
    
        }
    }
    
    public Iterator<T> iterator(){
        return new CustomIterator(this);
    }
}

