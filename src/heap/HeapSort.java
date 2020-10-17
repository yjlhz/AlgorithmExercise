package heap;

public class HeapSort {
    //判断heap堆中i处元素是否小于j处元素
    private static boolean less(Comparable[] heap,int i,int j){
        return heap[i].compareTo(heap[j])<0;
    }

    //交换heap中i和j索引处的元素
    private static void exch(Comparable[] heap,int i, int j){
        Comparable tmp = heap[i];
        heap[i] = heap[j];
        heap[j] = tmp;
    }

    //根据source构造出heap数组
    private static void creatHeap(Comparable[] source,Comparable[] heap){
        //将source中的元素放到heap中，heap中形成一个无序的堆
        System.arraycopy(source,0,heap,1,source.length);
        //对堆中的元素做下沉调整（从1-length/2）
        for (int i = heap.length/2;i>0;i--){
            sink(heap,i,heap.length-1);
        }

    }

    //对source排序
    public static void sort(Comparable[] source){
        //构建堆
        Comparable[] heap = new Comparable[source.length + 1];
        creatHeap(source,heap);
        //定义一个变量记录未排序元素中最大索引
        int N = heap.length-1;
        //通过循环交换1索引处的元素和未排序元素的最大索引处的元素
        while (N!=1){
            //交换元素
            exch(heap,1,N);
            //排除交换后最大元素所在索引，不参与堆的下沉索引
            N--;
            //对索引1处的元素进行下沉调整
            sink(heap,1,N);
        }
        //把heap中的数据拷贝到source中
        System.arraycopy(heap,1,source,0,source.length);

    }

    //在heap堆中，对target处的元素进行下沉，范围是0-range
    private static void sink(Comparable[] heap,int target,int range){
        while (2*target<=range){
            //找出当前结点的较大子结点
            int max;
            if (2*target+1<=range){
                if (less(heap,2*target,2*target+1)){
                    max = 2*target+1;
                }else {
                    max = 2*target;
                }
            }else {
                max = 2*target;
            }
            //比较当前结点的值和较大子结点的值
            if (!less(heap,target,max)){
                break;
            }
            exch(heap,target,max);
            target=max;
        }
    }

}
