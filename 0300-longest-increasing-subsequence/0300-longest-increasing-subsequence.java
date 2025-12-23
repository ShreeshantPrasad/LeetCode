class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int[] dp=new int[n];
        Arrays.fill(dp,1);
        int ans=1;
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    dp[i]=Math.max(dp[i],1+dp[j]);
                }
            }
            ans=Math.max(ans,dp[i]);
        }
        return ans;
        
    }

    // public int lengthOfLIS(int[] nums) {
    //     Integer[][] dp = new Integer[nums.length][nums.length+1];
    //     return solve(nums,0,-1,dp);
    // //     // int n = nums.length;
    // //     // int maxx = 1;
        
    // //     // for (int i = 0; i < n; i++) {
    // //     //     int curr = 1;
    // //     //     int prev = i;
    // //     //     for (int j = i ; j < n; j++) {
    // //     //         if (nums[j] > nums[prev]) {
    // //     //             prev = j;
    // //     //             curr++;
    // //     //         }
    // //     //     }
    // //     //     maxx = Math.max(maxx, curr);
    // //     // }return maxx;

    // }
    // public int solve(int[] nums, int curr, int prev,Integer[][] dp){
    //     if(curr == nums.length) return 0;
    //     int take=0;
    //     if(dp[curr][prev+1] != null) return dp[curr][prev+1];
    //     if(prev==-1 || nums[curr]>nums[prev]){
    //         take = 1 + solve(nums,curr+1,curr,dp);
    //     }
    //     int notTake = solve(nums,curr+1,prev,dp);
    //     return dp[curr][prev+1] = Math.max(take,notTake);
    // }
}
