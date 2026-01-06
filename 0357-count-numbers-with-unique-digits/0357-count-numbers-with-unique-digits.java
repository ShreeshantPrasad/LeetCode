class Solution {
    static final int len = 10;
    static final int mask = 1024;
    public int countNumbersWithUniqueDigits(int n) {
        int num = (int)Math.pow(10, n);
        String s = String.valueOf(num-1);
        Integer[][][][][] dp = new Integer[len][2][2][mask][2];
        int ans = solve(s, 0, 1, 0, 0, 1, dp); //str, idx, rept, tight, mask, lz, dp
        return num-ans;
    }
    public int solve(String s, int idx, int tight, int rept, int mask, int lz, Integer[][][][][] dp){
        if(idx == s.length()){
            return rept;
        }
        if(dp[idx][tight][rept][mask][lz] != null) return dp[idx][tight][rept][mask][lz];
        int lb = 0;
        int ub = (tight==1) ? s.charAt(idx)-'0':9;

        int res = 0;
        for(int dig=lb; dig<=ub; dig++){
            int newTight = (tight == 1 && dig == ub) ? 1 : 0;
            if(lz == 1 && dig == 0){
                res+=solve(s, idx+1, newTight, rept, mask, lz, dp);
            }else {
                int isDigUsed = 1 & (mask>>dig);
                int newRept = (rept == 1 || isDigUsed == 1)?1:0;
                int newMask = (1<<dig)|mask;
                res += solve(s, idx+1, newTight, newRept, newMask, 0, dp);
            }
        }
        return dp[idx][tight][rept][mask][lz]= res;
    }
}