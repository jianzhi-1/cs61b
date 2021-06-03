import java.util.ArrayList;
import java.util.Iterator;

public class AdjList {

    private int v, e;
    private ArrayList<Integer>[] adjList;

    public AdjList(int V){
        v = V;
        e = 0;
        adjList = new ArrayList[V];
        for (int i = 0; i < V; i++){
            adjList[i] = new ArrayList<Integer>();
        }
    }

    public void addEdge(int v, int u){
        adjList[v].add(u);
        adjList[u].add(v);
        e++;
    }

    //returns an iterable object
    Iterable<Integer> adj(int v){
        //does this line work?
        return adjList[v];
    }

    //prints the number of edges
    public int E(){
        return e;
    }

    //returns the number of vertices
    public int V(){
        return v;
    }

    //prints out the edges
    public void printEdges(AdjList G){
        for (int v = 0; v < G.V(); v++){
            for (int w : G.adj(v)){
                System.out.println(v + "-" + w);
            }
        }
    }

}
