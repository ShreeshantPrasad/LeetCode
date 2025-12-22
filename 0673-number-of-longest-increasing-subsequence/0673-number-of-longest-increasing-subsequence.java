class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n=nums.length;
        int[] dp=new int[n];
        Arrays.fill(dp,1);
        int[] count=new int[n];
        Arrays.fill(count,1);
        int maxx=1;
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j] && dp[i]<dp[j]+1){
                    dp[i] = dp[j]+1;
                    count[i] = count[j];
                    maxx=Math.max(maxx,dp[i]);
                }else if(nums[i]>nums[j] && dp[i] == dp[j]+1){
                    count[i] += count[j]; 
                }
            }
            
        }
        int nls=0;
        for(int i=0;i<n;i++){
            if(dp[i]==maxx){
                nls += count[i];
            }
        }
        return nls;
    }
}