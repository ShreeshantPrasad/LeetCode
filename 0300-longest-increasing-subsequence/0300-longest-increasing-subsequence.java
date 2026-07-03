class Solution {
    Integer [][] dp;
    public int lengthOfLIS(int[] nums) {
        dp = new Integer[nums.length +1][nums.length +1];
        return solve(nums,0,-1);
    }
    private int solve(int[] nums, int i, int prev){
        if(i >= nums.length) return 0;
        if(dp[i][prev+1] != null)return dp[i][prev+1];
        int take = 0;

        if( prev == -1 || nums[i] > nums[prev]){
            take = 1 + solve(nums, i+1, i);
        }
        int notTake = solve(nums,i+1,prev);
        return dp[i][prev+1] = Math.max(take,notTake);
    }
}