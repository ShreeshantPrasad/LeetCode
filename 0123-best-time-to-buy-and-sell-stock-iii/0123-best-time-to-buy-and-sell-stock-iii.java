class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[][][] dp = new int[n][2][3];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        return solve(0,1,2,prices,n, dp);
    }
    public int solve(int idx, int buy, int cap, int[] prices, int n,int[][][] dp){
        if(idx==n || cap==0) return 0;
        if (dp[idx][buy][cap] != -1) return dp[idx][buy][cap];
        int profit = 0;
        if(buy == 1){
            profit =  Math.max(-prices[idx] + solve(idx+1, 0, cap, prices, n, dp), 0 + solve(idx+1 ,1 ,cap, prices, n, dp));
        }
        if(buy == 0){
            profit =  Math.max(prices[idx] + solve(idx+1, 1, cap-1, prices, n, dp), 0 + solve(idx+1 ,0 ,cap, prices, n, dp));
        }
        return dp[idx][buy][cap] = profit;
    }
}