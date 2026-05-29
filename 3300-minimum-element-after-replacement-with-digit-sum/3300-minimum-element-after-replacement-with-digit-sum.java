class Solution {
    public int minElement(int[] nums) {
        int ans = 10001;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 9){
                nums[i] = sum(nums[i]);
            }
            ans = Math.min(ans,nums[i]);
        }
        return ans;
    }
    private int sum(int n){
        if(n <= 0) return 0;
        int ans = n%10 + sum(n/10);
        return ans;
    }
}