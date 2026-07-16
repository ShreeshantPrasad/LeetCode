class Solution {
    public long gcdSum(int[] nums) {
        int n =nums.length;
        int [] pre = new int[n];
        int max = 0;
        for(int i =0; i < n; i++){
            max = Math.max(max,nums[i]);
            pre[i] = gcd(nums[i],max);
        }
        Arrays.sort(pre);
        long ans = 0;
        int left = 0;
        int right =n-1;
        while(left<right){
            ans += gcd(pre[left],pre[right]);
            left++;
            right--;
        }
        return ans;
    }
    private int gcd(int i, int j){
        if(j == 0) return i;
        return gcd(j,i%j);
    }
}