//MEOMRIZATION
class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        Integer [][] dp = new Integer[n][amount+1];
        int ans = solveRec(n-1, coins, amount,dp);
        return (ans >= (int)1e9 ) ? -1 : ans;
    }
    public int solveRec(int n, int [] coins, int amount, Integer [][] dp){
        if(amount == 0) return 0;
        if(n==0){
            if(amount % coins[0] == 0){
                return amount/coins[0];
            } 
            else return (int)1e9;
        }
        if(dp[n][amount] != null) return dp[n][amount];
        //Not take
        int notTake = solveRec(n-1,coins,amount,dp);
        //take
        int take = (int)1e9;
        if(coins[n]<=amount){
            take = 1 + solveRec(n,coins,amount-coins[n],dp);
        } 
        return dp[n][amount] = Math.min(take, notTake);
    }
}
// RECURSION
// class Solution {
//     public int coinChange(int[] coins, int amount) {
//         int n = coins.length;
//         int ans = solveRec(n-1, coins, amount);
//         return (ans >= (int)1e9 ) ? -1 : ans;
//     }
//     public int solveRec(int n, int [] coins, int amount){
//         if(amount == 0) return 0;
//         if(n==0){
//             if(amount % coins[0] == 0){
//                 return amount/coins[0];
//             } 
//             else return (int)1e9;
//         }
//         //Not take
//         int notTake = solveRec(n-1,coins,amount);
//         //take
//         int take = (int)1e9;
//         if(coins[n]<=amount){
//             take = 1 + solveRec(n,coins,amount-coins[n]);
//         } 
//         return Math.min(take, notTake);
//     }
// }