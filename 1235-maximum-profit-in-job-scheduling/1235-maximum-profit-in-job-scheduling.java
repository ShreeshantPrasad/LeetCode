class Solution {
    int n;
    Integer[] dp;
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        n = profit.length;
        dp = new Integer[n+1];
        int [][] arr = new int[n][3];
        for(int i = 0; i < n ; i++){
            arr[i][0] = startTime[i];
            arr[i][1] = endTime[i];
            arr[i][2] = profit[i];
        }
        Arrays.sort(arr, (a,b) -> a[0] - b[0]);
        return solve(arr, 0);
    }
    private int solve(int[][] arr, int i){
        if(i >= n) return 0;
        if(dp[i] != null) return dp[i];
        int nextIdx = next(arr,i+1,arr[i][1]);
        int take = arr[i][2] + solve(arr,nextIdx);
        int notTake = solve(arr, i+1);
        return dp[i] = Math.max(take,notTake);
    }
    private int next(int[][] arr, int l, int target){
        int r = n - 1;
        int ans = n+1;
        while(l <= r){
            int mid = l + (r-l)/2;
            if(arr[mid][0] >= target){
                ans = mid;
                r = mid-1;
            }else{
                l = mid+1;
            }
        }
        return ans;
    }
}