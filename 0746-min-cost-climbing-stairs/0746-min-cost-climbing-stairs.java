class Solution {
    Integer [] dp;
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        dp = new Integer[n];
        return Math.min(help(cost,n-1),help(cost,n-2));
        
    }
    private int help(int [] cost, int n){
        if(n < 0) return 0;
        if(n == 0 || n == 1 ) return cost[n];
        if(dp[n] != null) return dp[n];
        return dp[n] = cost[n] + Math.min(help(cost,n-1),help(cost,n-2));
    }

}