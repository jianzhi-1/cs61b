# Generic Type

Brief history: in the old days, no generic types, so all parameters are of type Object, i.e. have to cast into the correct static type for the compiler.

### Parameterized types: ```List<String>```
type parameters
Instantiating a generic type is analogous to calling a function; the type parameter is liek the argument.

Examples:
```java
public class ArrayList<Item> implements List<Item> {
    public Item get(int i){}
    public boolean add(Item i){}
}
```

Methods can also be parameterized by type:

Only put ```<T>``` for static methods.
```java
static <T> List<T> singleton(T item){
    // logic
}
```
Compiler infers the type ```T``` by looking at the type of ```item```.

### Wildcard type parameters
```java
static int freq(Collection<?> c, Object x){}
```

### Subtyping
In general *T1\<X> <= T2\<Y>* must have *X = Y*.
In general *T1\<X> <= T2\<X>* if *T1 <= T2*
```java
ArrayList<String> ALS = new ArrayList<String>();
List<String> LS = ALS;
```

There is an inconsistency
```String[] <= Object[]```
Causes runtime error ```ArrayStoreException``` instead of static compile-time error.

### Type Bounds
Sometimes, need to ensure that a parameter type is replaced only by a subtype or a supertype

```java
class NumericSet<T extends Number> extends HashSet<T> {
    // T must be a subtype of Number
    T min(){}
}
```

```java
    // we don't care about the type of the list
    // but the item to be inserted must be a subtype
    // i.e. the type of the list must be a supertype of T
    static <T> void fill(List<? super T> L, T x){}
```

```java
static <T> int binarySearch(List<? extends Comparable<? super T> > L, T Key)
```








