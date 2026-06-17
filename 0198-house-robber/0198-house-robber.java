class Solution {
    Integer[] dp;
    public int rob(int[] arr) {
        dp=new Integer[arr.length+1];
        return solve(arr,0);
    }
    private int solve(int [] arr, int i){
        if(i >= arr.length) return 0;
        if(dp[i]!=null) return dp[i];

        int rob = arr[i] + solve(arr,i+2);
        int notRob=solve(arr,i+1);

        return dp[i]=Math.max(rob,notRob);


    }
}