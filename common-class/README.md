# Common Class
### Reader

### Scanner

### Iterator
Methods:
- ```boolean hasNext();``` : true if iteration has more elements
- ```E next();``` : returns next element in iteration, moves iterator forward also
- ```default void remove();```
- ```default void forEachRemaining(Consumer<? super E> action);```

```java
for (Iterator<String> i = L.iterator(); i.hasNext();) {
    String value = i.next();
    System.out.print(value + " ");
}

Iterator<String> i = L.iterator();
while (i.hasNext()) {
    String value = i.next();
    System.out.print(value + " ");
}
```

### Iterable
```java
package java.lang;
public interface Iterable<Value> {
    Iterator<Value> iterator();
}
```

```java
import java.util.Iterator;
class List<T> implements Iterable<T> {
    public Iterator<T> iterator(){
        return new ListIterator<T>(this);
    }
}

class ListIterator<T> implements Iterator<T> {
    public boolean hasNext(){};
    public T next(){};
}
```

### Collections
#### List
#### Queue
##### Deque
#### Set

### Comparables

### Exceptions

### Throwable
