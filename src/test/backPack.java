package test;

import java.util.Arrays;
import java.util.List;

public class backPack {
    //题目描述
    //给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，
    //判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
    //说明：
    //拆分时可以重复使用字典中的单词。
    //你可以假设字典中没有重复的单词。

    //示例 1：
    //输入: s = "leetcode", wordDict = ["leet", "code"]
    //输出: true
    //解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
    public boolean wordBreak(String s, List<String> wordDict) {
        int l=s.length();
        //该问题可以理解为使用wordDict中的单词去组成目标s
        //这样的话问题就转化为了背包问题，数组为wordDict，target为s
        //题目说字典中的单词可以重复使用，因此为完全背包问题
        //同时，顺序不同，组成的单词不同，因此是需要考虑顺序的背包问题
        //此时套用第三种类型解题思路
        boolean[] dp=new boolean[l+1];
        dp[0]=true;//空字符串肯定可以组成，所以为true
        for(int i=1;i<=l;i++){//外层循环放target
            for(int j=i-1;j>=0;j--){
                //内层循环放数组，这里使用List查找也是一样的道理
                if(dp[j] && wordDict.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[l];
    }

    //题目描述
    //给定不同面额的硬币和一个总金额。
    //写出函数来计算可以凑成总金额的硬币组合数。假设每一种面额的硬币有无限个。
    //示例 1:
    //输入: amount = 5, coins = [1, 2, 5]
    //输出: 4
    //解释: 有四种方式可以凑成总金额:
    //5=5
    //5=2+2+1
    //5=2+1+1+1
    //5=1+1+1+1+1
    public int change(int amount, int[] coins) {
        //根据题目可以知道，此题不考虑顺序问题
        //数字可以重复使用，所以套用第二种类型
        int[] dp = new int[amount + 1];
        //动态方程边界问题：
        //只要一个不选，就可以凑成0元，因此有一种
        dp[0] = 1;
        //nums放外循环
        for (int coin : coins) {
            //target放内循环
            for (int x = coin; x <= amount; ++x) {
                dp[x] += dp[x - coin];
            }
        }
        return dp[amount];
    }

    //题目描述
    //给你一个由 不同 整数组成的数组 nums ，和一个目标整数 target 。
    //请你从 nums 中找出并返回总和为 target 的元素组合的个数。
    //题目数据保证答案符合 32 位整数范围。
    //示例 1：
    //输入：nums = [1,2,3], target = 4
    //输出：7
    //解释：
    //所有可能的组合为：
    //(1, 1, 1, 1)
    //(1, 1, 2)
    //(1, 2, 1)
    //(1, 3)
    //(2, 1, 1)
    //(2, 2)
    //(3, 1)
    //请注意，顺序不同的序列被视作不同的组合。
    public int combinationSum4(int[] nums, int target) {
        //典型的背包问题，题目描述说需要考虑顺序，并且元素可以复用
        //套用第三种类型的思路
        int[] dp = new int[target + 1];
        //dp[i]记录的是组成和为i的组合的数量
        //动态规划的边界条件确定：
        //组成和为0的数，只要不选nums里的任何数，就可以组成和为0的数，因此有一种
        dp[0] = 1;
        //外层循环放target
        for (int i = 1; i <= target; i++) {
            //内层循环放nums
            for (int num : nums) {
                if (num <= i) {
                    //对动态转移方程的理解：
                    //当i>num时，组成和为i的组合数量等于所有组成和为i-num的组合数的总和
                    dp[i] += dp[i - num];
                }
            }
        }
        //最终返回组成和为target的组合的数量
        return dp[target];
    }

    //题目描述
    //给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。
    // 对于数组中的任意一个整数，你都可以从 + 或 -中选择一个符号添加在前面。
    //返回可以使最终数组和为目标数 S 的所有添加符号的方法数。
    //示例：
    //输入：nums: [1, 1, 1, 1, 1], S: 3
    //输出：5
    //解释：
    //-1+1+1+1+1 = 3
    //+1-1+1+1+1 = 3
    //+1+1-1+1+1 = 3
    //+1+1+1-1+1 = 3
    //+1+1+1+1-1 = 3
    //一共有5种方法让最终目标和为3。
    public int findTargetSumWays(int[] nums, int S) {
        //背包问题是选或者不选，但本题是必须选，
        //主要考虑是选 ' + ' 还是选 ' - '。
        //背包模板：即数组中的元素不可重复使用，nums 放在外循环，
        //target 在内循环，且内循环倒序。
        int n = nums.length;
        int sum = 0;
        for (int i=0;i<n;i++) {
            sum += nums[i];
        }
        if(S > sum || (S + sum) % 2 == 1) return 0;
        //假设所有符号为 " + " 的元素和为 x，符号为 " - " 的元素和的绝对值是 y。
        //我们想要的 S = 正数和 - 负数和 = x - y，而已知 x 与 y 的和是数组总和：x + y = sum
        //   S = x - y
        // sum = x + y
        //将上面两式相加
        //可以求出 x = (S + sum) / 2 = target 也就是我们要从 nums 数组里选出几个数，令其和为 target。
        //因为只要找出正数和是多少，那么剩下的数字全为负数，就可以凑出目标和
        //所以我们只需要关注正数和的组合数量是多少，即可得到答案
        int target = (S + sum) / 2;
        int[] dp = new int[target + 1];
        dp[0] = 1;
        //外层循环放nums
        for (int i=0;i<n;i++){
            //内层循环放target
            for (int j=target;j>=nums[i];j--) {
                dp[j] = dp[j] + dp[j - nums[i]];
            }
        }
        //返回目标和为target的组合数量
        return dp[target];
    }

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp,amount+12);
        dp[0] = 1;
        for(int num : coins){
            for(int i = 1;i<=amount;i++){
                if(i>=num){
                    dp[i] = Math.min(dp[i],dp[i-num]+1);
                }
            }
        }
        if(dp[amount]==amount+12){
            return -1;
        }else{
            return dp[amount];
        }
    }

}
