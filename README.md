# CS61B

Use _Template.java_ to begin.

### Data Structure Library
- Vector: implemented, untested
- DisjointSet: implemented, untested
- BTree: implemented, tested
- Red Black Tree: 

### Notes
- Private:
- Public:
- Static: 
- Reflexions:
- Method overloading: multiple methods with same name, but different signatures/parameters
- Method overriding: subclass has a method with exact same signature as superclass (only applies to inheritance relationships)
- Interface: list of all method signatures, subclasses <b>must</b> override all of these methods
- Static type (compile-time type): type specified at declaration, never changes. Compiler allows assignment based on <b>compile-time</b> types.
- Dynamic type (run-time type): type specified at instantiation. Dynamic type methods override static type methods.
- Extends: inherits all the members of another class, including instance, static variables, methods and nested classes. Constructors are not inherited. Private members are not accessible.
- Super: calls parent's methods. Specify _super();_ in subclasses.
- Casting: similar to _(ll)_ in C++, but use sparingly


### Dynamic Method Selection Notes
- Compiler allows memory box to hold any subtype.
- Compiler allows calls based on static type.
- Overriden non-static methods are selected at runtime based on dynamic type.
    - Everything else is based on static type, including overloaded methods.

### Debugging
- _$ time java SpeedTest_
- _@Override_
- _.equals()_ instead of _==_
- _throw new IllegalArgumentException("Cannot add null!");_

### Data Structures Notes
- 2D Array: _int[][] arr;_

- Sets: 
    - _import java.util.HashSet;_
    - _import java.util.Set;_
    - _Set<Integer> s = new HashSet<>();_
    - _s.add(10);_
    - _for (int j : s) System.out.println(j);_

- Iterators:
    - _import java.util.Iterator;_
    - _Iterator<Integer> seer = s.iterator();_
    - _it.hasNext();_
    - _it.next();_

### Implementations
- _System.arraycopy(b, idxb, x, idxx, l)_: copies from _b_ to _x_, with _idxb_ mapping to _idxx_, copying a length of _l_
- _T[] a = (T[]) new Object[size];_
- _public class T implements Comparable<T>
    - _public int compareTo(T other)_
- _Collection.max()_
- _StringBuilder_ instead of _String_

- _public interface List<Item>_
- _public class AList<Item> implements List<Item>_