package learnSort;

import java.util.Arrays;

public class ShellSort {
    /**
     * 对a数组排序
     * @param a
     */
    public static void sort(Comparable[] a){
        //根据数组a的长度，确定增长量h的初始值
        int h = 1;
        while (h<a.length/2){
            h=2*h+1;
        }
        //当h>=1时进行排序
        while (h>=1){
            //排序
            //找待插入元素
            for (int i = h; i < a.length; i++){
                for (int j = i;j >= h;j-=h){
                    //比较a[j]和a[j-h]
                    if (greater(a[j-h],a[j])){
                        //若大于，交换
                        exch(a,j,j-h);
                    }else {
                        //若小于，则找到位置
                        break;
                    }
                }
            }
            //减小h的值，h/2
            h=h/2;
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
