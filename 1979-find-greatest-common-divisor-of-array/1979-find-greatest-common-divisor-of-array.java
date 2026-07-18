class Solution {
    public int findGCD(int[] nums) {
        int low = 1001;
        int high = 0;
        for(int i : nums){
            low = Math.min(low, i);
            high = Math.max(high, i);
        }
        return gcd(low, high);
    }
    private int gcd(int a, int b){
        return (b == 0) ? a : gcd(b, a%b);
    }
}