class Solution {
    public boolean canPlaceFlowers(int[] nums, int n) {
        int l = nums.length;
        for(int i=0; i<l; i++){
            if(nums[i]==0){
                if(i!=0 && nums[i-1]==0 && nums[i+1]==0){
                    n--;
                    nums[i]=1;
                }else if(i==0 && nums[i+1]==0){
                    n--;
                    nums[i]=1;
                }else if(i==l-1 && nums[i-1]==0){
                    n--;
                    nums[i]=1;
                }
                else{
                    continue;
                }

            }
        }
        return n<=0;
    }
}