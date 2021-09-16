# Lecture 8 Notes
How to get System.out.print(x) to print x regardless of type of x?
Partial solution: overloading - multiple method defintiions with same name and different number/types of arguments.

How to get a list of anything?
any reference value can *cast* as type Object and back, so can use Object as generic reference type.

```java
Object[] things = new Object[2];
things[0] = new IntList(3, null);
things[1] = "Stuff"
IntList thingsList = (IntList) things[0];
((IntList) things[0]).head == 3;
((String) things[1]).startsWith("St")
// things[0].head is illegal
// things[1].startsWith("St") is illegal
```

Such reference casts don't change the value of a pointer, but rather tell the compiler how to treat it. The problem with this is that you can "lie" to the compiler.

Primitive values (ints, longs, bnytes, shorts, floats, doubles, chars and booleans) are not really convertible to Object, which creates a problem when creating a list of anything.

Java defined a whole set of parallel tyupes (wrapper types), one for each primitive type.

byte -> Byte
long -> Long
float -> Float


Creating new wrapper objects for any value (boxing)
```java
Integer Three = new Integer(3);
Object ThreeObj = Three;
(unboxing)
int three = Three.intValue();
```

Boxing and unboxing are automatic in many cases.
```java
Integer Three = 3;
int three = Threel
int size = Three + 3;
Integer[] someInts = {1, 2, 3};
for (int x: someInt){ System.out.println(x); }
```

#### Dynamic and Static Types
each value (pointer, int) has a type - its dynamic type (Object[], IntList, int, <nulltype>, String)
Every container (variable, component, parameter), literal, function call and operator has a type - static type. i.e. every expression has a static type (IntList, Object[], int, String). it is something that the compiler knows.

A container with static type T may contain a certain value onlu of that value is a T (i.e. if the dynamic type of the value is a subtype of T). A functino with return type T may return only values that are subtypes of T.

All types are subtypes of themselves.
Reference types form a type hierarchy; some are subtypes of tohers
null's type is a subtype of all reference types
All reference types are subtypes of Object.

Object <-- Objects[] <-- String[] <-- <nulltype>
called a lapice? laplace?

Java is designed so that any expression of static type T always yields a value that is a T.
Static types are known to the compiler, because you declare them
```java
String x;
int f(Object s){
    int y
}
```
Compiler insists that in an assignment L = E or function call f(E), E's static type must be a subtype of L's static type for reference types.

Static type requirements for other operations like E[], E must be an array.

Primitive types live outside the hierarchy of reference types. We do not say short is a subtype of int.

However, values can be coerced(converted) to a value of type int, using the same cast syntax as for reference types.

coercions of primitive types are computations that can change values. (like overflow of long to int)

#### Automatic coercions and promotions
Java silently coerces smaller integer types to larger ones, float to double, integer types to float or double.
Compiler convert literals to shorter integer types if the values fit.


#### Consequences
```java
int[] A = new int[2];
Object x = A;
A[i] = 0;
x[i + 1] = 1; //ERROR, compiler doesn't know x is an array, because static type of X is not array
//must do ((int[])x)[i + 1] = 1;
//if we lie to the compiler, we will get runtime errors - exceptions
```
#### Overriding and Extension
operation like .toString() is defined for all Objects. You can always say x.toString() if x has a reference type. You can override the default definition.

```java
@Override // COmpiler checks that Object really has a toString
public String toString(){
    StringBuffer b = new StringBuffer();
    b.append("[");
    for (IntList L = this; L != null; L = L.tail){
        b.append(" " + L.head);
    }
    b.append("]");
    return b.toString();
}
```
conveniently, various operations requiring Strings call .toString() for you, like concatenating, System.out.println();

#### Extending a class
To say that class B is a direct subtype of class A (or A is a direct superclass) write
class B extends A {
    ...
}

By default class ... extends java.lang.Object

The subtype inherits all fields and methods of its direct superclass and passes them along to any of its subtypes.

In class B, you may override an instance method (but not a static method) by providing a new definition with same singature (name, return type, argument types)

If f(...) is an instance method, then the call x.f(...) calls whatever overriding of f applies to the dynamic type of x, regardless of static type of x.
TLDR, for instance methods only!!! (not static), select method based on **dynamic type**.

```java
Prof a = new Prof();
TA b = new TA();
Worker ap = a, bp = b;
// Dynamic type of ap is Prof
// Dynamic type of bp is TA
// ap.work() will do the same thing as a.work()
// bp.work() will do the same thing as b.work()
```

#### Fields (instance variables), Static methods
Fields hide inherited fields of the same name; static methods hide methods of the same signature.
From what I see, it depends on static type.

#### Conclusion
superclass can define a set of operation (methods) that are common to many different classes.
subclasses can then provide different implementations of these common methods, then specialize in some way
All subcases will have at least the methods listed by the superclass.
When we write methods that operate on the superclass, they will automatically work for all subclasses with no extra work.

Java Library Type Hierarchy in lecture 8




