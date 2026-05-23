class Solution {
    public boolean check(int[] nums) {
        int w=0;
        for(int i=0; i<nums.length-1; i++){
            if(nums[i]>nums[i+1]){
                w++;
            }
        }
        if(nums[0]<nums[nums.length-1] && w==1){
            return false;
        }
        if(w==0 || w==1) return true;
        return false;
    }
}