class Solution {
    public int countDigitOne(int n) {
        String num = String.valueOf(n);
        Integer [][][] dp= new Integer[11][2][10];
        return solve(num,0,1,0,dp);
    }
    public int solve(String s,int idx,int tight, int cnt,Integer [][][] dp){
        if(idx == s.length()) return cnt;
        if(dp[idx][tight][cnt] != null) return dp[idx][tight][cnt];
        int lb = 0;
        int ub =(tight == 1) ? s.charAt(idx)-'0' : 9;
        int res = 0;
        for(int digit = lb; digit <= ub; digit++){
            int newTight = (tight == 1 && digit == ub) ? 1 : 0;
            if(digit == 1){
                res += solve(s,idx+1,newTight,cnt+1,dp);
            }else{
                res += solve(s,idx+1,newTight,cnt,dp);
            }
        }
        return dp[idx][tight][cnt] = res;
    }
}