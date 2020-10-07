package learnSort;

public class MergeSort {
    //归并所需要的的辅助数组
    private static Comparable[] assist;

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
        //1、初始化辅助数组
        assist = new Comparable[a.length];
        //2、定义一个lo变量和一个hi变量，记录数组中的最小和最大索引
        int lo = 0;
        int hi = a.length-1;
        //3、调用sort重载方法完成数组a中索引lo到hi的排序
        sort(a,lo,hi);

    }

    /**
     * 对数组第lo到hi个元素进行排序
     * @param a
     * @param lo
     * @param hi
     */
    private static void sort(Comparable[] a,int lo,int hi){
        //做安全性校验
        if (hi<=lo){
            return;
        }
        //对lo到hi的数据分两组
        int mid = lo+(hi-lo)/2;
        //分别对每一组排序
        sort(a,lo,mid);
        sort(a,mid+1,hi);
        //对两个组归并
        merge(a,lo,mid,hi);

    }

    /**
     * 合并数组
     * @param a
     * @param lo
     * @param hi
     */
    private static void merge(Comparable[] a,int lo,int mid,int hi){
        //定义三个指针
        int i = lo;
        int p1 = lo;
        int p2 = mid+1;
        //遍历，移动p1和p2指针，比较索引处的值，找出较小值放到辅助数组
        while (p1<=mid && p2<=hi){
            //比较对应索引的值
            if (less(a[p1],a[p2])){
                assist[i++]=a[p1++];
            }else {
                assist[i++]=a[p2++];
            }
        }
        //如果p1指针没有走完那么顺序移动p1指针，将对应元素填充到辅助数组
        while(p1<=mid){
            assist[i++]=a[p1++];
        }
        //如果p1指针没有走完那么顺序移动p1指针，将对应元素填充到辅助数组
        while (p2<=hi){
            assist[i++]=a[p2++];
        }
        //把辅助数组的元素拷贝到原数组
        for (int index=lo;index<=hi;index++){
            a[index]=assist[index];
        }
    }


}
