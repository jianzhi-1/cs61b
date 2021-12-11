import java.util.Arrays;
import java.util.Comparator;

public class Kruskal {

    public static int[][] mst(int V, int[][] E) {
        // E[i] in the form of [v1, v2, edge_weight]
        
        E = Arrays.copyOf(E, E.length);
        int[][] result = new int[V - 1][];
        Arrays.sort(E, _cmp);
        UnionFind ufds = new UnionFind(V);
      
        int c = 0;
        for (int i = 0; i < E.length; i++){
            if (ufds.samePartition(E[i][0], E[i][1])) continue;
            ufds.union(E[i][0], E[i][1]);
            result[c] = E[i];
            c += 1;
        }
        return result;
    }

    private static final Comparator<int[]> _cmp =
        new Comparator<int[]>() {
            @Override
            public int compare(int[] e0, int[] e1) {
                return e0[2] - e1[2];
            }
        };
}
