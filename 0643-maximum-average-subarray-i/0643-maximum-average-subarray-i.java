class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double sum =0;
        for(int i = 0; i < k; i++){
            sum += (double) nums[i];
        }
        int left = 0;
        double avg = sum/k;
        for(int right = k; right < nums.length; right++){
            sum = sum + nums[right] - nums[left++];
            avg = Math.max(avg, sum/k);
        }
        return avg;

        
    }
}