class Solution {
    Integer[][] dp;
    public int minDifficulty(int[] jd, int d) {
        if(jd.length < d) return -1;
        int n = jd.length;
        dp = new Integer[1001][11];

        return helper(jd, 0, d);
    }
    private int helper(int [] jd, int idx, int d){
        if(d == 1){
            int maxD = jd[idx];
            for(int j = idx; j < jd.length; j++){
                maxD = Math.max(jd[j], maxD);
            }
            return maxD;
        }
        if(dp[idx][d] != null)return dp[idx][d];
        int maxD = jd[idx];
        int ans = Integer.MAX_VALUE;
        for(int i = idx; i <= jd.length - d; i++){
            maxD = Math.max(maxD, jd[i]);
            int result = maxD + helper(jd,i+1,d-1);
            ans = Math.min(ans,result);
        }

        return dp[idx][d] = ans;
    }
}