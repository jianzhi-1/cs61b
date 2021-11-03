# Regex Guide

### Classics


### Meta


### Quantifiers


### Grouping

### Advanced

### Common Applications

```java
String pattern = "(\\w)(\\s+)([\\.,])";
System.out.println(EXAMPLE_TEST.replaceAll(pattern, "$1$3"));
```

```java
s.matches("regex");
s.split("regex");
s.replaceFirst("regex");
s.replaceAll("regex", "replacement");
```

#### Negative Look Ahead
```(a?!b)```


