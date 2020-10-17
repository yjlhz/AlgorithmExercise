package heap;

public class Heap<T extends Comparable<T>> {
    //存储堆中的元素
    private T[] items;
    //记录个数
    private int N;

    public Heap(int capacity) {
        items = (T[]) new Comparable[capacity+1];
        N = 0;
    }

    //判断堆中索引i处的元素是否小于j处的元素
    private boolean less(int i,int j){
        return items[i].compareTo(items[j])<0;
    }

    //交换i和j处的元素
    private void exch(int i,int j){
        T temp = items[i];
        items[i] = items[j];
        items[j] = temp;
    }

    //往堆中插入元素
    public void insert(T t){
        items[++N] = t;
        swim(N);
    }

    //上浮算法
    private void swim(int k){
        //通过循环比较当前结点和父结点的值，若父结点的值比当前结点的值小，则交换
        while (k>1){
            //比较当前结点和其父结点
            if (less(k/2,k)){
                exch(k/2,k);
            }
            k=k/2;
        }
    }
    //删除堆中最大元素，并返回值
    public T delMax(){
        T max = items[1];
        //交换索引1和最大索引处的值
        exch(1,N);
        //删除最大索引处的元素
        items[N] = null;
        //让元素个数-1
        N--;
        //让堆有序
        sink(1);
        return max;
    }

    //下沉算法
    private void sink(int k){
        //循环对比当前k结点和其子结点2k和2k+1的元素，如果当前结点小，则交换
        while (2*k<=N){
            //获取当前结点的子结点中的较大结点
            int max=k;//记录较大结点所在索引
            if (2*k+1<=N){
                if (less(2*k,2*k+1)){
                    max=2*k+1;
                }else {
                    max=2*k;
                }
            }
            //比较当前结点和较大结点的值
            if (!less(k,max)){
                break;
            }

            //交换
            exch(k,max);

            //变换k
            k=max;

        }
    }

}
