# Lab 3 Notes

### Doubly Linked List

IntDList is like a wrapper class; it encapsulates the DNode objects.
- front
- back

##### insertFront
```java
DNode x = new DNode(7);
x.next = DL.front;
DL.front.prev = x;
DL.front = x;
// be careful of edge cases when list only has one element
```

#### deleteFront
```
DL.front = DL.front.next;
DL.front.prev = null;
// the original DNode is garbage-collected because it's no longer referenced
// be careful of edge case when list is empty
```
