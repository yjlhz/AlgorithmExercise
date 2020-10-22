package graph;

import linear.Queue;

public class BreadthFirstSearch {
    //记录被搜索的点，索引代表顶点
    private boolean[] marked;
    //记录有多少个顶点与s顶点相通
    private int count;
    //存储待搜索邻接表的点
    private Queue<Integer> waitSearch;

    public BreadthFirstSearch(Graph G,int s){
        this.marked = new boolean[G.V()];
        this.count = 0;
        this.waitSearch = new Queue<Integer>();
        dfs(G,s);
    }

    private void dfs(Graph G,int v){
        //标识v为已搜索
        marked[v] = true;
        //让顶点v进入队列
        waitSearch.enqueue(v);
        count++;
        //循环弹出待搜索顶点
        while (!waitSearch.isEmpty()){
            //弹出待搜索顶点
            Integer wait = waitSearch.dequeue();
            //遍历wait顶点的邻接表
            for (Integer w : G.adj(wait)) {
                if (!marked[w]){
                    waitSearch.enqueue(w);
                    marked[w] = true;
                    count++;
                }
            }
        }

    }

    public boolean marked(int w){
        return marked[w];
    }

    public int count(){
        return count;
    }

}
