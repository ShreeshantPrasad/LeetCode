class Solution {
    public int missingNumber(int[] nums) {
        int xr1 = 0;
        int xr2 = 0;
        for(int i = 0; i < nums.length; i++){
            xr1 ^= nums[i];
            xr2 ^= i;
        }
        xr2 ^= nums.length;
        return xr1^xr2;
    }
}