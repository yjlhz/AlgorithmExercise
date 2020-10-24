package graph;

public class Edge implements Comparable<Edge>{
    //顶点一
    private final int v;
    //顶点二
    private final int w;
    //当前边权重
    private final double weight;

    //构造
    public Edge(int v, int w,double weight){
        this.v=v;
        this.w=w;
        this.weight = weight;
    }

    //获取边权重
    public double weight(){
        return weight;
    }

    //获取边上一个点
    public int either(){
        return v;
    }

    //获取另外一个顶点
    public int other(int vertex){
        if (vertex == v){
            return w;
        }else {
            return v;
        }
    }


    @Override
    public int compareTo(Edge that) {
        int cmp;//记录比较结果,1表示当前边权重大，当前小则返回-1，相等则为0
        if (this.weight()>that.weight()){
            cmp=1;
        }else if (this.weight()<that.weight()){
            cmp=-1;
        }else {
            cmp=0;
        }
        return cmp;
    }
}
