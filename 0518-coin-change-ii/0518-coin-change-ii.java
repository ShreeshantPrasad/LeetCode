class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        Integer [][] dp = new Integer[n][amount+1];
        return solveRec(n-1, coins, amount,dp);
    }
    public int solveRec(int n, int [] coins, int amount, Integer [][] dp){
        if(n==0){
            if(amount % coins[0] == 0){
                return 1;
            } 
            else return 0;
        }
        if(dp[n][amount] != null) return dp[n][amount];
        //Not take
        int notTake = solveRec(n-1,coins,amount,dp);
        //take
        int take = 0;
        if(coins[n]<=amount){
            take = solveRec(n,coins,amount-coins[n],dp);
        } 
        return dp[n][amount] = take + notTake;
    }
}