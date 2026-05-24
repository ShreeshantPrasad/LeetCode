class Solution {
    int n;
    Integer [] dp;
    public int maxJumps(int[] arr, int d) {
        n = arr.length;
        int ans = 1;
        dp = new Integer[n+1];
        for(int i = 0; i < n; i++){
            ans = Math.max(ans,solve(arr,i,d));
        }
        return ans;
    }
    private int solve(int [] arr, int i, int d){
        if(dp[i] != null) return dp[i];
        int ans = 1;

        //Left
        for(int j = i-1; j >= Math.max(0,i-d); j--){
            if(arr[j] >= arr[i]) break;
            ans = Math.max(ans, 1 + solve(arr,j,d));
        }

        //Right
        for(int j = i+1; j <= Math.min(n-1,i+d); j++){
            if(arr[j] >= arr[i]) break;
            ans = Math.max(ans, 1 + solve(arr, j, d));
        }
        return dp[i] = ans;
    }
}