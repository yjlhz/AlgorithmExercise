package LeetCodeExercise;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class divideDemo {
    private static int[] arrays = new int[]{1,0,-1,0,-2,2};

    public static void main(String[] args) {
        divideDemo di = new divideDemo();

        System.out.println(di.fourSum(arrays,0));
    }

    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        int sum = 0, t = 0;//第一层累加数
        int sums = 0, ts = 0;//第二层累加数
        int sumss = 0, tss = 0;//第三层累加数
        int res = 0;//结果
        int flat = (dividend ^ divisor);//结果正负标志位
        dividend = (dividend < 0) ? dividend : -dividend;//被除数取负值
        divisor = (divisor < 0) ? divisor : -divisor;//除数取负值
        while (dividend <= divisor) {//暴力累加法
            sum += divisor;
            t--;
            sums += sum;
            ts += t;
            sumss += sums;
            tss += ts;
            if (dividend - sumss < 0 && sumss < 0) {//判断三层累加是否超出
                res += tss;
                dividend -= sumss;
            } else {//超出则普通累加
                res--;
                dividend -= divisor;
                sum = 0;
                t = 0;
                sums = 0;
                ts = 0;
                sumss = 0;
                tss = 0;
            }
        }
        return (flat < 0) ? res : -res;
    }

    public boolean canJump(int[] nums) {
        if (nums[0] == 0 && nums.length > 1) {
            return false;
        }
        int count = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0) {
                count++;
                for (int j = 0; j < i; j++) {
                    if (nums[j] >= i - j + 1) {
                        count--;
                        break;
                    }
                }
            }
        }
        if (count == 0){
            return true;
        }else {
            return false;
        }
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        /*定义一个返回值*/
        List<List<Integer>> result=new ArrayList<>();
        /*当数组为null或元素小于4个时，直接返回*/
        if(nums==null||nums.length<4){
            return result;
        }
        /*对数组进行从小到大排序*/
        Arrays.sort(nums);
        /*数组长度*/
        int length=nums.length;
        /*定义4个指针k，i，j，h  k从0开始遍历，i从k+1开始遍历，留下j和h，j指向i+1，h指向数组最大值*/
        for(int k=0;k<length-3;k++){
            /*当k的值与前面的值相等时忽略*/
            if(k>0&&nums[k]==nums[k-1]){
                continue;
            }
            /*获取当前最小值，如果最小值比目标值大，说明后面越来越大的值根本没戏*/
            int min1=nums[k]+nums[k+1]+nums[k+2]+nums[k+3];
            if(min1>target){
                break;
            }
            /*获取当前最大值，如果最大值比目标值小，说明后面越来越小的值根本没戏，忽略*/
            int max1=nums[k]+nums[length-1]+nums[length-2]+nums[length-3];
            if(max1<target){
                continue;
            }
            /*第二层循环i，初始值指向k+1*/
            for(int i=k+1;i<length-2;i++){
                /*当i的值与前面的值相等时忽略*/
                if(i>k+1&&nums[i]==nums[i-1]){
                    continue;
                }
                /*定义指针j指向i+1*/
                int j=i+1;
                /*定义指针h指向数组末尾*/
                int h=length-1;
                /*获取当前最小值，如果最小值比目标值大，说明后面越来越大的值根本没戏，忽略*/
                int min=nums[k]+nums[i]+nums[j]+nums[j+1];
                if(min>target){
                    continue;
                }
                /*获取当前最大值，如果最大值比目标值小，说明后面越来越小的值根本没戏，忽略*/
                int max=nums[k]+nums[i]+nums[h]+nums[h-1];
                if(max<target){
                    continue;
                }
                /*开始j指针和h指针的表演，计算当前和，如果等于目标值，j++并去重，h--并去重，当当前和大              于目标值时h--，当当前和小于目标值时j++*/
                while (j<h){
                    int curr=nums[k]+nums[i]+nums[j]+nums[h];
                    if(curr==target){
                        result.add(Arrays.asList(nums[k],nums[i],nums[j],nums[h]));
                        j++;
                        while(j<h&&nums[j]==nums[j-1]){
                            j++;
                        }
                        h--;
                        while(j<h&&i<h&&nums[h]==nums[h+1]){
                            h--;
                        }
                    }else if(curr>target){
                        h--;
                    }else {
                        j++;
                    }
                }
            }
        }
        return result;

    }


}
