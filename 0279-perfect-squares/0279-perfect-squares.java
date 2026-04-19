class Solution {
    Integer [] dp;
    public int numSquares(int n) {
        dp = new Integer[n+1];
        return help(n);
    }
    private int help(int n){
        if(n==0) return 0;
        if(dp[n] != null)return dp[n];
        int minCount = Integer.MAX_VALUE;
        for(int i = 1; i*i <= n; i++){
            int curr = 1 + help(n - i*i);
            minCount = Math.min(minCount,curr);
        }
        return dp[n] = minCount;
    }

}