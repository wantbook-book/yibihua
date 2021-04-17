import java.io.FileNotFoundException;
import java.security.interfaces.EdECKey;

public class Yibihua {
    private Stack<Edge>[] edgeTo;
    private Graph G;
    private boolean flag;
    private Stack<DirectedEdge> path;
    public Yibihua(Graph G){
        this.G = G;
        path = new Stack<>();
        edgeTo = new Stack[G.V() + 1];
        for(int v=1; v<=G.V(); v++){
            edgeTo[v] = new Stack<>();
        }
        for(int v=13; v<=G.V(); v++){
            draw(G, v);
        }
    }

    private void draw(Graph G, int v){
        for(Edge e: G.adj(v)){
            if (e.state != Edge.MARKED){
                e.state = Edge.MARKED;
                edgeTo[e.other(v)].push(e);
                draw(G, e.other(v));
                //若完成了，则原路返回，将经过的边加入path中
                if(flag){
                    DirectedEdge de = new DirectedEdge();
                    de.from = v;
                    de.to = e.other(v);
                    path.push(de);
                    return;
                }
            }
        }
        //到达最后一个点的时候， 检查是否完成了
        checkSuccess();
        if(!flag){
            //若未完成
            Edge edge;
            //恢复这个点最近通过的边
            if((edge = edgeTo[v].pop()) != null) edge.state = Edge.UNMARKED;
        }
    }

    private void checkSuccess(){
        for (int v=1; v<=G.V(); v++){
            for (Edge e: G.adj(v)){
                if(e.state != Edge.MARKED) {
                    return;
                }
            }
        }
        //若完成了，将flag置为true
        flag = true;
    }
    public Iterable<DirectedEdge> path(){return path;}


    public static void main(String[] args) throws FileNotFoundException {
        long start = System.currentTimeMillis();
        In in = new In("D:/testFile/IDEAjava/yibihua/src/test.txt");
        Graph G = new Graph(in);
        //System.out.println("heloo");
        Yibihua yibihua = new Yibihua(G);
        System.out.println(yibihua.flag);
        //System.out.println("hello");
        for(DirectedEdge de: yibihua.path()){
            System.out.println("from "+de.from+" to "+de.to+"");
        }
        long end = System.currentTimeMillis();
        System.out.println("it spent "+(end-start));
    }
}
