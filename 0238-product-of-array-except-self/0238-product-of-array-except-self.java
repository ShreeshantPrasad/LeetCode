class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int [] preSum1 = new int[n];
        int [] preSum2 = new int[n];
        Arrays.fill(preSum1,1);
        Arrays.fill(preSum2,1);
        for(int i=1;i<n;i++){
            preSum1[i] = preSum1[i-1] * nums[i-1];
        }
        for(int i=n-2;i>=0;i--){
            preSum2[i] = preSum2[i+1] * nums[i+1];
        }
        for(int i=0;i<n;i++){
            preSum1[i] = preSum1[i]*preSum2[i];
        }
        return preSum1;

        
    }
}