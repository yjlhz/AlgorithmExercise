package LeetCodeExercise;

public class ClimbStairs {
    public static void main(String[] args) {
        int[] num = {1,2,3,5};
        System.out.println(climbStairs(55));
        System.out.println(runningSum(num));

    }
    public static int climbStairs(int n) {
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


    public static int[] runningSum(int[] nums) {
        if (nums.length == 1){
            return nums;
        }
        for (int i = 1;i < nums.length;i++){
            nums[i] = nums[i-1] + nums[i];
        }
        return nums;
    }

}
