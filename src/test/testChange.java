package test;

import java.util.Arrays;

public class testChange {
    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;
        coinChange(coins,amount);
    }
    public static int coinChange(int[] coins, int amount) {
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
