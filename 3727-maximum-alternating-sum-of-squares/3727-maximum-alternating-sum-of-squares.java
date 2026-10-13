class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        for(int i=0;i<n;i++){
            nums[i] = nums[i]*nums[i];
        }
        Arrays.sort(nums);
        long score=0;
        boolean flag=true;
        int l=0;
        int r=n-1;
        while(l<=r){
            if(flag){
                score += (long) nums[r];
                flag= !flag;
                r--;
            }else{
                score -= (long)nums[l];
                flag= !flag;
                l++;
            }
            
        }
        return score;
    }
}