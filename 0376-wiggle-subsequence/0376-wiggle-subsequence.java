class Solution {
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        if(n <= 1) return n;
        if(n == 2 && nums[0] != nums[1]) return 2;
        int prev = nums[1]- nums[0];
        int count = 1;
        if(prev != 0) count = 2;
        for(int i = 2; i < n; i++){
            int diff = nums[i] - nums[i-1];
            if(diff > 0 && prev <= 0 || diff < 0 && prev >= 0){
                count++;
                prev = diff; 
            }
        }
        return count;
    }
}