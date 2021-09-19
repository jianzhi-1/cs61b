# CS61B
### UC Berkeley Fall 2021, taught by Prof Paul Hilfinger
This repository is meant to store my lecture/discussion notes, which I think would be nice to share with my peers. I will **not** be uploading anything related to homework or assignments. Please contact me if you feel any file should not be here. Thanks!

### Receiving Assignments
On local, pull from central repository.
```shell
$ cd repo
$ git fetch shared
$ git merge -m "Start Lab 1" shared/lab1 --allow-unrelated-histories
$ git push
```

### Testing on Instructional Account
On local computer, check which files to push to central repository. 

```shell
$ git status
$ git add .
$ git commit -m "some message"
$ git push
```

SSH into remote computer, change directory to *repo* (only *repo* is git initiated). Pull all the changes (from the central repository, which contains your local changes), then test.


```shell
$ ssh cs61b-***@derby.cs.berkeley.edu
$ cd repo
$ git pull

// do your testing
$ javac Tester.java
$ java Tester
```

### Submitting Assignments
After testing, check git status, then tag it with labx-y where x is the lab number and y is the attempt number. Push both.
```shell
$ git status
$ git tag lab1-0
$ git push
$ git push --tags
```

### IntelliJ Misc

##### Initial Set Up
Open
File > Project Structure > Libraries > import libraries in ```cs61b-software/lib```

##### Unit Testing (for directories with Makefile):
```shell
$ make
$ make adhoc-check
$ make check
```

### Some checks before submitting HW
- ```/** Documentation comments */```
- Do not use ```//``` for comments

### Grading
- Tests (40%)
- Projects (50%)
- HW (10%)
- Course is not curved

## Actual Notes

### Definitions
#### Access Control
- Private: restricts access to only this class
- Package Protected (default): restricts access to all classes in the same package (if not declared, programs are put into *anonymous package*)
- Protected: restricts access to all classes in the same package and subclasses that extends from the parent
- Public: all classes in the program can access

```java
package numbers;
public class PrimeSieve{}
//refer as numbers.PrimeSieve outside package
```

#### OOP
- Static: Methods called without creating object of the class. Static methods can only use static variables of the class. Static classes and methods cannot reference any non-static variables.
- Non-static (instance): Has an implicit first parameter *this* and is called by *O.f()* where *O* becomes *this*.
- Final: field may be assigned to exactly once, after which any further assignments are illegal.
- Overloading function name: two functions with the same name are not confused because they take in a different number/type of arguments.
- Methods that could be overridden:
```java
boolean equals(Object x); // checks if two objects have the same memory address
int hashCode(); // returns a hashcode for object; used in equals
String toString();
```

### Inheritance

- Interface: Makes all methods implicitly abstract and public. Similar to *abstract class* but differs in that all methods are abstract and must have no bodies and all fields are static constants. Can extend any number of other interfaces.
```java
public interface FiniteNaturalSet{
  int limit();
  boolean contains(int x);
}
// do not declare methods as public abstract ... since those are implicit

public class PrimeSieve implements FiniteNaturalSet{
  //implement limit and contains here
}

static void printSet(FiniteNaturalSet set){}; //this works for any subtype of FiniteNaturalSet
``` 
- Inheritance: When *C* extends *P*, *P* is the direct superclass of *C* and *C* is the direct subclass of *P*. Without *extend*, a class automatically becomes a direct subclass of *Object*. When extend is used, the following things are inherited:
  - all non-private instance and static variables
  - all non-private methods
  - all nested classes
  - **NOT INHERITED**: constructors and private variables and methods

There is always an implicit call to the parent's constructor
When an object extends another, the constructor automatically calls the parent's default constructor (i.e. the one with no arguments) and this is the first thing done in the child's constructor. Otherwise, ```super(args)``` should be used.
If a non-static method declaration in *C* has the same name and argument types as one that is inherited from *P*, then *C* overrides the definition of that method (mark out using ```@Override```).
- Abstract: not completely implemented. Any class with abstract methods must be abstract. An unimplemented method cannot be called. An abstract class may not have instances, however it is possible to have *new C[]* (an array of abstract objects).

```java
public abstract class FiniteNaturalSet{
  public abstract int limit();
  public abstract boolean contains(int x);
}

public class PrimeSieve extends FiniteNaturalSet{
  //implement limit and contains here
}
```

One can implement any number of interfaces, but can extend only one class.
A call on an instance method (i.e. *A.f()*) chooses *f* depending on the current value of *A*.
- Exceptions:
```java
throw new IllegalArgumentException();
try {
  //code here
} catch (FileNotFoundException e){
  System.err.println("failed");
}
```

