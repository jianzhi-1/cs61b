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

vector<int> adjList[N], topo;
bool visited[N];

void dfs (int x) {
    if (visited[x]) return;
    visited[x] = 1;
    for (vector<int>::iterator it = adjList[x].begin(); it != adjList[x].end(); ++it) {
        if (visited[*it]) continue;
        dfs(*it);
    }
    topo.push_back(x);
}

/* Usage */
topo.clear();
memset(visited, 0, sizeof(visited)); 
for (int i = 0; i < N; ++i) {
    if (visited[i]) continue;
    dfs(i);
}
reverse(topo.begin(), topo.end()); //to get the correct topological order
