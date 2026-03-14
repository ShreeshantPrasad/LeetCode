class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        int n = nums.length;
        for(int i : nums) sum += i;
        if(sum % 2 != 0) return false ;
        int target = sum/2;
        Boolean [][] dp = new Boolean[n][target+1];
        return helper(n-1,nums,target,dp);
    }
    public boolean helper(int n,int[] nums, int target, Boolean[][] dp){
        if(target==0) return true;
        if(n==0) return nums[0] == target;
        if(dp[n][target] != null)return dp[n][target];
        boolean notTake = helper(n-1,nums,target,dp);
        boolean take = false;
        if(nums[n] <= target){
            take = helper(n-1,nums, target - nums[n], dp);
        }
        return dp[n][target] = take || notTake;
    }
}

// class Solution {
//     public boolean canPartition(int[] nums) {
//         int sum = 0;
//         for(int i : nums) sum += i;
//         return (sum % 2 != 0) ? false : help(nums,sum/2,0,0);
//     }
//     public boolean help(int [] nums, int target, int i,int sum){
//         int n = nums.length;
//         if(target==sum){
//             return true;
//         }
//         if(sum>target){
//             return false;
//         }
//         if(i==n-1){
//             return false;
//         }
//         //take
//         boolean take = help(nums,target,i+1,sum+nums[i]);
//         //notTake
//         boolean notTake = help(nums,target,i+1,sum);

//         return take || notTake;
//     }
// }