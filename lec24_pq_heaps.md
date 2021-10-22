# Priority Queues and Heaps

Priority queues support the following operations:
- add
- find largest
- remove largest

Heap is a common implementation of the priority queue.

Max-heap is a binary tree that enforeces the heap property: labels of both chilldren of each node are less than the node's label.
Looser than binary search property, which allows the tree to be evenly distributed (bushy).
Thus, valid to put the smallest node anywhere at the bottom of the tree.
"nearly complete": all but possibly the last row have as many keys as possible.

Insertion of new value and deletion of largest value always *O(log N)* due to bushiness.
Height bounded by *log N*

Methods
1. Insertion: add at the last position, then bubble up ("re-heapify"; the invariance is preserved)
2. Deletion: swap root node (the largest) with the last item, then bubble down (swap with larger child).
3. Search: just do a linear scan *O(N)*

If duplicates exist in the heap, the operations are not affected.

Can use 1-indexed array for compact representation.

### Range Search on BST
Time complexity: *O(h + M)* (approx *O(log N + M)* for bushy binary tree)

```java
static void visitRange(BST<String> T, String L, String U, Consumer<BST<String> > x){
  if (T == null) return;
  int compLeft = L.compareTo(T.label()), compRight = U.compareTo(T.label());
  if (compLeft < 0) visitRange(T.left(), L, U, x);  // left subtree
  if (compLeft <= 0 && compRight > 0) x.accept(T); // current label
  if (compRight > 0) visitRange(T.right(), L, U, x); // right subtree
}
```

### SortedSet
```java
S.headSet(U); // subset < U
S.tailSet(L); // subset >= L
S.subSet(L, U); // subset >= L, < U
```

```TreeSet``` is a kind of binary search tree (red-black tree).
Java requires ```TreeSet<T>``` ```T``` to be either comparable or you provide a Comparator.
```<T extends Comparator<T> >```

```java
SortedSet<String> rev_fauna = new TreeSet<String>(Collections.reverseOrder());

static <T extends Comparable<T> > Comparator<T> reverseOrder(){
    return (x, y) -> y.compareTo(x);
}
```

For implementation, can use the same for both set and subset (set has upper bound and lower bound set to null)
