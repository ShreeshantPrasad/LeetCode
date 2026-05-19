class Solution {
    Integer [][] dp;
    public int lengthOfLIS(int[] nums) {
        dp = new Integer[nums.length+1][nums.length+1];
        return solve(-1,0,nums);
    }
    private int solve(int prev, int curr, int[] nums){
        if(curr >= nums.length) return 0;
        if(dp[prev+1][curr+1] != null) return dp[prev+1][curr+1];
        int take = 0;
        if(prev == -1 || nums[prev] < nums[curr]){
            take = 1 + solve(curr,curr+1,nums);
        }
        int notTake = solve(prev,curr+1,nums);
        return dp[prev+1][curr+1] = Math.max(take, notTake);
    }
}