class Solution {

    public int longestArithSeqLength(int[] nums) {
        int n=nums.length;
        int[][] dp=new int[n][1001];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],1);
        }
        int ans=1;

        for(int curr = 1; curr < dp.length; curr++){
            
            for(int prev = 0; prev < curr; prev++){

                int diff = nums[curr]-nums[prev];
                int diffIdx = diff + 500;
                if(dp[curr][diffIdx]<dp[prev][diffIdx]+1){
                    dp[curr][diffIdx] = 1 + dp[prev][diffIdx];
                    ans=Math.max(ans,dp[curr][diffIdx]);
                }
            }
        }
        return ans;
    }
}