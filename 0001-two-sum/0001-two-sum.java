class Solution {
    public int[] twoSum(int[] nums, int target) {
        int [] ans = new int[2];
        ans[0]=ans[1]=-1;
        HashMap<Integer,Integer> mpp = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int num = nums[i];
            int remainingNum = target - num;
            if(mpp.containsKey(remainingNum)){
                ans[0] = mpp.get(remainingNum);
                ans[1] = i;
                return ans;
            }
            mpp.put(nums[i],i);
        }
        return ans;
    }
}