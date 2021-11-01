import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.Stack;
import java.util.ArrayDeque;
import java.util.Iterator;

public class AdvTree<T> implements Iterable<T> {
    @SuppressWarnings("unchecked")
    public AdvTree(T label, AdvTree<T>... children){
        _label = label;
        if (children == null){
            _children = null;
        } else {
            _children = new ArrayList<>(Arrays.asList(children));
        }
    }

    public int arity() { 
        if (_children == null) return 0;
        return _children.size(); 
    }

    public T label() { return _label; }

    public AdvTree<T> child(int k) { 
        if (_children == null) return null;
        if (k < 0 || k >= _children.size()) return null;
        return _children.get(k); }

    public static <T> void preorder(AdvTree<T> t, Consumer<AdvTree<T> > x){
        x.accept(t);
        for (int i = 0; i < t.arity(); i++){
            preorder(t.child(i), x);
        }
    }

    public static <T> void inorder(AdvTree<T> t, Consumer<AdvTree<T> > x){
        if (t == null) return;
        inorder(t.child(0), x);
        x.accept(t);
        inorder(t.child(1), x);
    }

    public static <T> void postorder(AdvTree<T> t, Consumer<AdvTree<T> > x){
        for (int i = 0; i < t.arity(); i++){
            postorder(t.child(i), x);
        }
        x.accept(t);
    }

    public static<T> void idfs(AdvTree<T> t, Consumer<AdvTree<T> > visit){
        Stack<AdvTree<T> > work = new Stack<>();
        work.push(t);
        while (!work.isEmpty()){
            AdvTree<T> node = work.pop();
            visit.accept(node);
            for (int i = node.arity() - 1; i >= 0; i--){
                work.push(node.child(i));
            }
        }
    }

    public static<T> void bfs(AdvTree<T> t, Consumer<AdvTree<T> > visit){
        ArrayDeque<AdvTree<T> > work = new ArrayDeque<>();
        work.push(t);
        while (!work.isEmpty()){
            AdvTree<T> node = work.removeFirst();
            if (node != null){
                visit.accept(node);
                for (int i = 0; i < node.arity(); i++){
                    work.addLast(node.child(i));
                }
            }
        }
    }

    public static<T> void iddfs(AdvTree<T> t, int level, Consumer<AdvTree<T> > visit){
        if (level == 0){
            visit.accept(t);
            return;
        }
        for (int i = 0; i < t.arity(); i++){
            iddfs(t.child(i), level - 1, visit);
        }
    }

    static class PreorderIterator<T> implements Iterator<T> {
        private Stack<AdvTree<T> > s = new Stack<AdvTree<T> >();
        public PreorderIterator(AdvTree<T> t) { s.push(t); }
        public boolean hasNext() { return !s.isEmpty(); }
        public T next(){
            AdvTree<T> result = s.pop();
            for (int i = result.arity() - 1; i >= 0; i--){
                s.push(result.child(i));
            }
            return result.label();
        }
    }

    @Override
    public Iterator<T> iterator(){
        return new PreorderIterator(this);
    }

    private T _label;
    private ArrayList<AdvTree<T> > _children;

    public static void main(String[] args){
        AdvTree<String> t11 = new AdvTree<String>("ji", (AdvTree<String>[]) null);
        AdvTree<String> t12 = new AdvTree<String>("an", (AdvTree<String>[]) null);
        AdvTree<String> t1 = new AdvTree<String>("jian", new AdvTree[]{t11, t12});

        AdvTree<String> t21 = new AdvTree<String>("zh", (AdvTree<String>[]) null);
        AdvTree<String> t22 = new AdvTree<String>("i", (AdvTree<String>[]) null);
        AdvTree<String> t2 = new AdvTree<String>("zhi", new AdvTree[]{t21, t22});
        AdvTree<String> t = new AdvTree<String>("jianzhi", new AdvTree[]{t1, t2});

        System.out.println("preorder");
        preorder(t, a -> System.out.println(a.label()));
        System.out.println();

        System.out.println("inorder");
        inorder(t, a -> System.out.println(a.label()));
        System.out.println();

        System.out.println("postorder");
        postorder(t, a -> System.out.println(a.label()));
        System.out.println();

        System.out.println("iterative dfs");
        idfs(t, a -> System.out.println(a.label()));
        System.out.println();

        System.out.println("bfs");
        bfs(t, a -> System.out.println(a.label()));
        System.out.println();

        System.out.println("iterative deepening dfs");
        System.out.println();
        for (int i = 0; i < 3; i++){
            System.out.println("level " + i);
            iddfs(t, i, a -> System.out.println(a.label()));
            System.out.println();
        }
        
        System.out.println("iterator");
        PreorderIterator<String> it = new PreorderIterator<>(t);
        for (; it.hasNext();){
            System.out.println(it.next());
        }
        System.out.println();

        System.out.println("iterable");
        for (String x : t){
            System.out.println(x);
        }

    }

}
