package LeetCodeExercise;

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        int ans = 0, maxAns = nums[0];
        for(int i = 0;i<len;i++){
            ans = Math.max(ans+nums[i],nums[i]);
            maxAns = Math.max(ans,maxAns);
        }
        return maxAns;
    }
}
