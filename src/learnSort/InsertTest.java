package learnSort;

import java.util.Arrays;

public class InsertTest {
    public static void main(String[] args) {
        Integer[] arr = {4,5,6,3,2,1,9,8,55,66,33};
        InsertSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
