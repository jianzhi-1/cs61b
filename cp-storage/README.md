# Data Structures and Algorithms

### Data Structures

##### List (equivalent to Vector)
- Initialisation
```java
ArrayList<String> a = new ArrayList<String>();
a.add("Brazil");
```
- Methods
```java
a.get(0);
a.set(0, "Portugal");
a.remove(0);
a.clear();
a.size();
```
- Iterators
```java
for (String i : a) {
    System.out.println(i);
}
```

##### Map
- Initialisation
```java
HashMap<String, Integer> m = new HashMap<String, Integer>();
m.put("Brazil", 1);
m.put("Portugal", 2);
```
- Methods
```java
m.size();
m.get("Portugal");
m.remove("Brazil");
m.containsKey("Portugal");
m.clear();
```
- Iterator
```java
for (String i : m.keySet()) {
    System.out.println(i);
}

for (Integer i : m.values()) {
    System.out.println(i);
}
```

##### Set
- Initialisation
```java
HashSet<String> s = new HashSet<String>();
s.add("Brazil");
```
- Methods
```java
s.contains("Brazil");
s.remove("Brazil");
s.clear();
s.size();
```
- Iterators
```java
for (String i : s) {
    System.out.println(i);
}
```

