package learnSort;

public class InsertSort {
    /**
     * 对a数组排序
     * @param a
     */
    public static void sort(Comparable[] a){
        for (int i = 1; i < a.length; i++){
            for (int j = i; j > 0; j--){
                //比较索引j和j-1的值
                if (greater(a[j-1],a[j])){
                    exch(a,j-1,j);
                }else {
                    break;
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
