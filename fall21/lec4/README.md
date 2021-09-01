Keyword final in variable declaration means that variable's value may not be changed after the variable is initialized.

In Java, cannot return functions i.e. Java doesn't allow function passed as a value (e.g. print in Python), lambda (anonymous function)
However, we can achieve the same effect using *instance methods of objects*.

```python
def doAll(L, action):
    for x in L:
        action.accept(x)
class Printer1:
    def accept(self, y):
        print(y)
class Printer2:
    def accept(self, y):
        print(y + y)
doAll()
```

```java
class Something {
    static void doAll(List<String> L, Consumer<String> action){
        for (String x : L) action.accept(x);
    }
}
class Printer1 implements Consumer<String>{
    public void accept(String y){ System.out.println(y); }
}

class Printer2 implements Consumer<String>{
    public void accept(String y){ System.out.println(y + y); }
}

Something.doAll(L, new Printer1());
Something.doAll(L, new Printer2());
```

There may be a shorthand for lambda in Python
```java
(y) -> System.out.println(y + y);
```
