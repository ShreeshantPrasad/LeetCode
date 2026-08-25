class Solution {
    public int missingMultiple(int[] nums, int k) {
        HashSet<Integer> hs = new HashSet<>();
        for(int e : nums) hs.add(e);
        int mul = k;
        while(true){
            if(!hs.contains(mul)){
                return mul;
            }
            mul += k;
        }
    }
}