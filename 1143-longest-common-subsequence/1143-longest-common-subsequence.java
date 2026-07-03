// class Solution {
//     public int longestCommonSubsequence(String text1, String text2) {
//         return helper(text1,text2,text1.length()-1,text2.length()-1);
//     }
//     public int helper(String s1, String s2, int i, int j){
//         if(i<0 || j<0){
//             return 0;
//         } 
//         if(s1.charAt(i) == s2.charAt(j)){
//             return 1 + helper(s1,s2,i-1,j-1);
//         }
//         else{
//             return Math.max(helper(s1,s2,i,j-1),helper(s1,s2,i-1,j));
//         }
//     }
// }
// class Solution {
//     public int longestCommonSubsequence(String text1, String text2) {
//         int n = text1.length();
//         int m = text2.length();
//         Integer [][] dp = new Integer[n][m]; 
//         return helper(text1,text2,n-1,m-1,dp);
//     }
//     public int helper(String s1, String s2, int i, int j,Integer [][] dp){
//         if(i<0 || j<0){
//             return 0;
//         } 
//         if(dp[i][j] != null) return dp[i][j];
//         if(s1.charAt(i) == s2.charAt(j)){
//             return dp[i][j] = 1 + helper(s1,s2,i-1,j-1,dp);
//         }
//         else{
//             return dp[i][j] = Math.max(helper(s1,s2,i,j-1,dp),helper(s1,s2,i-1,j,dp));
//         }
//     }
// }
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        Integer [][] dp = new Integer[n+1][m+1]; 
        for(int i=0;i <=n;i++) dp[i][0] = 0;
        for(int j=0;j <=m;j++) dp[0][j] = 0;
        for(int i=1;i <=n;i++){
            for(int j=1; j<= m; j++){
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                
            }
        } 
        return dp[n][m];
    }
}