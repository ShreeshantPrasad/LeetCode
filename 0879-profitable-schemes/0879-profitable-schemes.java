class Solution {
    final long MOD = 1_000_000_007;
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        Long [][][] dp = new Long[101][101][101];
        return (int) (helper(0, 0, 0, n, minProfit, group, profit,dp) % MOD);
        
    }
    private long helper(int i, int p, int people, int n, int minP, int[] group, int[] profit, Long [][][] dp){
        if(people > n) return 0L;
        if(i == group.length){
            if(p >= minP) return 1L;
            return 0L;
        } 
        if(dp[i][p][people] != null) return dp[i][p][people];
        long notTake = helper(i+1,p,people,n,minP,group,profit,dp)%MOD;
        long take = helper(i+1,Math.min(p+profit[i],minP),people+group[i],n,minP,group,profit,dp)%MOD;
    
        return dp[i][p][people] = (take + notTake)%MOD;
    }
}