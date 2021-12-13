import java.util.ArrayList;
import javafx.util.Pair;

public class Topological {

    private int _n, _counter;
    private boolean[] _visited;
    private int[] _topo;

    public Topological(int n){
        _n = n;
        _visited = new boolean[n];
        _topo = new int[n];
    }
    
    public void dfs(int x, ArrayList<Pair<Integer, Integer> > adjList[]){
        if (_visited[x]) return;
        _visited[x] = true;
        for (int i = 0; i < adjList[x].size(); i++) {
            if (_visited[adjList[x][i]]) continue;
            dfs(adjList[x][i]);
        }
        _topo[_counter] = x;
        _counter += 1;
    }
    
    public void topological(ArrayList<Pair<Integer, Integer> > adjList[]){
        for (int i = 0; i < _n; i++){
            if (_visited[i]) continue;
            dfs(i);
        }
        //reverse array
        for (int i = 0; i < _n - 1 - i; i++){
            int temp = _topo[i];
            _topo[i] = _topo[_n - 1 - i];
            _topo[_n - 1 - i] = temp;
        }
    }
}
