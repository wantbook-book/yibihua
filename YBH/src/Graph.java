import java.util.Iterator;

public class Graph {
    private int V;
    private int E;
    private Bag<Edge>[] adj;
    public Graph(int V){
        this.V = V;
        this.E = 0;
        adj = new Bag[V+1];
        for(int v=1;v<=V;v++){
            adj[v] = new Bag<>();
        }
    }
    public Graph(In in){
        this(in.readInt());
        while(!in.isEmpty()){
            int v = in.readInt(), w = in.readInt();
            Edge e = new Edge(v, w);
            addEdge(e);
        }

    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public void addEdge(Edge e){
        int v = e.either(), w = e.other(v);
        adj[v].add(e);
        adj[w].add(e);
    }

    public Iterable<Edge> adj(int v){
        return adj[v];
    }
}
