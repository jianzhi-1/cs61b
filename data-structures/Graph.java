public class Graph {

    private int size;

    public Graph(int V){

    }

    public void addEdge(int v, int u){

    }

    Iterable<Integer> adj(int v){
        return null;
    }

    public int E(){
        return 0;
    }

    public int V(){
        return size;
    }

    public void printEdges(Graph G){
        for (int v = 0; v < G.V(); v++){
            for (int w : G.adj(v)){
                System.out.println(v + "-" + w);
            }
        }
    }

}
