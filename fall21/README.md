# CS61B
### UC Berkeley Fall 2021, taught by Prof Hilfinger
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
- Public: can be called/referred to from anywhere.
- Private: restricts access to the same class.
- Protected: restricts access to the same package and subclasses (extends from class in package).
- Package: a group of classes, used to restrict information in the package. If not declared, programs are put into *anonymous package*.
```java
package numbers;
public class PrimeSieve{}
//refer as numbers.PrimeSieve outside package
```
- Static: Methods called without creating object of the class.
- Non-static: equivalent to instance method. Has an implicit first parameter *this* and is called by *O.f()* where *O* becomes *this*.
- Interface: Makes all methods implicitly abstract and public.
```java
public interface FiniteNaturalSet{
  int limit();
  boolean contains(int x);
}

public class PrimeSieve implements FiniteNaturalSet{
  //implement limit and contains here
}

static void printSet(FiniteNaturalSet set){}; //this works for any subtype of FiniteNaturalSet
``` 
- Abstract: not completely implemented. Any class with abstract methods must be abstract. An unimplemented method cannot be called.

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







