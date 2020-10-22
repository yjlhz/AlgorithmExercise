package graph;

import linear.Stack;

public class DepthFirstPaths {
    //索引代表顶点，值代表是否已被搜索
    private boolean[] marked;
    //起点
    private int s;
    //索引代表顶点，值代表从起点s到当前顶点路径上的最后一个顶点
    private int[] edgeTo;

    public DepthFirstPaths(Graph g,int s){
        this.marked = new boolean[g.V()];
        this.s = s;
        this.edgeTo = new int[g.V()];
        dfs(g,s);
    }

    private void dfs(Graph G,int v){
        //把v标识为已搜索
        marked[v] = true;
        //遍历v的邻接表
        for (Integer w : G.adj(v)) {
            //如果没被搜索，则递归搜索
            if (!marked[w]){
                edgeTo[w] = v;//到达w的最后一个顶点是v
                dfs(G,w);
            }
        }

    }

    public boolean hasPathTo(int v){
        return marked[v];
    }

    //s到v的路径
    public Stack<Integer> pathTo(int v){
        if (!hasPathTo(v)){
            return null;
        }
        //创建栈对象，保存路径中的所有顶点
        Stack<Integer> path = new Stack<>();
        //循环，从v开始，一直往前找
        for (int x = v; x != s; x = edgeTo[x]) {
            path.push(x);
        }
        //将起点放入
        path.push(s);
        return path;
    }

}
