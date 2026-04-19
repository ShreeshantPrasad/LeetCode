class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        int ans = 0;
        Map<Long,Integer> [] map = new HashMap[n];
        for(int i = 0; i < n; i++){
            map[i] = new HashMap<>();
            for(int j = 0; j<i; j++){
                long diff = (long) nums[i] - nums[j];
                int countAtJ = map[j].getOrDefault(diff,0);

                ans += countAtJ;
                map[i].put(diff, map[i].getOrDefault(diff,0) + countAtJ + 1);
            }
        }
        return ans;
    }
}