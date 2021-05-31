public class DisjointSet {
    
    private int[] p;
    private int[] rank;

    public DisjointSet(int N){
        p = new int[N];
        rank = new int[N];
        for (int i = 0; i < N; i++){
            p[i] = i;
            rank[i] = 1;
        }
    }

    public int parent(int x){
        if (p[x] == x) return x;
        return p[x] = parent(p[x]);
    }

    public boolean isSame(int x, int y){
        return parent(x) == parent(y);
    }

    public void merge(int x, int y){
        x = parent(x);
        y = parent(y);
        if (rank[x] < rank[y]){
            rank[y] += rank[x];
            p[x] = y;
        } else {
            rank[x] += rank[y];
            p[y] = x;
        }
    }

}
