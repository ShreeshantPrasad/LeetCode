class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int max = 0;
        int zeros = 0;
        int length= 0;
        while(left < nums.length && right < nums.length ){
            if(nums[right] == 0){
                zeros++;
            }
            while(zeros > k){
                if(nums[left]==0) zeros--;
                left++;
            }
            if(zeros <= k){
                length = right-left+1;
            }
            max = Math.max(max,length);
            right++;
        }
        return max;
    }
}