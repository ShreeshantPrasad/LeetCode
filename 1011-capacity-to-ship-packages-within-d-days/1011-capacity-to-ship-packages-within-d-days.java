class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int high  = 0;
        int low = 0;

        int n = weights.length;

        for (int i = 0; i < n; i++) {
            high += weights[i];
            low = Math.max(low, weights[i]);
        }

        int ans = high;
        while (low <= high) {
            int mid = low + (high-low)/2;

            if (isPossible(weights, days, mid)){
                ans = mid;
                high = mid-1;
            } else {
                low = mid +1;
            }
        }
        return ans;
    }
    private boolean isPossible(int[] weights, int days, int capacity) {
        int actualDays = 1;
        int currentLoad = 0;
        for (int w : weights) {
            if (currentLoad + w > capacity) {
                actualDays++;
                currentLoad = w;
            } else {
                currentLoad += w;
            }
        }
        return actualDays <= days;
    }
}