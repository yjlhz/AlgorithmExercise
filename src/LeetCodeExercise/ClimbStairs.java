package LeetCodeExercise;

public class ClimbStairs {
    public static void main(String[] args) {
        System.out.println();
    }

    public int climbStairs(int n) {
        if (n == 1){
            return 1;
        }
        if (n == 2){
            return 2;
        }
        int p = 0,q = 1, r = 2;
        for (int i = 1;i < n;i++){
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }

}
