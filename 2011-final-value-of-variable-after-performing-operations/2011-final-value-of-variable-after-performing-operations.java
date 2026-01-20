class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int ans = 0;
        for (String x : operations) ans += (x.charAt(1) == '+' ? 1 : -1);
        return ans;
    }
}