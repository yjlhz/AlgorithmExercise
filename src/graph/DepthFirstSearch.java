package graph;

public class DepthFirstSearch {
    //索引代表顶点，值代表是否已被搜索
    private boolean[] marked;
    //记录右多少个顶点与s相通
    private int count;

    public DepthFirstSearch(Graph G,int s){
        //初始化marked数组
        this.marked = new boolean[G.V()];
        //初始化跟顶点s相通的顶点数量
        this.count = 0;
        dfs(G,s);
    }

    //找出G图中与v顶点相通的顶点
    private void dfs(Graph G,int v){
        //标记v
        marked[v] = true;
        for (Integer w : G.adj(v)) {
            //判断当前w有没有被搜索过，若没有，递归调用搜索
            if (!marked[w]){
                dfs(G,w);
            }
        }
        //相通顶点数量+1
        count++;

    }

    public boolean marked(int w){
        return marked[w];
    }

    public int count(){
        return count;
    }

}
