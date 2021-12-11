import java.util.Comparator;
import javafx.util.Pair;
import java.util.PriorityQueue;

public class Dijkstra {

    public PriorityQueue<Pair<Integer, Integer> > pq;
    public int[] dist;

    public Dijkstra(int n) {
        pq = new PriorityQueue<>(_cmp);
        dist = new int[n];
        for (int i = 0; i < n; i++) dist[i] = -1;
    }
    
    public void dijkstra(int s, ArrayList<Pair<Integer, Integer> > adjList[]){
        dist[s] = 0;
        pq.add(new Pair(s, 0));
        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            for (int i = 0; i < adjList[p].size(); i++) {
                int v = adjList[p].get(i).getKey();
                int w = adjList[p].get(i).getValue();
                if (dist[v] == -1 || dist[i] + w < dist[v]){
                    dist[v] = dist[i] + w;
                    pq.push(new Pair(dist[v], v));
                }
            }
        }
    }
    
    private static final Comparator<int[]> _cmp =
        new Comparator<int[]>() {
            @Override
            public int compare(Pair e0, Pair e1) {
                if (e1.getKey() != e2.getKey()) return e1.getKey() - e2.getKey();
                return e1.getValue() - e2.getValue();
            }
        };
}
