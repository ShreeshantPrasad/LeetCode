class Solution {
    public int lengthOfLIS(int[] nums) {
        Integer[][] dp = new Integer[nums.length][nums.length+1];
        return solve(nums,0,-1,dp);
    }
    public int solve(int[] nums, int curr, int prev,Integer[][] dp){
        if(curr == nums.length) return 0;
        int take=0;
        if(dp[curr][prev+1] != null) return dp[curr][prev+1];
        if(prev==-1 || nums[curr]>nums[prev]){
            take = 1 + solve(nums,curr+1,curr,dp);
        }
        int notTake = solve(nums,curr+1,prev,dp);
        return dp[curr][prev+1] = Math.max(take,notTake);
    }
}