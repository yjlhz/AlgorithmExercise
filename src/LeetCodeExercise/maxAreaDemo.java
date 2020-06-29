package LeetCodeExercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class maxAreaDemo {
    private static int[] arrays = new int[] {1,2,3};
    public static void main(String[] args){
        maxAreaDemo ma = new maxAreaDemo();
        System.out.println(ma.plusOne(arrays));
    }

    public int maxArea(int[] height) {
        int maxarea = 0;
        for (int i = 0; i < height.length - 1;i++){
            for (int j = i + 1; j < height.length; j++){
                int currtarea = (j - i) * Math.min(height[i], height[j]);
                maxarea = Math.max(currtarea,maxarea);
            }
        }

        return maxarea;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        for(int i = 0; i < len; i++){
            if (i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            if (nums[i] > 0){
                break;
            }
            int mid = i + 1;
            int right = len - 1;
            int target = -nums[i];
            while (mid < right){
                if (nums[mid] + nums[right] > target){
                    right--;
                    continue;
                }
                if (nums[mid] + nums[right] < target){
                    mid++;
                    continue;
                }
                if (nums[mid] + nums[right] == target){
                    List<Integer> currentlist = new ArrayList<>();
                    currentlist.add(nums[i]);
                    currentlist.add(nums[mid]);
                    currentlist.add(nums[right]);
                    ans.add(currentlist);
                    mid++;
                    right--;
                    while (mid < right && nums[mid] == nums[mid - 1]) mid++;
                    while (mid < right && nums[right] == nums[right + 1]) right--;

                }
            }
        }
        return ans;
    }

    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) return digits;
        }
        int[] newdigits = new int[digits.length + 1];
        newdigits[0] = 1;
        return newdigits;
    }
}
