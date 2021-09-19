public class AdjList {

    int n;
    ArrayList<Pair<Integer, Integer> > [] adjList;
    // vertex, edge weight

    public AdjList(int nn){
        n = nn;
        adjList = new ArrayList<Pair<Integer, Integer> > [nn];
    }
    
    public static void main(String args[]){
        System.out.println("hi");
    }


    public class Dijkstra {

        public PriorityQueue<Pair<Integer, Integer> > pq;
        public int[] dist;

        public Dijkstra(int n) {
            pq = new PriorityQueue<>();
            dist = new int[n];
            for (int i = 0; i < n; i++){
                dist[i] = -1;
            }
        }
    
        public void begin(int s) {
            dist[s] = 0;
            pq.add(s, 0);
            while (!pq.isEmpty()) {
                p = pq.removeSmallest();
                relax(p);
            }
        }

        void relax(int p) {
            for (int i = 0; i < adjList[p].size(); i++) {
                int v = adjList[p].get(i).getKey();
                int w = adjList[p].get(i).getValue();
                if (dist[v] == -1 || dist[i] + w < dist[v]) {
                    dist[v] = dist[i] + w;
                    pq.push(new Pair(dist[v], v));
                }
            }
        }
    }
}
