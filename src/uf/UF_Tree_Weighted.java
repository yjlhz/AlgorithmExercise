package uf;

public class UF_Tree_Weighted {
    //记录结点元素和该元素所在分组的标识
    private int[] eleAndGroup;
    //记录并查集中数据的分组个数
    private int count;
    //存储每一个根结点对应的树中保存的结点的个数
    private int[] sz;

    //初始化并查集
    public UF_Tree_Weighted(int N){
        //初始化分组的数量,默认情况下，有N个分组
        this.count = N;
        //初始化eleAndGroup数组
        this.eleAndGroup = new int[N];
        //初始化eleAndGroup中的元素及其所在的组的标识符,让eleAndGroup数组的索引作为并查集的每个结点的元素，并且让每个索引处的值(该元素所在的组的标识符)就是该索引
        for (int i = 0; i < eleAndGroup.length; i++) {
            eleAndGroup[i] = i;
        }
        //默认情况下，sz为1
        this.sz = new int[N];
        for (int i = 0; i < sz.length; i++) {
            sz[i] = 1;
        }
    }

    //获取当前并查集中的数据有多少个分组
    public int count(){
        return count;
    }

    //元素p所在分组的标识符
    public int find(int p){
       while (true){
           if (p == eleAndGroup[p]){
               return p;
           }

           p = eleAndGroup[p];
       }
    }

    //判断并查集中元素p和元素q是否在同一分组中
    public boolean connected(int p,int q){
        return find(p) == find(q);
    }

    //把p元素所在分组和q元素所在分组合并
    public void union(int p,int q){
        //找到p所在分组标识符
        int pRoot = find(p);
        //找到q所在分组标识符
        int qRoot = find(q);
        if (pRoot == qRoot){
            return;
        }
        if (sz[pRoot]<sz[qRoot]){
            eleAndGroup[pRoot] = qRoot;
            sz[qRoot]+=sz[pRoot];
        }else {
            eleAndGroup[qRoot] = pRoot;
            sz[pRoot]+=sz[qRoot];
        }


        this.count--;
    }

}
