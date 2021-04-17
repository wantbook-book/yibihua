public class Edge {
    public static boolean MARKED = true;
    public static boolean UNMARKED = false;

    public boolean state;
    private int v;
    private int w;

    public int either(){return v;}
    public int other(int h){
        if(h == v) return w;
        return v;
    }

    public Edge(int v, int w){
        this.v = v;
        this.w = w;
        state = UNMARKED;
    }

    @Override
    public String toString() {
        return "Edge{link "+v+" and "+w+ " "+state+"}";
    }
}
