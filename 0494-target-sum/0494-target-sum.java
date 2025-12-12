class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        return help(nums,target,0,sum);
    }
    public int help(int[] nums, int target, int i, int sum){
        if(i==nums.length) return (sum==target) ? 1 : 0;
        int take = help(nums,target,i+1,sum+nums[i]);
        int diff = help(nums,target,i+1,sum-nums[i]);
        return take+diff;
    }

}