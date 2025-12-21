class Solution {
    public boolean isMatch(String s, String p) {
        int n=s.length();
        int m=p.length();
        Boolean [][] dp=new Boolean [n+1][m+1];
        return solve(n,m,s,p,dp);
    }
    public boolean solve(int i,int j, String s, String p, Boolean [][] dp){
        if(j==0) return (i==0);

        if( dp[i][j]!=null){
            return dp[i][j];
        }
        if(i==0){
            for(int k=j; k>0; k--){
                if(p.charAt(k-1)!='*')return false;
            }
            return true;
        }
        char ch = p.charAt(j-1);
        if(s.charAt(i-1)== ch || ch == '?'){
            return dp[i][j] = solve(i-1,j-1,s,p,dp);
        }
        else if(ch == '*'){
            return dp[i][j] = (solve(i-1,j,s,p,dp) || solve(i,j-1,s,p,dp));
        }
        else{
            return dp[i][j] = false;
        }
    }
}