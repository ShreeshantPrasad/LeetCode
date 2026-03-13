class Solution {
    Integer [][] dp;
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        dp = new Integer[n][n+1];
        return helper(0, -1, nums, n);
    }
    private int helper(int curr, int prev,int [] nums, int n){
        if(curr == n) return 0;
        if(dp[curr][prev+1] != null) return dp[curr][prev+1];
        int len = 0 + helper(curr+1, prev, nums, n);
        if(prev == -1 || nums[curr] > nums[prev]){
            len = Math.max(len, 1 + helper(curr+1,curr,nums,n));
        }
        return dp[curr][prev+1] = len;
    }
}