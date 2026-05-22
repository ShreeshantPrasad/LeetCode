class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int l = 0; 
        int r = n-1;
        while(l<r){
            int mid = l + (r-l)/2;
            if(nums[mid] > nums[r]){
                l = mid+1;
            }else{
                r = mid;
            }
        }
        int pivot = r;
        int ans = Math.max(bs(nums,target,0,pivot-1),bs(nums,target,pivot,n-1));
        return ans;
    }
    private int bs(int [] nums,int target, int l, int r){
        while(l<=r){
            int mid = l + (r-l)/2;
            if(nums[mid] == target) return mid;
            else if(nums[mid] < target) l = mid+1;
            else r = mid-1; 
        }
        return -1;
    }
}