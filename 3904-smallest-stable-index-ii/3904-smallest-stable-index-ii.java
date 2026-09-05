class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int [] l = new int[n];
        int [] r = new int[n];
        l[0] = nums[0];
        r[n-1] = nums[n-1];
        for(int i = 1; i<n; i++){
            l[i] = Math.max(l[i-1], nums[i]);
        }
        for(int i = n-2; i >= 0;  i--){
            r[i] = Math.min(r[i+1], nums[i]);
        }
        for(int i = 0;  i<n; i++){
            if((l[i]-r[i]) <= k) return i;
        }
        return -1;
    }
}