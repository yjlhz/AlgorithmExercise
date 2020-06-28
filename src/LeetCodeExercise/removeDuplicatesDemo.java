package LeetCodeExercise;

import java.sql.Array;
import java.util.Arrays;

public class removeDuplicatesDemo {
    public static int[] nums1 = new int[] {1,3,5,6};
    public static void main(String[] args){
        removeDuplicatesDemo re = new removeDuplicatesDemo();
        System.out.println(re.searchInsert(nums1,5));
    }

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

    public int removeElement(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1, mid = (left + right) / 2;
        while(left<=right){
            if (nums[left] == target){
                return left;
            }
            if(nums[mid] >= target){
                right = mid - 1;
            }else {
                left = mid + 1;
            }
            mid = (left + right) / 2;
        }
        return left;
    }

}
