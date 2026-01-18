// class Solution {
//     static int solve(int i, int j, ArrayList<Integer> a, Integer [][] dp) {
//         if (i > j) return 0;
//         if(dp[i][j]!= null) return dp[i][j];
//         int maxi = Integer.MIN_VALUE;
//         for (int ind = i; ind <= j; ind++) {
//             int cost = a.get(i - 1) * a.get(ind) * a.get(j + 1)
//                        + solve(i, ind - 1, a,dp) + solve(ind + 1, j, a,dp);
//             maxi = Math.max(maxi, cost);
//         }
//         return dp[i][j] = maxi;
//     }
//     public int maxCoins(int[] nums) {
//         int n = nums.length;
//         ArrayList<Integer> arr = new ArrayList<>();
//         for (int i : nums){
//             arr.add(i);
//         }
//         arr.add(1);
//         arr.add(0,1);

//         Integer[][] dp = new Integer[n + 2][n + 2];
//         return solve(1, n, arr,dp);
//     }
// }
class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i : nums){
            arr.add(i);
        }
        arr.add(1);
        arr.add(0,1);

        int[][] dp = new int[n + 2][n + 2];
        
        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= n; j++) {
                if (i > j) continue;
                int maxi = Integer.MIN_VALUE;
                
                for (int ind = i; ind <= j; ind++) {
                    int cost = arr.get(i - 1) * arr.get(ind) * arr.get(j + 1) +
                               dp[i][ind - 1] + dp[ind + 1][j];
                    maxi = Math.max(maxi, cost);
                }
                dp[i][j] = maxi;
            }
        }
        return dp[1][n];
    }
}