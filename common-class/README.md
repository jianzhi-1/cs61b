# Common Class
### Reader

### Scanner

### Iterator
Methods:
- ```boolean hasNext();``` : true if iteration has more elements
- ```E next();``` : returns next element in iteration
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

### Collections
#### List
#### Queue
##### Deque
#### Set

### Comparables

