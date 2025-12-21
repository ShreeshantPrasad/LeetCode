// class Solution {
//     public int numDistinct(String s, String t) {
//         int n=s.length();
//         int m=t.length();
//         return solve(n-1,m-1,s,t);
        
//     }
//     public static int solve(int i,int j,String s,String t)
//     {// i=s, t==j
//         if( j<0) return 1;
//         if( i<0) return 0;

//         if( s.charAt(i)==t.charAt(j) )
//         {
//             return solve( i-1, j-1,s,t)+solve( i-1, j,s,t);
//         }
//         else
//         {
//             return solve(i-1,j,s,t);
//         }
        
//     }
// }
// //memosiation
// class Solution {
//     public int numDistinct(String s, String t) {
//         int n=s.length();
//         int m=t.length();
//         int [][] dp=new int [n+1][m+1];
//         for(int i=0;i<n+1;i++)
//         {
//             for(int j=0;j<m+1;j++)
//             {
//                 dp[i][j]=-1;
//             }
//         }
//         return solve(n-1,m-1,s,t,dp);
        
//     }
//     public static int solve(int i,int j,String s,String t,int [][] dp)
//     {// i=s, t==j
//         if( j<0) return 1;
//         if( i<0) return 0;
//         if( dp[i][j]!=-1)
//         {
//             return dp[i][j];
//         }

//         if( s.charAt(i)==t.charAt(j) )
//         {
//             dp[i][j]=solve( i-1, j-1,s,t,dp)+solve( i-1, j,s,t,dp);
//             return dp[i][j];
//         }
//         dp[i][j]=solve(i-1,j,s,t,dp);
//         return dp[i][j];
        
//     }
// }


//Tabulation
class Solution {
    public int numDistinct(String s, String t) {
        int n=s.length();
        int m=t.length();
        int [][] dp=new int [n+1][m+1];
        for(int i=0;i<n+1;i++){
            dp[i][0]=1;
        }
        for(int i=0;i<m+1;i++){
            dp[0][i]=0;
        }
        dp[0][0]=1;
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if( s.charAt(i-1)==t.charAt(j-1) ){
                    dp[i][j]=dp[i-1][j-1]+dp[i-1][j];
                }
                else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[n][m];
    }
}