package dfs;

import java.util.*;

public class PermutationsDemo {
    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0){
            return res;
        }
        Deque<Integer> path = new ArrayDeque<Integer>(len);
        boolean[] used = new boolean[len];
        dfs(nums,len,0,res,used,path);
        return res;
    }

    private void dfs(int[] nums, int len, int depth, List<List<Integer>> res, boolean[] used, Deque<Integer> path) {
        if (len == depth){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < len; i++) {
            if (!used[i]){
                path.addLast(nums[i]);
                used[i]=true;
                dfs(nums, len, depth+1, res, used, path);
                used[i]=false;
                path.removeLast();
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        PermutationsDemo permutationsDemo = new PermutationsDemo();
        List<List<Integer>> lists = permutationsDemo.permute(nums);
        System.out.println(lists);
    }
}
