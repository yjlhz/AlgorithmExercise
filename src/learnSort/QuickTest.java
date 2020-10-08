package learnSort;

import java.util.Arrays;

public class QuickTest {
    public static void main(String[] args) {
        Integer[] a = {8,4,5,7,1,3,6,2};
        QuickSort.sort(a);
        System.out.println(Arrays.toString(a));
    }
}
