package LeetCodeExercise;

import java.util.Arrays;

public class FlippingImage {
    public int[][] flipAndInvertImage(int[][] A) {
        for(int i = 0; i < A.length; i++){
            reverse(A[i]);
        }
        return A;
    }

    public void reverse(int[] row){
        int i = 0;
        int j = row.length - 1;
        while(i <= j){
            int tmp = row[i];
            row[i] = row[j] == 0 ? 1 : 0;
            row[j] = tmp == 0 ? 1 : 0;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        int[][] nums = {{1,1,0},{1,0,1},{0,0,0}};
        FlippingImage f = new FlippingImage();
        f.flipAndInvertImage(nums);
        System.out.println(Arrays.deepToString(nums));
    }

}
