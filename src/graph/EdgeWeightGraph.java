package graph;

import linear.Queue;

public class EdgeWeightGraph {
    private final int V;//记录顶点数量

    private int E;//记录边数量

    private Queue<Edge>[] adj;//领接表

    public EdgeWeightGraph(int v){
        this.V = v;
        this.E = 0;
        this.adj = new Queue[V];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new Queue<Edge>();
        }
    }

    //获取顶点数量
    public int V(){
        return V;
    }

    //获取边数量
    public int E(){
        return E;
    }

    //添加一条边
    public void addEdge(Edge e){
        int v = e.either();
        int w = e.other(v);
        adj[v].enqueue(e);
        adj[w].enqueue(e);
        E++;

    }

    //获取与顶点v关联的边
    public Queue<Edge> adj(int v){
        return adj[v];
    }

    //获取加权无向图的所有边
    public Queue<Edge> edges(){
        //存储所以的边
        Queue<Edge> addEdges = new Queue<>();
        //遍历每一个顶点，找到该顶点的领接表
        for (int v = 0; v < V;v++){
            //遍历v顶点的领接表，找到和v关联的边
            for (Edge e : adj[v]) {
                if (e.other(v)<v){
                    addEdges.enqueue(e);
                }

            }
        }
        return addEdges;

    }



}
