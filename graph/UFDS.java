
public class UFDS {

    public UFDS(int N) {
        p = new int[N];
        sz = new int[N];
        for (int i = 0; i < N; i++){
            p[i] = i;
            sz[i] = 1;
        }
    }

    // with path compression
    public int parent(int v) {
        if (p[v] == v) return v;
        return p[v] = parent(p[v]);
    }

    public boolean sameParent(int u, int v) {
        return parent(u) == parent(v);
    }

    public int merge(int u, int v) {
        int pu = parent(u);
        int pv = parent(v);
        if (pu == pv) {
            return pu;
        }
        int res;
        if (sz[pu] > sz[pv]) {
            p[pv] = pu;
            sz[pu] += sz[pv];
            return pu;
        } else {
            p[pu] = pv;
            sz[pv] += sz[pu];
            return pv;
        }
    }

    private int[] p, sz;
}