- Values: immutable. In Java, *byte*, *char*, *short*, *int*, *long*, *float*, *double*, *boolean*, *pointers*.
- Containers: something that contains values and other containers. Can be named or anonymous. All simple containers contain either numeric values, booleans or pointers.
- Pointers == References: value used to designate a container. Two pointers are the same if they point to the same container

### Dynamic Method Selection
- Static type: type specified at declaration and never changes. Equivalent to compile-time type. Restricts the value it can contain.
- Dynamic type: type specified at instantiation (e.g. when using keyword *new*); equal to the type of object it is pointing at
- If a container's static type is primitive, it is the same as its dynamic type. Else (container has a reference type), then its dynamic type is a subtype of the container's type.
```java
P x = new Q();
// static type is "pointer to P"
// dynamic type is "pointer to Q"
```

#### Method Selection Algorithm
- Compiler allows calls based on **static type**.
  - At compile time, compiler verifies based on the static type of all objects and records the signature of this method.
  - If there are multiple methods, compiler chooses the most specific one.
- During runtime, overriden non-static methods (same signature as the recorded method previously) are chosen based on **dynamic type**.
- For all other cases (static methods, overloaded methods), use previously recorded method.

#### Casting
- Casting is temporary.
- It temporarily changes the static type when compiling, so the method recorded depends on the casted type. 
- Otherwise, it does not change the static type nor the dynamic type later on.
- Equivalent to telling the compiler to temporarily treat a variable as type \<T> for purpose of type-checking.
 
#### Hiding
Subclass has variables with same name as superclass
Subclass has a static method with same signature as a superclass method
Overriding does not apply for static methods.

If a method called is instance method, choose dynamic type (dynamic's type method will override the static type method).
If a method is static, choose static type. (i.e. if ```f``` is static, then ```x.f()``` depends solely on the static type of ```x```).
Casting temporarily changes the static type (i.e. ```(A)x``` will make the static type of ```x``` ```A```).
Subclasses can be assigned to superclasses (and **NOT** the other way around).
Static type is always used to select the parameters.
Compiler always checks static type first, selects the most specific method, then overrides it during run-time with dynamic type (overriding method must have same signature!).
Static methods cannot be overridden!

```java
Parent x = new Child();
// Parent: static type (what the compiler believes at compile-time)
// Child: dynamic type (assigned during run-time)
```

A good way to handle DMS problems:
```java
// compile: Parent's fn(Parent x) is recorded
// run: not found Child's fn(Parent x)
// result: Parent.fn
```

### Generic Type
- Here, ```T``` is a generic type variable
```java
public class A<T> {
    private T x;

    public String f(T y) {
        return y.toString();
    }
}

A<String> aClass = new A<>();
```

### Common Classes
- Reader (in progress)
A Reader is typically connected to a source of data, like a String, a File or CharArray etc.
  - [File Reader, One Char at a Time](https://github.com/jianzhi-1/cs61b/blob/main/common-class/AReader.java)
  - [File Reader to Char Array](https://github.com/jianzhi-1/cs61b/blob/main/common-class/BReader.java)

- Scanner (in progress)

### Strings
```java
s.length();
s.charAt(x);
s.equals(s1);
s.substring(idx1, idx2);
s.substring(idx1);
// check if x is a vowel
("aeiou").indexOf(x) >= 0;
```

### Arrays
```java
int[] A;
A = new int[]{1, 2, 3};
A = new int[100];
int[] A = new int[100];

int[][] A;
A = new int[N][N];
A = new int[N][]; // only specify the first dimension, set the other dimension individually
A = new int[][]{
  new int[]{1, 2, 3},
  new int[]{4, 5, 6},
  new int[]{7, 8, 9}
};
int[][] A = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
```

### Enum
```java
enum Color{
  Red, Yellow, Green, Blue, Violet
}

Color.values(); // returns [Red, Yellow, Green, Blue, Violet] in order
c.ordinal(); //returns position of c
c.name(); 
Color.valueOf(s);

switch(c){
  case Red:
    return 1;
  case Yellow:
    return 2;
  ...
}
```

### Data Structures to Read Over
- ArrayList
- ArrayDeque
- LinkedList
- HashMap
- TreeMap
- HashSet
- TreeSet
- BitSet

### To-Do
- [ ] Comparators and Comparables
- [ ] Tries
- [ ] Binary Trees
- [ ] Heap
- [ ] Minimax
- [ ] Minimax with alpha-beta pruning
- [ ] Binary Search
- [ ] DFS
- [ ] BFS
- [ ] Dijkstra
- [ ] A* Search
- [ ] Prim's Algorithm
- [ ] Kruskal Algorithm
https://cs61b.bencuan.me/

### Exam Area

#### Midterm 1 Prep 😤
- [ ] YY Fall/Spring/Summer


