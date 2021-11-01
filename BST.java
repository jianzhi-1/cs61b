class BST<Key extends Comparable<Key>, Value>{
    
    Key _key;
    Value _value;
    BST<Key, Value> _left, _right;
    
    BST(Key key0, Value value0, BST<Key, Value> left0, BST<Key, Value> right0){
        _key = key0; _value = value0;
        _left = left0; _right = right0;
    }

    BST(Key key0, Value value0){
        this(key0, value0, null, null);
    }

    static <Key extends Comparable<Key>, Value> BST<Key, Value> find(BST<Key, Value> T, Key L){
        if (T == null) return T;
        if (L.compareTo(T._key) == 0) return T;
        else if (L.compareTo(T._key) < 0) return find(T._left, L);
        else return find(T._right, L);
    }


    static <Key extends Comparable<Key>, Value> BST<Key, Value> insert(BST<Key, Value> T, Key k, Value v){
        if (T == null) return new BST(k, v);
        if (k.compareTo(T._key) == 0) T._value = v;
        else if (k.compareTo(T._key) < 0) T._left = insert(T._left, k, v);
        else if (k.compareTo(T._key) > 0) T._right = insert(T._right, k, v);
        return T;
    }

    static <Key extends Comparable<Key>, Value> BST<Key, Value> minNode(BST<Key, Value> T){
        if (T._left == null) return T;
        return minNode(T._left);
    }

    static <Key extends Comparable<Key>, Value> BST<Key, Value> remove(BST<Key, Value> T, Key k){
        if (T == null) return null;
        if (k.compareTo(T._key) == 0){
            if (T._left == null) return T._right;
            else if (T._right == null) return T._left;
            else {
                BST<Key, Value> smallest = minNode(T._right);
                T._value = smallest._value;
                T._key = smallest._key;
                T._right = remove(T._right, smallest._key);
            }
        } else if (k.compareTo(T._key) < 0){
            T._left = remove(T._left, k);
        } else {
            T._right = remove(T._right, k);
        }
        return T;
    }

    public static void main(String[] args){
        System.out.println("hello");
        BST<Integer, String> t = new BST<Integer, String>(2, "jianzhi");
        insert(t, 1, "jz");
        insert(t, 0, "rn");
        insert(t, -1, "jw");
        insert(t, 5, "zn");
        insert(t, 4, "br");
        insert(t, 8, "zy");
        insert(t, 3, "ch");

        System.out.println("finding jz: " + (find(t, 2) != null));
        System.out.println("finding br: " + (find(t, 4) != null));
        remove(t, 4);
        System.out.println("finding br: " + (find(t, 4) != null));

    }
}
