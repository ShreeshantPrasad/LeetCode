class Solution {

    public int longestArithSeqLength(int[] nums) {
        int n = nums.length;
        if (n <= 2) return n;
        int max = 1;

        // Length of the longest subsequence with a common difference.
        HashMap<Integer, Integer>[] dp = new HashMap[n];

        for (int i = 0; i < n; i++) {
            dp[i] = new HashMap<>();
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int diff = nums[i] - nums[j];
                int prev = dp[j].getOrDefault(diff, 1);
                int curr = prev + 1;

                dp[i].put(diff, curr);
                max = Math.max(max, dp[i].get(diff));
            }
        }

        return max;
    }
}