class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        Integer [] dp = new Integer[n];
        return help(n-1,nums,dp);
    }
    private int help(int idx, int [] nums, Integer [] dp){
        if(idx == 0) return nums[idx];
        if(idx < 0 ) return 0;
        if(dp[idx] != null) return dp[idx];
        int pick = nums[idx] + help(idx-2,nums,dp);
        int notpick = help(idx-1,nums,dp);
        return dp[idx] = Math.max(pick,notpick);
    }
}