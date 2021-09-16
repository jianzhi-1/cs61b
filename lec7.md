# Lecture 7 Notes

### Object-Based Programming
organized around the types of objects, methods

1. class declaration
defines a new type of object (new type of structured container)

2. instance variables
simple containers within objects

4. instance methods
ordinary (static) methdos that take an invisible extra parameter (this)
new operator instantiates new objects and initialises them using constructors

5. constructors
method-like declaration to initialize new instances. take arguments from the new expression

access modifier
```java
// Account._balance returns error outside Account
public class Account {
    private int _balance;
    public int balance() {return _balance;}
}
```

convention of putting "\_" at the start of private instance variables to distinguish them from local variables and non-private variables.

### Static
In Java, "class-wide" = static (exactly 1 variable for the whole class, e.g. like the bank's total funds). It is not associated with any particular instance of the class.

```java
public class Account{
    private static int _funds = 0;
    //... from earlier

    //instance method
    public int deposit(int amount){
        _balance += amount;
        _funds += amount;
        return _balance;
    }

    public static int funds(){
        return _funds;
    }
}
```

we can call Account.funds() or myAccount.funds() (same thing) (really? check this pls)

```this``` is a reserved word. equivalent to
```java
    //the above is equivalent to
    static int deposit(final Account this, int amount){
        this._balance += amount;
        _funds += amount;
        return this._balance;
    }

    myAccount.deposit(100);
    Account.deposit(myAccount, 100);
```
note that you cannot actually run the above program because this is a reserved word and we cannot declare it as another variable


In a real instance method, we can leave off ```this``` on field access when it is unambiguous.

Real static methods do not have ```this```, so it does not make sense to refer to instacne variables in them. Java dk which instance variable you are saying

instance and static don't mix

Construtor is a kind of special instance method that is called by the new operator right after it creates a new object.

```java
L = new IntList(1, null)

//the above is equivalent to
tmp = //pointer to object
tmp.IntList(1, null);
L = tmp;
```

All classes have constructors. In the absence of explicity constructor, get the default one.
```java
public class Foo{
    public Foo(){

    }
}
```
Multiple overloaded constructors are possible and they can use each other.

```java
public class IntList{
    public IntList(int head, IntList tail){
        this.head = head;
        this.tail = tail;
    }
    public IntList(int head){
        this(head, null); //calls first constructor
        //when you call this, it calls the above constructor
        //only in this particular context in the constructor, you can call this this way
    }
}
```

Instance variables initialisationz are moved inside constructors that don't start with this(..)
```java
class Foo{
    int x = 5;
    Foo(int y)
}
```
