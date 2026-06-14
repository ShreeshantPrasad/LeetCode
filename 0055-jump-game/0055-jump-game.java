class Solution {
    Boolean [] dp;
    public boolean canJump(int[] nums) {
        dp = new Boolean[nums.length];
        return solve(nums,0);
    }
    private boolean solve(int[] nums, int i){
        if(i == nums.length - 1) return true;
        if(dp[i] != null) return dp[i];
        for(int j = 1; j <= nums[i]; j++){
            if(j < nums.length && solve(nums,i+j)){
                return true;
            }
        }
        return dp[i] = false;
    }
}