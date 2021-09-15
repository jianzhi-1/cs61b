# Lecture 5 Notes

Arrays are anonymous (i.e there is no name for array objects. there's only name for pointers to them), like other structured containers.
```java
int[] x, y, z;
```
does not create any objects
```java
x = new int[3];
```
creates the object

Other declarations
```java
int[] q;
q = new int[]{1, 2, 3};
int[] r = {7, 8, 9}; //can delete off the new int[] ...
```

All variables in Java has initial value. 
The default value for int is 0.
The default value for any boolean is false.
The default value for any pointer is null.
If you do new int[], initially all values are 0.

```java
System.arraycopy(arr, k, arr, k + 1, arr.length - k - 1);
//               from-pt to-pt       # to copy
```

```java
import static java.lang.System.arraycopy;
//equivalent to define the simple name arraycopy to be the equivalent of java.lang.System.arraycopy in the current source file.
```

```java
import static java.lang.Math.*;
//equivalent to taking all the (public) static definitions in java.lang.Math and make them available in this source file by their simple names
//sin, sqrt
```

Multi-Dimensional Array
```java
int[][] A = new int[3][];
for (int i = 0; i < 3; i++) A[i] = new int[]{1, 2, 3, 4};

int[][] A;
A = new int[][]{
    {1, 2, 3, 4},
    {5, 6, 7, 8}
};

int[][] A = new A[3][4];
```

