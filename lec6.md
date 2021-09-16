# Lecture 6 Notes

### Multidimensional Array

```java
int[][] A = new int[3][];
for (int i = 0; i < 3; i++) A[i] = new int[]{1, 2, 3, 4};

int[][] A;
A = new int[][]{
    {1, 2, 3, 4},
    {5, 6, 7, 8}
};

int[][] A = {
    {1, 2, 3, 4},
    {5, 6, 7, 8}
}

int[][] A = new A[3][4];
```

Every element of array is independent, so there is no need for rectangular arrays; can just adjust the width

### Testing

Unit testing: testing of individual methods within a program, rather than the whole
Module testing: testing of classes or groupings of methods and data
System testing: testing of functionality of the whole program

JUnit tool for unit testing

Test-Driven Development: Write tests first; Implement unit at a time, run tests, fix and refactor till it works

Example: Testing a sorting algorithm
- corner cases (empty array, one-element, same elements)
- representative middle cases (reversed list, already sorted list, one pair reversed)
write comments for the tests

### JUnit
```java
@Test
```
- ```@Test``` is a Java annotation (provides information about a method, class ...) on a method that tells JUnit machinery to call that method
- JUnit runs all methods that are annotated with ```@Test```
- a collection of methods ```assert``` to check conditions and report failures
- test cases should be *non-destructive* (otherwise, other test cases might fail)
- ```assertEquals``` by default compares the values of the two objects. So if called on different pointers, it will always give false.

```java
import org.junit.Test;
import org.junit.Assert.*;

@Test
public void emptyTests(){
    assertArrayEquals("Empty array failed", new String[] {}, runSort(new String[]{}, 0, 1));
}

public static void main(String... args){
    ucb.junit.textui.runClasses(SortTesting.class);
}
```

### Sorting

Selection sort: find the largest element, swap it to the back, continue
Java does call by value, so no general way to write a swap function

```java
static void sort(String[] A, int L, int U){
    if (L < U){
        int k = indexOfLargest(A, L, U);
        String tmp = A[k];
        A[k] = A[U];
        A[U] = tmp;
        sort(A, L, U - 1);
    }
}

static int indexOfLargest(String[] V, int i0, int i1){
    if (i0 == i1) return i0;
    int x = indexOfLargest(V, i0, i1 - 1);
    if (V[x] < V[i1]) return i1; //compare to
    return x;
}
```
