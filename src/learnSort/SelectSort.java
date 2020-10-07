package learnSort;

public class SelectSort {
    public static void sort(Comparable[] a){
        for (int i = 0; i <= a.length-2; i++){
            //定义一个变量，记录最小元素所在的索引
            int minIndex = i;
            for (int j = i + 1; j <= a.length-1; j++){
                //比较最小索引处的值和j索引处的值
                if (greater(a[minIndex],a[j])){
                    minIndex=j;
                }
            }
            //交换值
            exch(a,i,minIndex);
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
