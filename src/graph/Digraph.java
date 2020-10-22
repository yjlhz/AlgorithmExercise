package graph;

import linear.Queue;

public class Digraph {
    //记录顶点个数
    private final int V;
    //记录边数量
    private int E;
    //邻接表
    private Queue<Integer>[] adj;

    public Digraph(int V){
        this.V = V;
        this.E = 0;
        this.adj = new Queue[V];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new Queue<Integer>();
        }
    }

    //获取顶点数量
    public int V(){
        return V;
    }

    //获取图中边的数量
    public int E(){
        return E;
    }

    public void addEdge(int v,int w){
        //让顶点w出现在v的邻接表中
        adj[v].enqueue(w);
        E++;
    }

    //获取顶点v指出的边所连接的所有顶点
    public Queue<Integer> adj(int v){
        return adj[v];
    }

    private Digraph reverse(){
        //创建有向图对象
        Digraph r = new Digraph(V);

        for (int v = 0; v < V; v++) {
            for (Integer w : adj[v]) {
                r.addEdge(w,v);
            }
        }

        return r;
    }

}
