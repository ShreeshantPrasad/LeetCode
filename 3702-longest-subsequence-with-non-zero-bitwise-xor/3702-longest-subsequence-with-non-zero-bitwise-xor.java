class Solution {
    public int longestSubsequence(int[] nums) {
        int xor=0;
        int n = nums.length;
        boolean isZero = true;
        for(int i=0;i<n;i++){
            xor ^= nums[i];
            if(nums[i]!=0) isZero=false;
        }
        if(isZero){
            return 0;
        }
        if(xor!=0){
            return n;
        }
        else{
            return n-1;
        }
    }
}