package learnSort;

import java.util.Arrays;

public class ShellTest {
    public static void main(String[] args) {
        Integer[] arr = {4,5,6,3,2,1};
        ShellSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
