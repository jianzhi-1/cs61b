import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.Stack;
import java.util.ArrayDeque;
import java.util.Iterator;

public class AdvTree<Label> implements Iterable<Label> {
    @SuppressWarnings("unchecked")
    public AdvTree(Label label, AdvTree<Label>... children){
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

    public Label label() { return _label; }

    public AdvTree<Label> child(int k) { 
        if (_children == null) return null;
        if (k < 0 || k >= _children.size()) return null;
        return _children.get(k); }

    public static <Label> void preorder(AdvTree<Label> T, Consumer<AdvTree<Label> > x){
        x.accept(T);
        for (int i = 0; i < T.arity(); i++){
            preorder(T.child(i), x);
        }
    }

    public static <Label> void inorder(AdvTree<Label> T, Consumer<AdvTree<Label> > x){
        if (T == null) return;
        inorder(T.child(0), x);
        x.accept(T);
        inorder(T.child(1), x);
    }

    public static <Label> void postorder(AdvTree<Label> T, Consumer<AdvTree<Label> > x){
        for (int i = 0; i < T.arity(); i++){
            postorder(T.child(i), x);
        }
        x.accept(T);
    }

    public static<Label> void idfs(AdvTree<Label> T, Consumer<AdvTree<Label> > visit){
        Stack<AdvTree<Label> > work = new Stack<>();
        work.push(T);
        while (!work.isEmpty()){
            AdvTree<Label> node = work.pop();
            visit.accept(node);
            for (int i = node.arity() - 1; i >= 0; i--){
                work.push(node.child(i));
            }
        }
    }

    public static<Label> void bfs(AdvTree<Label> T, Consumer<AdvTree<Label> > visit){
        ArrayDeque<AdvTree<Label> > work = new ArrayDeque<>();
        work.push(T);
        while (!work.isEmpty()){
            AdvTree<Label> node = work.removeFirst();
            if (node != null){
                visit.accept(node);
                for (int i = 0; i < node.arity(); i++){
                    work.addLast(node.child(i));
                }
            }
        }

    }

    public static<Label> void iddfs(AdvTree<Label> T, int level, Consumer<AdvTree<Label> > visit){
        if (level == 0){
            visit.accept(T);
            return;
        }
        for (int i = 0; i < T.arity(); i++){
            iddfs(T.child(i), level - 1, visit);
        }
    }

    static class PreorderIterator<Label> implements Iterator<Label> {
        private Stack<AdvTree<Label> > s = new Stack<AdvTree<Label> >();
        public PreorderIterator(AdvTree<Label> T) { s.push(T); }
        public boolean hasNext() { return !s.isEmpty(); }
        public Label next(){
            AdvTree<Label> result = s.pop();
            for (int i = result.arity() - 1; i >= 0; i--){
                s.push(result.child(i));
            }
            return result.label();
        }
    }

    @Override
    public Iterator<Label> iterator(){
        return new PreorderIterator(this);
    }

    private Label _label;
    private ArrayList<AdvTree<Label> > _children;

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
