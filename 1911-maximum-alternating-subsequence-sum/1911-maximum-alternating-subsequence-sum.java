class Solution {
    public long maxAlternatingSum(int[] nums) {
        long odd = 0;
        long even = 0;
        for(int i : nums){
            even = Math.max(even,odd+i);
            odd = even - i;
        }
        return even;
    }
}