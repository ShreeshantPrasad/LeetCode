// class Solution {
//     public boolean increasingTriplet(int[] nums) {
//         int n=nums.length;
//         for(int i = 0;i<n;i++){
//             boolean small = false;
//             boolean large = false;
//             for(int j=0;j<i;j++){
//                 if(nums[j]<nums[i]) small = true;
//             }
//             for(int k=i;k<n;k++){
//                 if(nums[i]<nums[k]) large = true;
//             }
//             if(small && large) return true;
//         }
//         return false;
//     }
// }
class Solution {
    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        int[] pre = new int[n];
        int[] suf = new int[n];
        pre[0] = nums[0];
        suf[n-1] = nums[n-1];
        
        for(int i=1; i<n; i++){
            pre[i] = Math.min(nums[i], pre[i-1]);
        }
        for(int i=n-2; i>=0;i--){
            suf[i] = Math.max(nums[i], suf[i+1]);
        }
        boolean ans = false;
        for(int i=0; i<n; i++){
            if(nums[i] > pre[i] && nums[i]<suf[i]){
                ans = true;
            }
        }
        return ans;
    }
}