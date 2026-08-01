class Solution {
    private int help(int i,int j,int[] nums){
        if(i==j) return nums[i];
        int first = nums[i] - help(i+1,j,nums);
        int second = nums[j] - help(i,j-1,nums);
        return Math.max(first,second);
    }
    public boolean predictTheWinner(int[] nums) {
        int win=help(0,nums.length-1,nums);
        return win>=0;
    }
}