package learnSort;

public class BubbleSort {
    /**
     * 对a数组排序
     * @param a
     */
    public static void sort(Comparable[] a){
        for (int i = a.length-1;i>0;i--){
            for (int j = 0;j<i;j++){
                //比较索引j和索引j+1处的值
                if (greater(a[j],a[j+1])){
                    exch(a,j,j+1);
                }
            }
        }
    }

    /**
     * 比较v,w的大小
     * @param v
     * @param w
     * @return
     */
    public static boolean greater(Comparable v,Comparable w){
        return v.compareTo(w)>0;
    }

    /**
     * 数组i，j交换位置
     * @param a
     * @param i
     * @param j
     */
    public static void exch(Comparable[] a,int i,int j){
        Comparable temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}
