package learnSort;

public class QuickSort {

    private static boolean less(Comparable v,Comparable w){
        return v.compareTo(w)<0;
    }

    /**
     * 交换元素
     * @param a
     * @param i
     * @param j
     */
    private static void exch(Comparable[] a,int i,int j){
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    /**
     * 对数组排序
     * @param a
     */
    public static void sort(Comparable[] a){
        int lo = 0;
        int hi = a.length-1;
        sort(a,lo,hi);

    }

    /**
     * 对数组第lo到hi个元素进行排序
     * @param a
     * @param lo
     * @param hi
     */
    private static void sort(Comparable[] a,int lo,int hi){
        //安全性校验
        if (hi<=lo){
            return;
        }

        //对数组中lo索引到hi处索引进行分组(左子组和右子组)
        int partition = partition(a,lo,hi);//返回的是分组分解值
        //让左子组有序
        sort(a,lo,partition-1);
        //让右子组有序
        sort(a,partition+1,hi);

    }

    public static int partition(Comparable[] a,int lo,int hi){
        //确定分界值
        Comparable key = a[lo];
        //定义两个指针，分别指向待切分元素索引处和最大索引处的下一个位置
        int left = lo;
        int right = hi+1;
        //切分
        while (true){
            //从右往左扫描，移动right指针，找到一个比分界值小的元素
            while (less(key,a[--right])){
                if (right==lo){
                    break;
                }
            }
            //从左往右扫描，移动left指针，找到一个比分界值大的值
            while (less(a[++left],key)){
                if (left==hi){
                    break;
                }
            }
            //如果left>=right，结束循环
            if (left>=right){
                break;
            }else {
                exch(a,left,right);
            }
        }
        //交换分界值
        exch(a,lo,right);
        //返回分界值索引
        return right;
    }

}
