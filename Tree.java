import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Consumer;

public class Tree<Label> {
    @SuppressWarnings("unchecked")
    public Tree(Label label, Tree<Label>... children){
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

    public Tree<Label> child(int k) { 
        if (_children == null) return null;
        if (k < 0 || k >= _children.size()) return null;
        return _children.get(k); }

    public static <Label> void preorder(Tree<Label> T, Consumer<Tree<Label> > x){
        x.accept(T);
        for (int i = 0; i < T.arity(); i++){
            preorder(T.child(i), x);
        }
    }

    public static <Label> void inorder(Tree<Label> T, Consumer<Tree<Label> > x){
        if (T == null) return;
        inorder(T.child(0), x);
        x.accept(T);
        inorder(T.child(1), x);
    }

    public static <Label> void postorder(Tree<Label> T, Consumer<Tree<Label> > x){
        for (int i = 0; i < T.arity(); i++){
            postorder(T.child(i), x);
        }
        x.accept(T);
    }

    private Label _label;
    private ArrayList<Tree<Label> > _children;

    public static void main(String[] args){
        Tree<String> t11 = new Tree<String>("ji", (Tree<String>[]) null);
        Tree<String> t12 = new Tree<String>("an", (Tree<String>[]) null);
        Tree<String> t1 = new Tree<String>("jian", new Tree[]{t11, t12});

        Tree<String> t21 = new Tree<String>("zh", (Tree<String>[]) null);
        Tree<String> t22 = new Tree<String>("i", (Tree<String>[]) null);
        Tree<String> t2 = new Tree<String>("zhi", new Tree[]{t21, t22});
        Tree<String> t = new Tree<String>("jianzhi", new Tree[]{t1, t2});

        System.out.println("preorder");
        preorder(t, a -> System.out.println(a.label()));
        System.out.println();

        System.out.println("inorder");
        inorder(t, a -> System.out.println(a.label()));
        System.out.println();

        System.out.println("postorder");
        postorder(t, a -> System.out.println(a.label()));
        System.out.println();

    }

}
