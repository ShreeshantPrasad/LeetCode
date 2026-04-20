class Solution {
    Integer[][] dp;
    public int maxProfit(int[] prices) {
        dp = new Integer[5001][2];
        return solve(prices, 0, prices.length, true);
    }
    private int solve(int [] prices, int day, int n, boolean buy){
        if(day >= n)return 0;
        int x = (buy) ? 1 : 0;
        if(dp[day][x] != null) return dp[day][x];
        int profit = 0;
        if(buy){
            int take = solve(prices,day+1,n,false) - prices[day];
            int notTake = solve(prices,day+1,n,true);
            profit = Math.max(profit,Math.max(take,notTake));
        }
        else{
            int sell = prices[day] + solve(prices,day+2,n,true);
            int notSell = solve(prices, day+1, n, false);
            profit = Math.max(profit, Math.max(sell,notSell));
        }
        return dp[day][x] = profit;
    }
}