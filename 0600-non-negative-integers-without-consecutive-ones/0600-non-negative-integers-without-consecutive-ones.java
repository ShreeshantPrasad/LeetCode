class Solution {
    public int findIntegers(int n) {
        String s = Integer.toBinaryString(n);
        Integer[][][] dp = new Integer[30][2][2]; //10^9 -> 111011100110101100101000000000 = 30(length) OR s.length()
        return solve(s, 0, 1, 0,dp); // idx, tight, prev
    }
    public int solve(String s, int idx, int tight, int prev, Integer[][][] dp){
        if(idx == s.length()){
            return 1;
        }
        if(dp[idx][tight][prev] != null) return dp[idx][tight][prev];
        int lb = 0;
        int ub = (tight==1) ? s.charAt(idx)-'0':1;
        int res = 0;
        for(int dig=lb; dig<=ub; dig++){
            if(prev==1 && dig==1){
                continue;
            }
            int newTight = (tight==1 && dig == ub)?1:0;
            res+=solve(s, idx+1, newTight, dig, dp);
        }
        return dp[idx][tight][prev] = res;
    }
}