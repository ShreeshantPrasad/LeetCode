class Solution {
    Integer [][] dp;
    public int longestPalindromeSubseq(String s) {
        String s1 = new StringBuilder(s).reverse().toString();
        dp= new Integer [s.length()][s.length()];
        return helper(s, s1, 0, 0);
    }

    public int helper(String s, String s1, int i, int j){
        if(i>s.length()-1 || j>s1.length()-1) return 0;
        if(dp[i][j]!=null) return dp[i][j];
        if(s.charAt(i)==s1.charAt(j)){
            return dp[i][j]=1+ helper(s, s1, i+1, j+1);
        }
        else{
            return dp[i][j]=Math.max(helper(s, s1, i+1, j), helper(s, s1, i, j+1));
        }
    }

}