class Solution {
    Integer[][][] dp;
    public int atMostNGivenDigitSet(String[] digits, int n) {
        String s = String.valueOf(n);
        int mask =0;
        for(int i=0; i<digits.length; i++){
            int dig = Integer.parseInt(digits[i]);
            mask = (mask | (1<<dig));
        }
        dp = new Integer[s.length()][2][2];
        return solve(s, 0, 1, 1, mask, dp)-1;
    }
    public int solve(String s, int idx, int tight, int lz, int mask, Integer[][][] dp){
        if(idx == s.length()){
            return 1;
        }
        if(dp[idx][tight][lz] != null) return dp[idx][tight][lz];
        int lb = 0;
        int ub = (tight==1) ? s.charAt(idx)-'0' : 9;
        int res = 0;

        for(int dig=lb; dig<=ub; dig++){
            int newTight = (tight == 1 && dig == ub) ? 1 : 0;
            if(lz == 1 && dig == 0){
                res+=solve(s, idx+1, newTight, lz, mask, dp);
            }else {
                int isDigUsed = 1 & (mask>>dig);
                if(isDigUsed == 0){
                    continue;
                }
                else {
                    res+=solve(s, idx+1, newTight, 0, mask, dp);
                }
            }
        }
        return dp[idx][tight][lz] = res;
    }
}