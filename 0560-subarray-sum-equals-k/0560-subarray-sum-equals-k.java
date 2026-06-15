class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int pref = 0, cnt = 0;
        for(int i : nums){
            pref += i;
            if(map.containsKey(pref-k)){
                cnt += map.get(pref-k);
            }
            map.put(pref,map.getOrDefault(pref,0)+1);
        }
        return cnt;
    }
}