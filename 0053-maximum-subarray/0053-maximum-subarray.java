class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int ans = Integer.MIN_VALUE;
        for(int i : nums){
            sum += i;
            ans = Math.max(ans, sum);
            sum = sum < 0 ? 0 : sum;
        }
        return ans;
    }
}