class Solution {
    Integer[][] dp;

    public int maxValue(int[][] events, int k) {
        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));
        dp = new Integer[events.length][k + 1];

        return helper(0, k, events);
    }

    public int helper(int idx, int k, int[][] events) {

        if (k == 0 || idx == events.length)
            return 0;

        if (dp[idx][k] != null)
            return dp[idx][k];

        int notTake = helper(idx + 1, k, events);

        int nextIndex = findIndex(idx + 1, events[idx][1], events);
        int take = events[idx][2] + helper(nextIndex, k - 1, events);

        return dp[idx][k] = Math.max(notTake, take);
    }

    public int findIndex(int left, int targetEnd, int[][] events) {

        int right = events.length - 1;
        int ans = events.length;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (events[mid][0] > targetEnd) {

                right = mid - 1;
                ans = mid;
            } else
                left = mid + 1;
        }

        return ans;
    }
}