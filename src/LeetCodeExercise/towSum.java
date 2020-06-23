package LeetCodeExercise;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和练习
 */
public class towSum {
    private static int[] nums1 = new int[] {4,5,9,6,3,2,8,-6,11,66,33,88,99,15,16,35,17,85,23};
    private static int target1 = 9;
    public static void main(String[] args){
        towSum text = new towSum();
        int[] textNums = text.towSum03(nums1,target1);
        if(textNums != null){
            System.out.println(textNums[0] + "," + textNums[1]);
        }else{
            System.out.println("没有找到目标值！");
        }

    }

    /**
     * 第一种解法 - 使用双重for循环遍历
     * @param nums 传入的数组
     * @param target 需要的目标值
     * @return
     */
    private int[] towSum01(int[] nums, int target){
        for (int i = 0; i < nums.length; i++){
            for (int j = i + 1;j < nums.length; j++){
                if(nums[j] == target - nums[i]){
                    return new int[] {i,j};
                }
            }
        }
        return null;
    }

    /**
     * 第二种解法 - 使用两遍哈希表
     * @param nums 传入的数组
     * @param target 需要的目标值
     * @return
     */
    private int[] towSum02(int[] nums, int target){
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++){
            int count = target - nums[i];
            if (map.containsKey(count) && map.get(count) != i){
                return new int[] {i,map.get(count)};
            }
        }
        return null;
    }

    /**
     * 第三种解法 - 一遍哈希表
     * @param nums 传入的数组
     * @param target 需要的目标值
     * @return
     */
    private int[] towSum03(int[] nums, int target){
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            int count = target - nums[i];
            if (map.containsKey(count)){
                return new int[] {map.get(count),i};
            }
            map.put(nums[i], i);
        }
        return null;

    }
}
