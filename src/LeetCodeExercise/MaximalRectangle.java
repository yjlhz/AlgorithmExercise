package LeetCodeExercise;

public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        if (m == 0){
            return 0;
        }
        int n = matrix[0].length;
        int[][] left = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1'){
                    if (j == 0){
                        left[i][j] = 1;
                    }else {
                        left[i][j] = left[i][j-1]+1;
                    }
                }else {
                    left[i][j] = 0;
                }
            }
        }
        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++){
                if (left[i][j] == 0){
                    continue;
                }
                int width = left[i][j];
                int area = width;
                for (int k = i - 1; k >= 0; k--) {
                    if (left[k][j] == 0) {
                        break;
                    }else {
                        width = Math.min(width,left[k][j]);
                        area = Math.max(area,width*(i-k+1));
                    }
                }
                result = Math.max(area,result);
            }
        }
        return result;
    }
}
