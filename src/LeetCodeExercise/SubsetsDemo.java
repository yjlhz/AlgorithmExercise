package LeetCodeExercise;

import java.util.ArrayList;
import java.util.List;

public class SubsetsDemo {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> combine = new ArrayList<>();
        dfs(0,nums,ans,combine);
        return ans;
    }

    private void dfs(int count, int[] nums, List<List<Integer>> ans, List<Integer> combine) {
        if (count == nums.length){
            ans.add(new ArrayList<>(combine));
            return;
        }
        combine.add(nums[count]);
        dfs(count+1, nums, ans, combine);
        combine.remove(combine.size()-1);
        dfs(count+1, nums, ans, combine);
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        SubsetsDemo subsetsDemo = new SubsetsDemo();
        List<List<Integer>> subsets = subsetsDemo.subsets(nums);
        System.out.println(subsets);

    }
}
