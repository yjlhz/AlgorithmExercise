package learnSort;

import java.util.Arrays;

public class MergeTest {
    public static void main(String[] args) {
        Integer[] a = {8,4,5,7,1,3,6,2};
        MergeSort.sort(a);
        System.out.println(Arrays.toString(a));
    }
}
