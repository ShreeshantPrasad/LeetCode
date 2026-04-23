class Solution {
    public long[] getDistances(int[] nums) {
        long [] ans = new long[nums.length];
        HashMap<Integer,Long> idxSum = new HashMap<>();
        HashMap<Integer,Long> idxCount = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            long freq = idxCount.getOrDefault(nums[i], 0L);
            long sum = idxSum.getOrDefault(nums[i], 0L);

            ans[i] += freq*i - sum;

            idxSum.put(nums[i],idxSum.getOrDefault(nums[i],0l) + (long) i);
            idxCount.put(nums[i],idxCount.getOrDefault(nums[i],0l)+1);
        }
        idxSum.clear();
        idxCount.clear();
        for(int i = nums.length - 1; i >= 0; i--){
            long freq = idxCount.getOrDefault(nums[i], 0L);
            long sum = idxSum.getOrDefault(nums[i], 0L);

            ans[i] += sum - freq*i;

            idxSum.put(nums[i],idxSum.getOrDefault(nums[i],0l) + (long) i);
            idxCount.put(nums[i],idxCount.getOrDefault(nums[i],0l)+1);
        }
        return ans;
    }
}